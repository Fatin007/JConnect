/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fatin.jconnect;
import java.io.*;
import java.net.*;
import java.util.*;

public class Server {
    int port;
    String groupName=null;
    String password=null;

    private List<String> chatHistory = new ArrayList<>();

    private ServerSocket serverSocket;
    private List<ClientHandler> clients;

    public Server(int port, String groupName){
        this.port=port;
        this.groupName=groupName;
        
        try {
            String ip = InetAddress.getLocalHost().getHostAddress();
            System.out.println("Server IP: " + ip);
            System.out.println("Port: " + port);
            System.out.println("Server ready!!");
            System.out.println("Waiting for connections...");

            serverSocket = new ServerSocket(port);
            clients = new ArrayList<>();
            
//            new Client("127.0.0.1", groupName, name, port);

            while (true) {
                Socket socket = serverSocket.accept();
                PrintWriter pr = new PrintWriter(socket.getOutputStream());
                // pr.println(groupName);
                System.out.println("Client connected: " + socket.getInetAddress().getHostAddress());
                ClientHandler clientHandler = new ClientHandler(socket, this);
                clients.add(clientHandler);
                new Thread(clientHandler).start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public synchronized void broadcastMessage(String message, ClientHandler sender) {
        for (ClientHandler client : clients) {
            if (client != sender) {
                client.sendMessage(message);
            }
        }
    }

    public synchronized void removeClient(ClientHandler clientHandler) {
        clients.remove(clientHandler);
    }

    public synchronized void showOnline(ClientHandler sender) {
        String online = "Online ("+clients.size()+"): you, ";
        for (int i=0; i<clients.size(); i++) {
            if(clients.get(i) != sender) {
                online += clients.get(i).name + "(" + (i+1) + "), ";
            }
        }
        if(online.equals("Online (1): you, ")) online = "Online (1): Only you";
        else online = online.substring(0, online.length()-2);
        sender.sendMessage(online);
    }

    public synchronized void pointToPoint(String message, ClientHandler sender, int index) {
        for (int i=0; i<clients.size(); i++) {
            if(i == index-1 && clients.get(i) != sender) {
                clients.get(i).sendMessage(message);
                return;
            }
        }
        sender.sendMessage("\nUser not found\n. Use '/online' command to see the list of online users\n");
    }

    public synchronized void addChatHistory(String message) {
        chatHistory.add(message);
    }

    public synchronized void sendChatHistory(ClientHandler sender) {
        for (String message : chatHistory) {
            sender.sendMessage(message);
        }
    }

}

class ClientHandler implements Runnable {

    private Socket socket;
    private BufferedReader br;
    private PrintWriter pr;
    private Server server;
    public String name;
    public String gname;

    public ClientHandler(Socket socket, Server server) {
        this.socket = socket;
        this.server = server;
        this.gname=server.groupName;
        try {
            br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            pr = new PrintWriter(socket.getOutputStream(), true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        startReading();
        // startWriting();
    }

    public void startReading() {
        Runnable r1 = () -> {
            System.out.println("Reading thread started for client: " + socket.getInetAddress().getHostAddress());
            try {
                boolean flag = true;
                while (true) {
                    String msg = br.readLine();
                    int index = msg.indexOf("$");
                    boolean f=true;
                    for(int i=0; i<index; i++){
                        if(!Character.isDigit(msg.charAt(i))){
                            f=false;
                            break;
                        }
                    }
                    if(index!=-1 && index!=0 && index!=msg.length()-1 && f){
                        int i = Integer.parseInt(msg.substring(0, index));
                        String newMsg = this.name + msg.substring(index+1);
                        server.pointToPoint(newMsg, this, i);
                        continue;
                    }
                    if (msg.equals("/exit")) {
                        System.out.println("Client terminated the chat: " + socket.getInetAddress().getHostAddress());
                        server.broadcastMessage(this.name + " left the chat", this);
                        socket.close();
                        server.removeClient(this);
                        break;
                    }
                    else if(msg.equals("/help")){
                        this.sendMessage("Commands:\n/clear: Clear your chat\n/restore: Restore chat history\n/exit: Exit the chat\n/online: Show online users\n<index>$<message>: Send message to user at index");
                        continue;
                    }
                    else if(msg.equals("/online")){
                        server.showOnline(this);
                        continue;
                    }
                    else if(msg.equals("/restore")){
                        server.sendChatHistory(this);
                        continue;
                    }
                    else if (flag) {
                        this.name = msg;
//                        System.out.println("Client name set to: " + this.name);
                        this.sendMessage(this.gname);
                        server.sendChatHistory(this);
                        server.broadcastMessage(this.name + " joined the chat", this);
                        this.sendMessage("Type '/help' for commands");
                        server.showOnline(this);
                        flag = false;
                    } 
                    else {
//                        System.out.println(this.name + ": " + msg);
                        server.broadcastMessage(this.name + ": " + msg, this);
                        server.addChatHistory(this.name + ": " + msg);
                    }
                    // System.out.println("Client: " + msg);
                    // server.broadcastMessage(msg, this);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        };
        new Thread(r1).start();
    }

    public void startWriting() {
        // writing thread
        System.out.println("Writing thread started for client: " + socket.getInetAddress().getHostAddress());
        Runnable r2 = () -> {
            try {
                while (!socket.isClosed()) {
                    BufferedReader br1 = new BufferedReader(new InputStreamReader(System.in));
                    String out = br1.readLine();
                    pr.println(out);
                    pr.flush();
                    if (out.equals("exit")) {
                        socket.close();
                        break;
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        };
        new Thread(r2).start();
    }

    public void sendMessage(String message) {
        pr.println(message);
    }
}


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package fatin.jconnect;

/**
 *
 * @author moham
 */
import java.awt.Color;
import java.io.*;
import java.net.*;
import javax.swing.*;
import javax.swing.event.DocumentListener;
import javax.swing.text.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.event.DocumentEvent;
public class Client extends javax.swing.JFrame {
    String host=null;
    int port;
    String name=null;
    String groupName=null;
    String password=null;
    
    Socket socket;
    BufferedReader br;
    PrintWriter pr;
    

    /**
     * Creates new form Client
     */
    public Client() {
        initComponents();
    }
    
    
    public Client(String host, String name, int port){
        this.host=host;
        this.port=port;
        this.name=name;
        initComponents();
        sp.getViewport().setBackground(Color.decode("#0e1621"));
        tf.requestFocusInWindow();
        this.setTitle(name);
        // all.setVisible(false);
        this.addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent e){
            int confirmed = JOptionPane.showConfirmDialog(null, "Are yo u sure you want to exit?", "Exit Confirmation", JOptionPane.YES_NO_OPTION);

            if (confirmed == JOptionPane.YES_OPTION) {
                pr.println("/exit");
                pr.flush();
                System.exit(0);
            }
            }
        });
        try{
            System.out.println("Sending request to server...");
            socket = new Socket(host,port);
            br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            pr = new PrintWriter(socket.getOutputStream());
            if(socket.isConnected()){
                all.append("You are connected\n");
                pr.println(name);
                pr.flush();
            }
            else{
                all.append("Wromg port/IP\n");
                all.append("Connection failed\n");
                all.append("Please close the window and try again\n");

            }
            System.out.println("Connected to server!!");

            
            handleEvents();

            startReading();
            // startWriting();

        }
        catch(Exception e){
            e.printStackTrace();
        }
        
        
    }
    
    private void handleEvents() {
        tf.addKeyListener(new KeyListener(){
            public void keyTyped(KeyEvent e){

            }
            public void keyPressed(KeyEvent e){

            }
            public void keyReleased(KeyEvent e){
                if(e.getKeyCode()==10){
                    String contentToSend=tf.getText().trim();
                    
                    if(contentToSend.length()>0){
                        if(contentToSend.equals("/clear")){
                            all.setText("");
                            tf.setText("");
                            return;
                        }
                        if(contentToSend.equals("/exit")){
                            pr.println("/exit");
                            pr.flush();
                            System.exit(0);
                        }
                        all.append("Me: "+contentToSend+"\n");
                        
                        pr.println(contentToSend);
                        pr.flush();
                        tf.setText("");
                        tf.requestFocus();
                    }
                }
            }
        });
        all.getDocument().addDocumentListener(new DocumentListener(){
            @Override
            public void insertUpdate(DocumentEvent e) {
                all.setCaretPosition(all.getDocument().getLength());
            }
            @Override
            public void removeUpdate(DocumentEvent e) {
                // Do nothing for removal (optional handling)
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                // Not needed for JTextArea
            }
        });
    }
    
    public void startReading(){
        // reading thread 
        Runnable r1=()->{
            System.out.println("Reading thread started...");
            Boolean flag = true;
            try{
                while(true){
                    String msg = "";
                    msg = br.readLine();
                    System.out.println("Server: "+msg);
                    
                    if(flag){
                        gn.setText(msg);
                        flag=false;
                    }
                    else all.append(msg+"\n");

                }
            }
            catch(Exception e){
                e.printStackTrace();
            }
        };
        new Thread(r1).start();
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLayeredPane1 = new javax.swing.JLayeredPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        gn = new javax.swing.JLabel();
        sp = new javax.swing.JScrollPane();
        all = new javax.swing.JTextArea();
        jPanel3 = new javax.swing.JPanel();
        tf = new javax.swing.JTextField();

        javax.swing.GroupLayout jLayeredPane1Layout = new javax.swing.GroupLayout(jLayeredPane1);
        jLayeredPane1.setLayout(jLayeredPane1Layout);
        jLayeredPane1Layout.setHorizontalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jLayeredPane1Layout.setVerticalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                bye(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(14, 22, 33));

        jPanel2.setBackground(new java.awt.Color(23, 33, 43));

        gn.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        gn.setForeground(new java.awt.Color(245, 245, 245));
        gn.setText("Group Name");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(gn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(gn, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                .addContainerGap())
        );

        sp.setBackground(new java.awt.Color(14, 22, 33));
        sp.setToolTipText("");
        sp.setAutoscrolls(true);

        all.setEditable(false);
        all.setBackground(new java.awt.Color(14, 22, 33));
        all.setColumns(20);
        all.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        all.setForeground(new java.awt.Color(245, 245, 245));
        all.setRows(5);
        all.setWrapStyleWord(true);
        sp.setViewportView(all);

        jPanel3.setBackground(new java.awt.Color(23, 33, 43));
        jPanel3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(245, 245, 245), 2, true));

        tf.setBackground(new java.awt.Color(23, 33, 43));
        tf.setFont(new java.awt.Font("Verdana", 0, 16)); // NOI18N
        tf.setForeground(new java.awt.Color(245, 245, 245));
        tf.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 5, 1, 1));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tf)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(tf, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(sp, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sp, javax.swing.GroupLayout.DEFAULT_SIZE, 433, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void bye(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_bye
        // TODO add your handling code here:
        pr.println(name+" left");
        pr.flush();
    }//GEN-LAST:event_bye

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Client.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Client.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Client.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Client.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Client().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea all;
    private javax.swing.JLabel gn;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane sp;
    private javax.swing.JTextField tf;
    // End of variables declaration//GEN-END:variables
}

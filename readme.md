# JConnect

JConnect is a Java-based chat application utilizing socket programming, multi-threading, and Java Swing for its graphical user interface. Designed to support real-time messaging across multiple clients, this project showcases core concepts of client-server architecture and concurrent programming, providing a user-friendly chat interface.

## Features
- **Multiple Client Support**: Allows multiple clients to connect and chat in real-time.
- **Multiple Server Capability**: Any user can host a chat group on their own PC.
- **Point to point chat**: Point to point chat also allowed
- **Chat History**: Messages are stored so that late joiners can access past conversations.
- **Swing UI**: Includes a graphical interface built with Java Swing (interface design is functional but may be improved).

## Technologies Used
- **Java Socket Programming**: For managing server-client connections and real-time communication.
- **Multi-threading**: Supports concurrent connections using individual threads per client.
- **Java Swing**: Provides a basic, functional graphical user interface for both server and client.

## Installation

Follow these steps to set up and run JConnect on your local machine:

### Prerequisites
- **Java JDK 21** or higher installed on your system.
- **Maven** (if your project uses Maven for dependency management).
- **IDE** (recommended: NetBeans, IntelliJ IDEA, or Eclipse).

### Steps

1. **Clone the Repository**
   - Open a terminal and run the following command to clone the JConnect repository:
     ```bash
     git clone https://github.com/Fatin007/JConnect.git
     cd JConnect
     ```
   - Alternatively, you can download the repository as a ZIP file and extract it.

2. **Open the Project in Your IDE**
   - Open your preferred IDE (here, we’ll use NetBeans).
   - Import the project into NetBeans or any other IDE you are comfortable with.

## Running the Application

- **Step 1**: Run the project in the IDE.  
  <img width="729" alt="1" src="https://github.com/user-attachments/assets/7d274978-32f0-466d-b6ae-7b02090a6f84">

- **Step 2**: Click on the **Create Group** button to create a group. This will start the server on your PC. Share the **Server IP** and **Port** with your friends to allow them to join.  
  <img width="547" alt="2" src="https://github.com/user-attachments/assets/dadf29bb-986b-469d-985e-4b459ee4b882">

- **Step 3**: Run the project again to open a new instance.  

- **Step 4**: Click on **Join Group** to join the created group.  
  <img width="594" alt="3" src="https://github.com/user-attachments/assets/742e1ab7-9f37-45f9-8977-ca538c9b5050">

- **Step 5**: Type `/help` in the chat to see all available commands.  
  <img width="335" alt="4" src="https://github.com/user-attachments/assets/fbc8a61d-83f5-4a27-8f19-043eba8218af">

### Running the Application without an IDE
You can also run the application by executing the JAR file directly if Java is installed on your system. Simply download the JAR file from the link below and run it:

[JConnect-1.0-SNAPSHOT.jar](https://github.com/Fatin007/JConnect/blob/main/target/JConnect-1.0-SNAPSHOT.jar)

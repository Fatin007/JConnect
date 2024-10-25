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

3. **Running the Application**
   - Run the project in the IDE.
   - Click on the **Create Group** button to create a group. This will start the server on your PC. Share the **Server IP** and **Port** with your friends to allow them to join.
   - Run the project again to open a new instance.
   - Click on **Join Group** to join the created group.
   - Type `/help` in the chat to see all available commands.

### Running the Application without an IDE
You can also run the application by executing the JAR file directly if Java is installed on your system. Simply download the JAR file from the link below and run it:

[JConnect-1.0-SNAPSHOT.jar](https://github.com/Fatin007/JConnect/blob/main/target/JConnect-1.0-SNAPSHOT.jar)

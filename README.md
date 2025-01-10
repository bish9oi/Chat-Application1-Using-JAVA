Chat Application in Java


Overview:-
        This project is a chat application built using Java and Socket Programming, mimicking the basic functionality of WhatsApp. The application facilitates real-time communication between a Client and a Server with a graphical user interface (GUI) developed using Swing.

Features:-
          1.Real-Time Messaging: Exchange messages between client and server in real time.
          2.Graphical User Interface: Intuitive and user-friendly GUI.
          3.Timestamped Messages: Each message is displayed with its timestamp.
          4.Active Status Display: Shows active status of the users.
          5.Minimalistic Design: Compact and clutter-free design inspired by WhatsApp.

Prerequisites:-
               To run this application, ensure you have:
            1.Java Development Kit (JDK) installed (version 8 or later).
            2.A basic understanding of Java Swing and Socket Programming.


 How It Works:-
             Socket Communication:-
                         The application uses Sockets to establish communication between the client and the server:
                           1.Server:
                                    a.Listens for incoming client connections on a specified port.
                                    b.Receives messages from the client and sends responses back.
                           2.Client:
                                   a.Connects to the server via its IP address and port.
                                    b.Sends messages to the server and displays responses.
                                    ![Application Image](https://github.com/user-attachments/assets/ae5f06da-e25d-41cf-8f1c-c26f412650f9)

 GUI:-
    The user interface is created using Swing, which includes:
    
 1. Panels for structuring the layout.
 2. JLabels for displaying user details, messages, and timestamps.
 3.JTextField for inputting text messages.
 4.JButton for sending messages.

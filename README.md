Chat Application in Java

Overview

This project is a chat application built using Java and Socket Programming, mimicking the basic functionality of WhatsApp. The application facilitates real-time communication between a Client and a Server with a graphical user interface (GUI) developed using Swing.

Features:-
       1.Real-Time Messaging: Exchange messages between client and server in real time.
       2.Graphical User Interface: Intuitive and user-friendly GUI.
       3.Timestamped Messages: Each message is displayed with its timestamp.
       4.Active Status Display: Shows the active status of users.

Prerequisites

To run this application, ensure you have:

Java Development Kit (JDK) installed (version 8 or later).

A basic understanding of Java Swing and Socket Programming.

How It Works

Socket Communication

The application uses Sockets to establish communication between the client and the server:

1. Server

Listens for incoming client connections on a specified port.

Receives messages from the client and sends responses back.

2. Client

Connects to the server via its IP address and port.

Sends messages to the server and displays responses.

Application GUI

The user interface is created using Swing, which includes:

Panels for structuring the layout.

JLabels for displaying user details, messages, and timestamps.

JTextField for inputting text messages.

JButton for sending messages.

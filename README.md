![alt tag](https://raw.githubusercontent.com/zakupower/Java-Server-Address-Book/master/screens/screenshot1.jpg)
# Java-Server-Address-Book
An address book that connects to a server written in Java using JDBC

# Classes
+ ConnectionHelp - makes the connection to the server. Only one object of this class is created and the server is clossed in its finalize method
+ ServerAddressManager - generates the querries needed for the different operation
+ Person - this is the class for the data from and to the server
+ Controller - controls intefaces functionality
+ Main - starts the Application

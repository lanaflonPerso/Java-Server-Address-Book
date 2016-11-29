![alt tag](https://raw.githubusercontent.com/zakupower/Java-Server-Address-Book/master/screens/screenshot1.jpg)
# Java-Server-Address-Book
An address book that connects to a server written in Java using JDBC
Works with my localhost database - MariaDB
Uses only 1 table that stores all the data needed
Via the buttons you can manipulate the database
Add - adds an entry to the address book (on the database)
View - searches for an entry that contains the text entered in the name field.
View all - show all the entries on the server.
Remove - deletes an entry from the server (needs to be selected from the table)
Clear - clears the table
# Classes
+ ConnectionHelp - makes the connection to the server. Only one object of this class is created and the server is clossed in its finalize method
+ ServerAddressManager - generates the querries needed for the different operation
+ Person - this is the class for the data from and to the server
+ Controller - controls intefaces functionality
+ Main - starts the Application

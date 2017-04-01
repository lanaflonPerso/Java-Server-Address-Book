![alt tag](https://raw.githubusercontent.com/zakupower/Java-Server-Address-Book/master/screens/screenshot2.jpg)
# Java-Server-Address-Book</br>
An address book that connects to a server written in Java using JDBC for the database connection and JavaFx for the interface.</br>
Works with my localhost database</br>
Uses only 1 table that stores all the data needed</br>
Via the buttons you can manipulate the database</br>
Add - adds an entry to the address book (on the database)</br>
View - searches for an entry that contains the text entered in the name field.</br>
View all - show all the entries on the server.</br>
Remove - deletes an entry from the server (needs to be selected from the table)</br>
Clear - clears the table</br>
# Classes
+ ConnectionHelp - connects to server. - Singleton pattern
+ QueryBuilder - generates queries
+ Person - this is the class for the data from and to the server
+ Controller - controls fxml 
+ Main - Application

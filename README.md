# ToDoItem Application

Using Spring Boot, React, SQL Server and Bootstrap

# Developed with

- Spring boot
- Maven
- SQL Server
- React
- Intellij
- Visual studio code


# Requirements

- Node JS 16.13.0
- MSSQLSERVER
- Java 8 (Or greater)
- In react project, install the following modules:
	- npm install
	- npm install axios
	- npm install react-toastify
	- npm install react-router@5.2.0
	- npm install react-router-dom@5.2.0
	


# How to run

- Before running, create a database called "todoitem" in Microsoft SQL Server Management Studio and make sure that you have permission to read and write into "todoitem" database.
- Run ToDoListApplication.java to start Spring boot server (src\main\java\com\todolist\ToDoListApplication.java)
	- Port 8080
- To run react app, run the command "npm start" in the react project directory (src\frontend)
	- Port 3000

# Credentials

- If you want to use the default credentials, please run "testCreateUser" in UserControllerTest (src/test/java/com/todolist/testControllers/UserControllerTest.java)
	- Username: admin
	- Password: admin

- If you don't want to run "testCreateUser", just create a new account using Login Interface

# Preview

![image](https://user-images.githubusercontent.com/69126392/142767162-4d2a18fa-20b0-4c1d-8fb4-b41f8d2315fd.png)
![image](https://user-images.githubusercontent.com/69126392/142767177-a15e263d-42b3-480a-9606-b8b5cf082b9b.png)
![image](https://user-images.githubusercontent.com/69126392/142767181-d0a98865-0baf-4395-bbf7-a3df51892ee9.png)



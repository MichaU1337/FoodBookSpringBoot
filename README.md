## FoodbookSpringBoot is a backend for my cooking book project.

It consists of following technology/modules/add ons:

- Spring boot
- Spring JPA (Hibernate)
- Spring Security
- MySql - database
- Maildev - email server
- Swagger - API browser
- Bcrypt - secures the password
- Lombok

## How to run: 
- create mysql table at: mysql://localhost:3306/recipes (changable in application.properties file)
- install Maildev, default port is :1025 or :1080.

## How to use: 
- all operations require logging in. Create a user using /registration POST method or create the user directly in db. Link with account activation should show up in Maildev 
(if you don't want to use it, get response string and paste it in confirm method as a parameter in the browser).
- basic CRUD operations are under /recipes
- saved recipes are under /myrecipes

## TODO: 
- Add Gmail integration
- Add nutrition part of the app with calculator
- Correct mistakes and bugs, improve security by changing visibility

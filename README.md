# Tennis
This Kata implements a simple tennis game. Rules of the game are as follows:

Each player can have either of these points in one game 0 15 30 40
If you have 40 and you win the ball you win the game, however there are special rules.
If both have 40 the players are deuce.
a. If the game is in deuce, the winner of a ball will have advantage and game ball.
b. If the player with advantage wins the ball he wins the game
c. If the player without advantage wins they are back at deuce.

The project leverages Spring and Java in the backend and React JS in the frontend.

## Getting Started

Clone the repository by using the command:
git clone https://github.com/2021-DEV1-039/Tennis

### Prerequisites

Install maven to build the spring boot project. Refer https://maven.apache.org/install.html

Install npm to build the react project. Refer https://www.npmjs.com/get-npm

### Installing

Running the backend project

```
Go to Tennis directory
cd Tennis

Run the project using the maven command:
mvn spring-boot:run

Tha above step will run backend application on port 8080

```

Running the frontend project

```
Go to tennis-react-app directory
cd tennis-react-app

Build the project using the npm command:
npm install

Run the project using the npm command:
npm start

Tha above step will open a browser window and run the react application on port 3000

```

## Built With

* [Maven](https://maven.apache.org/) - Dependency Management
* [Java 8](https://www.oracle.com/java/technologies/java8.html) - Programming language for backend development
* [JUnit 5](https://junit.org/junit5/docs/current/user-guide/) - Testing Framework for Java based applications
* [Spring Boot 2.4.1](https://spring.io/projects/spring-boot) - Java Framework for building Spring based backend applications
* [React JS 17.0.1](https://reactjs.org/) - Javascript Library for Front end application 
* [NPM](https://www.npmjs.com/) - Node package manager

## Author

* **Ankit Kanwar** 

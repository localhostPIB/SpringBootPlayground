# Spring Boot Playground v0.5
Playground of destruction ;-)

## Getting Started (Mit Docker)
1) Sicherstellen, das Port 8080 frei ist. Ggf. laufende Container-Instanzen stoppen (oder Port bei Punkt 4 links von dem Doppelpunkt anpassen).
2) Terminal in dem Projekt-Ordner starten. ###  `mvn package ` ausfuehren
3) ### `docker build --tag playground .`
4) ### `docker run -d -p 8080:8080 --name playground playground`
5) Service ist (nach kurzem warten) auf [http://localhost:8080](http://localhost:8080) verfügbar.

## Built With
Für die spielerei nutze ich das Build-Management-Tool Maven(v. 3.6.3) von der Apache Software Foundation.
* [Maven](https://maven.apache.org/)

#### Vorraussetzungen
Um das "Projekt" zu starten werden die unten aufgeführten Frameworks und Libraries benötigt, welche in der `pom.xml` bereitgestellt sind und 
vor Programmstart (von Maven) runtergeladen werden (können). 


* [Spring-Boot](https://spring.io/projects/spring-boot)
* [Hibernate](https://hibernate.org/)
* ~~[H2 Database Engine](http://www.h2database.com/html/main.html)~~
* [MongoDB](https://www.mongodb.com)
* [Lombok](https://projectlombok.org/)
* [Junit 4](https://junit.org/junit4/)
* [Thymeleaf](https://www.thymeleaf.org/)
* [Bootstrap](https://getbootstrap.com/)
* [Commons IO](http://commons.apache.org/proper/commons-io/)



### System-Requirements

* ![Java 8](https://img.shields.io/badge/Java-8-green.svg) / ![](https://img.shields.io/badge/Java%20JDK-1.8-green)/ ![](https://img.shields.io/badge/Maven-3.6.3-green.svg)
* ![OSX](https://img.shields.io/badge/OS-OSX-green.svg) / ![Linux](https://img.shields.io/badge/OS-Linux-green.svg) / 
  ![Windows](https://img.shields.io/badge/OS-Windows-green.svg)


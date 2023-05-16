FROM openjdk:19-jdk 
MAINTAINER ALAN
COPY target/alanaruquipa-0.0.1-SNAPSHOT.jar alan-app.jar
ENTRYPOINT ["java","-jar","/alan-app.jar"]

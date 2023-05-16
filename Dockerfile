FROM amazoncorretto:8-alpine-jdk 
MAINTAINER ALAN
COPY target/alanaruquipa-0.0.1-SNAPSHOT.jar alan-app.jar
ENTRYPOINT ["java","-jar","/alan-app.jar"]

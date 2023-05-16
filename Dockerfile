FROM amazoncorretto:11-alpine-jdk 
MAINTAINER ALAN
COPY target/alanaruquipa-0.0.1-SNAPSHOT alan-app.jar
ENTRYPOINT ["java","-jar","/alan-app.jar"]

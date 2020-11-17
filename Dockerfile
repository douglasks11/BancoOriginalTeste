FROM openjdk:8
MAINTAINER DOUGLAS OLIVEIRA
COPY target/*.jar /var/www/app.jar
WORKDIR /var/www
ENTRYPOINT ["java", "-jar", "app.jar"]
FROM openjdk:17-oracle
LABEL MAINTAINER="fadelmpuluhulawa@gmail.com"
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} /app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]

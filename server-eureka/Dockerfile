FROM openjdk:17-oracle
ADD target/*.jar server-eureka.jar
ENTRYPOINT [ "java", "-jar", "server-eureka.jar" ]
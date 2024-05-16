FROM openjdk:17-oracle
ADD target/*.jar gateway-server-0.0.1-SNAPSHOT.jar
ENTRYPOINT [ "java", "-jar", "gateway-server-0.0.1-SNAPSHOT.jar" ]
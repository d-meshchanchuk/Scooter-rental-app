FROM openjdk:16-alpine

EXPOSE 8080

ARG JAR_FILE=target/scooterrentalapp-1.jar

WORKDIR /opt/app

COPY ${JAR_FILE} app1.jar

ENTRYPOINT ["java","-jar","app1.jar"]
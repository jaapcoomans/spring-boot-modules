FROM openjdk:11-slim

WORKDIR /opt/application

COPY ./*.jar ./application.jar

ENTRYPOINT java -jar application.jar
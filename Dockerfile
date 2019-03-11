FROM openjdk:8u181-slim

WORKDIR /opt/application

COPY ./*.jar ./application.jar

ENTRYPOINT java -jar application.jar
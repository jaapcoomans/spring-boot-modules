FROM adoptopenjdk/openjdk11:jre-11.0.3_7-alpine

WORKDIR /opt/application

COPY application/target/modules/3rdparty/* ./modules/
COPY application/target/modules/application/* ./modules/
COPY application/target/*.jar ./application.jar

ENTRYPOINT java -p /opt/application/:/opt/application/modules/ -m nl.jaapcoomans.boardgame.application
FROM openjdk:17
COPY target/neo-bank.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]

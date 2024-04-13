
FROM openjdk:11-jre-slim

WORKDIR /app

COPY target/project-0.0.1-SNAPSHOT.jar /app/

ENV secret=VG5aT1MyZ1FPdGJxY2c2NWFQeWp0dmNzOHdUdUduREw=

EXPOSE 8080

CMD ["java", "-jar", "project-0.0.1-SNAPSHOT.jar"]
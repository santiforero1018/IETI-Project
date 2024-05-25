FROM openjdk:17-slim

WORKDIR /app

COPY /target/project-0.0.1-SNAPSHOT.jar /app/

ENV JAVA_VERSION=17
ENV secret VG5aT1MyZ1FPdGJxY2c2NWFQeWp0dmNzOHdUdUduREw=


EXPOSE 8080

CMD ["java", "-jar", "project-0.0.1-SNAPSHOT.jar"]
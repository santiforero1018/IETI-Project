FROM openjdk:17-slim

WORKDIR /app

COPY /target/project-0.0.1-SNAPSHOT.jar /app/
COPY /app/wait.sh /app/

ENV JAVA_VERSION=17
ENV secret VG5aT1MyZ1FPdGJxY2c2NWFQeWp0dmNzOHdUdUduREw=
ENV user root
ENV password "1234"
ENV database IETI-Project

EXPOSE 8080

RUN apt-get update && apt-get install -y netcat
RUN chmod +x /app/wait.sh

CMD ["./wait.sh"]
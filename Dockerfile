FROM alpine:3.15.0
RUN apk add --no-cache openjdk17-jre

WORKDIR /app
COPY ./students-0.0.1.jar .
COPY ./application.yaml .
COPY ./loaded-students.csv .

CMD  ["java", "-jar", "students-0.0.1.jar"]

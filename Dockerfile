FROM openjdk:21-jdk-alphine

WORKDIR /app

COPY . /app

EXPOSE 8081

ENTRYPOINT ["java","-jar","/app/build/libs/flowershop-0.0.1-SNAPSHOT-plain.jar"]
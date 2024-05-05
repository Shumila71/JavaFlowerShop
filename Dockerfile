FROM openjdk:23-ea-18-jdk-oraclelinux9

WORKDIR /app

COPY . /app

EXPOSE 8081

ENTRYPOINT ["java","-jar","/app/build/libs/flowershop-0.0.1-SNAPSHOT.jar"]
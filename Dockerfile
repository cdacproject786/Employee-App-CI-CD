
FROM eclipse-temurin:20-alpine

LABEL mentainer="arbaazsayed1602@gmail.com"

WORKDIR /app

COPY target/employeeapp.jar /app/employeeapp.jar

ENTRYPOINT ["java", "-jar", "employeeapp.jar"]
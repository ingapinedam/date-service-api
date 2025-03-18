FROM openjdk:17-slim AS build

WORKDIR /app

# Copia los archivos del proyecto
COPY mvnw .
COPY .mvn .mvn
COPY pom.xml .
COPY src src

# Otorga permisos de ejecución al script Maven Wrapper
RUN chmod +x ./mvnw

# Compila el proyecto y omite las pruebas
RUN ./mvnw package -DskipTests

# Segunda etapa: imagen final más ligera
FROM openjdk:17-slim

WORKDIR /app

# Copia solo el JAR compilado de la etapa anterior
COPY --from=build /app/target/*.jar date-service-0.0.1-SNAPSHOT.jar

# Puerto para la aplicación
EXPOSE 8081

# Comando para ejecutar la aplicación
ENTRYPOINT ["java", "-jar", "date-service-0.0.1-SNAPSHOT.jar"]
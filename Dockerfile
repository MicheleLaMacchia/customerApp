# Usa la versione di base di OpenJDK 11
FROM openjdk:11

# Copia il JAR dell'applicazione nella directory /app
COPY target/customer-service-0.0.1-SNAPSHOT.jar /app/customer-service-0.0.1-SNAPSHOT.jar

# Imposta la directory di lavoro come /app
WORKDIR /app

# Esposizione della porta 8080
EXPOSE 8080

# Comando di avvio dell'applicazione
CMD ["java", "-jar", "customer-service-0.0.1-SNAPSHOT.jar"]
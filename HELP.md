
# COMANDI PER DOCKERIZZARE L'APP E COLLEGARLA AL DB MYSQL

## 1. CREARE L'IMMAGINE DOCKER DELL'APP CON IL SEGUENTE 

### 1.1 EFFETTUARE IL BUILD DELL'APP
mvn clean install -DskipTests

### 1.2 CREARE IL DOCKERFILE NEL ROOT DELL'APP E COPIARE I SEGUENTI COMANDI

#### Usa la versione di base di OpenJDK 11
FROM openjdk:11

#### Copia il JAR dell'applicazione nella directory /app
COPY target/customer-service-0.0.1-SNAPSHOT.jar /app/customer-service-0.0.1-SNAPSHOT.jar

#### Imposta la directory di lavoro come /app
WORKDIR /app

#### Esposizione della porta 8080
EXPOSE 8080

#### Comando di avvio dell'applicazione
CMD ["java", "-jar", "customer-service-0.0.1-SNAPSHOT.jar"]

### 1.3 CREARE L'IMMAGINE DOCKER
docker build -t customer-service:0.0.1 .

## 2. CREARE LA RETE ED ISTANZIARE I CONTAINER DELL'APP E DEL DB

### 2.1 CREARE LA DOCKER NETWORK 
docker network create customer-service-network

### 2.2 AVVIARE IL CONTAINER DELL'APP 
docker run -d --name mysql-container --network customer-service-network -e MYSQL_ROOT_PASSWORD=password -e MYSQL_DATABASE=customer-database mysql:latest

### 2.2 AVVIARE IL CONTAINER DEL DB
docker run -d --name customer-service-container --network customer-service-network -p 8080:8080 -e SPRING_DATASOURCE_URL=jdbc:mysql://mysql-container:3306/customer-database -e SPRING_DATASOURCE_USERNAME=root -e SPRING_DATASOURCE_PASSWORD=password customer-service:0.0.1

## 3. ACCEDERE AL DB PER CREARE LE TABLE ED INSERIRE RECORD DI PROVA

### 3.1 ACCEDERE AL DB
docker exec -it mysql-container mysql -p

### 3.2 LANCIARE I COMANDI PRESENTI NEL FILE: data.sql


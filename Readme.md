---

# Device Down Detector

## Description

This repository contains two projects that detect if a device is down by retrieving the IP addresses of the downed devices from a SQL database. The first project is a **Spring Boot application**, and the second is an **Azure Functions** project.

## How to Run

### Spring Boot Project

Follow these steps to run the Spring Boot project:

1. **Clone the repository:**

   ```bash
   git clone https://github.com/maheladissa/DeviceDownDetectorSpring.git
   ```

2. **Navigate to the Spring Boot project directory:**

   ```bash
   cd DeviceDownDetectorSpring
   ```

3. **Build the project:**

   ```bash
   AZURE_SQLSERVER_URL="your SQL server URL" \
   AZURE_SQLSERVER_USERNAME="your SQL server username" \
   AZURE_SQLSERVER_PASSWORD="your SQL server password" \
   mvn clean install
   ```

4. **Run the Spring Boot application:**

   ```bash
   AZURE_SQLSERVER_URL="your SQL server URL" \
   AZURE_SQLSERVER_USERNAME="your SQL server username" \
   AZURE_SQLSERVER_PASSWORD="your SQL server password" \
   mvn spring-boot:run
   ```

### Azure Functions Project

Follow these steps to run the Azure Functions project:

1. **Clone the repository:**

   ```bash
   git clone https://github.com/maheladissa/DeviceDownDetector.git
   ```

2. **Navigate to the Azure Functions project directory:**

   ```bash
   cd DeviceDownDetector
   ```

3. **Package the project:**

   ```bash
   AZURE_SQL_CONNECTIONSTRING="your SQL connection string" \
   mvn package
   ```

4. **Run the Azure Functions locally:**

   ```bash
   AZURE_SQL_CONNECTIONSTRING="your SQL connection string" \
   mvn azurefunctions:run
   ```

## How to Test via Postman

Postman collections for testing the API endpoints are available at the following locations:

- **Azure Functions:** [Azure Functions Postman Collection](https://github.com/pcgayan/AZBedRock/blob/main/DeviceDownDetector/Postman%20Collection/Azure%20Functions.postman_collection.json)
- **Spring Boot:** [Spring Boot Postman Collection](https://github.com/pcgayan/AZBedRock/blob/main/DeviceDownDetectorSpring/Postman%20Collection/Spring.postman_collection.json)

---
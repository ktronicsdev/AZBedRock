---

# Device Down Detector

## Description

This repository contains two projects that detect if a device is down by retrieving the IP addresses of the downed devices from a SQL database. The first project is a **Spring Boot application**, and the second is an **Azure Functions** project.

## How to Run

### Spring Boot Project

Follow these steps to run the Spring Boot project:

1. **Clone the repository:**

   ```bash
   git clone https://github.com/ktronicsdev/AZBedRock.git
   ```

2. **Navigate to the Spring Boot project directory:**

   ```bash
   cd AZBedRock
   ```

3. **Run the appropriate script based on your operating system:**

   - **Linux:**
     ```bash
     ./run_springboot_linux.sh
     ```

   - **Windows:**
     ```bash
     run_springboot_windows.bat
     ```

### Azure Functions Project

Follow these steps to run the Azure Functions project:

1. **Clone the repository:**

   ```bash
   git clone https://github.com/ktronicsdev/AZBedRock.git
   ```

2. **Navigate to the Azure Functions project directory:**

   ```bash
   cd AZBedRock
   ```

3. **Ensure that Azure Functions Core Tools are installed:**

   Before proceeding, make sure you have [Azure Functions Core Tools](https://docs.microsoft.com/azure/azure-functions/functions-run-local) installed on your machine.

4. **Run the appropriate script based on your operating system:**

   - **Linux:**
     ```bash
     ./run_azurefunctions_linux.sh
     ```

   - **Windows:**
     ```bash
     run_azurefunctions_windows.bat
     ```


## How to Test via Postman

Postman collections for testing the API endpoints are available at the following locations:

- **Azure Functions:** [Azure Functions Postman Collection](https://github.com/pcgayan/AZBedRock/blob/main/Postman%20Collection/Azure%20Functions.postman_collection.json)
- **Spring Boot:** [Spring Boot Postman Collection](https://github.com/pcgayan/AZBedRock/blob/main/Postman%20Collection/Spring.postman_collection.json)

---
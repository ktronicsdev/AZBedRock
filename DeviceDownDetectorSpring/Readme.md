# Device Down Detector Spring Boot

## Description

A Spring Boot application that detects if a device is down by getting the downed IP Addresses from a SQL Database.

## How to Run

Follow these standard steps to run the Spring Boot project:

1. **Clone the repository:**

   ```bash
   git clone https://github.com/maheladissa/DeviceDownDetectorSpring.git
   ```

2. **Navigate to the project directory:**

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

## How to Test via Postman

### Test Locally

1. **Open Postman.**

2. **Create a new request:**

    - Set the request method to `GET`.
    - Use the following URL:

      ```
      http://localhost:<port>/api/devices/down
      ```

    - Replace `<port>` with the actual port number your Spring Boot application is running on.

3. **Send the request:**

    - Click `Send` to test the API endpoint.

4. **Review the response:**

    - Check the response status code, body, and headers to ensure the API is functioning as expected.

### Test Cloud

1. **Open Postman.**

2. **Create a new request:**

    - Set the request method to `GET`.
    - Use the following URL:

      ```
      https://downdetectorspring.test.azuremicroservices.io/downdetector-184756/default/api/devices/down
      ```

3. **Set up Basic Auth:**

    - In the `Authorization` tab, select `Basic Auth`.
    - Enter your Azure app credentials (username and password).

4. **Send the request:**

    - Click `Send` to test the API endpoint.

5. **Review the response:**

    - Check the response status code, body, and headers to ensure the API is functioning as expected.

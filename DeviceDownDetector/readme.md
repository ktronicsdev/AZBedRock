# Device Down Detector Azure Functions

## Description

An Azure Functions project that detects if a device is down by getting the IP addresses of the devices that are down from a SQL database.

## How to Run

Follow these steps to run the project:

1. **Clone the repository:**

   ```bash
   git clone https://github.com/maheladissa/DeviceDownDetector.git
   ```

2. **Navigate to the project directory:**

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

### Test Locally

1. **Open Postman.**

2. **Create a new request:**

    - Set the request method to `GET`.
    - Use the following URL:

      ```
      http://localhost:7071/api/GetDownIPAddresses?
      ```

3. **Add headers:**

    - No additional headers are required for local testing.

4. **Send the request:**

    - Click `Send` to test the API endpoint.

5. **Review the response:**

    - Check the response status code, body, and headers to ensure the API is functioning as expected.

### Test Cloud Demo

1. **Open Postman.**

2. **Create a new request:**

    - Set the request method to `GET`.
    - Use the following URL:

      ```
      https://iotservices-18293.azurewebsites.net/api/GetDownIPAddresses?
      ```

3. **Add Authentication headers:**

    - In the `Headers` tab, add the following key-value pair:

      ```
      x-functions-key: <Your Function Key>
      ```

4. **Send the request:**

    - Click `Send` to test the API endpoint.

5. **Review the response:**

    - Check the response status code, body, and headers to ensure the API is functioning as expected.

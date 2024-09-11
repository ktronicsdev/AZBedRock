#!/bin/bash

# Set environment variables
export AZURE_SQLSERVER_URL="your SQL server URL"
export AZURE_SQLSERVER_USERNAME="your SQL server username"
export AZURE_SQLSERVER_PASSWORD="your SQL server password"

# Navigate to the Spring Boot project directory
cd DeviceDownDetectorSpring

# Build the project
mvn clean install

# Run the Spring Boot application
mvn spring-boot:run

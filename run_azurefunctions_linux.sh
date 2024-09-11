#!/bin/bash

# Set environment variable
export AZURE_SQL_CONNECTIONSTRING="your SQL connection string"

# Navigate to the Azure Functions project directory
cd DeviceDownDetector

# Package the project
mvn package

# Run the Azure Functions locally
mvn azurefunctions:run

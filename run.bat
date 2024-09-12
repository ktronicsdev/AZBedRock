@echo off
REM Check if the script is running on Windows or Unix-based system
IF NOT "%OS%"=="" (
    REM Windows Environment

    REM Set environment variable
    set AZURE_SQL_CONNECTIONSTRING=your_connection_string

    REM Determine the project to run based on input argument
    if "%1"=="AzureFunction" (
        cd DeviceDownDetector
        call mvn clean install
        call mvn azurefunctions:run
    ) else if "%1"=="Springboot" (
        cd DeviceDownDetectorSpring
        call mvn clean install
        call mvn spring-boot:run
    ) else (
        echo Please provide a valid argument: AzureFunction or Springboot
    )
)

# Unix-based environment (Linux, macOS, etc.)

#!/bin/bash

# Set environment variable
export AZURE_SQL_CONNECTIONSTRING="your_connection_string"

# Determine the project to run based on input argument
if [ "$1" == "AzureFunction" ]; then
    cd DeviceDownDetector
    mvn clean install
    mvn azurefunctions:run
elif [ "$1" == "Springboot" ]; then
    cd DeviceDownDetectorSpring
    mvn clean install
    mvn spring-boot:run
else
    echo "Please provide a valid argument: AzureFunction or Springboot"

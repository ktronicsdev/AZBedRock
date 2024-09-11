@echo off

:: Set environment variables
set AZURE_SQL_CONNECTIONSTRING= your connection string

:: Navigate to the Spring Boot project directory
cd DeviceDownDetectorSpring

:: Build the project
call mvn clean install

:: Run the Spring Boot application
call mvn spring-boot:run

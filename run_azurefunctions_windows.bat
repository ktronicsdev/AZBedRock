@echo on

:: Set environment variable
set AZURE_SQL_CONNECTIONSTRING= your connection string

:: Navigate to the Azure Functions project directory
cd DeviceDownDetector || (echo Directory not found & exit /b 1)

:: Package the project
call mvn package

:: Run the Azure Functions locally
call mvn azure-functions:run

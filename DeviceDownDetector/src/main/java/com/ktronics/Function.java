package com.ktronics;

import com.microsoft.azure.functions.ExecutionContext;
import com.microsoft.azure.functions.HttpMethod;
import com.microsoft.azure.functions.HttpRequestMessage;
import com.microsoft.azure.functions.HttpResponseMessage;
import com.microsoft.azure.functions.HttpStatus;
import com.microsoft.azure.functions.annotation.AuthorizationLevel;
import com.microsoft.azure.functions.annotation.FunctionName;
import com.microsoft.azure.functions.annotation.HttpTrigger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Azure Functions with HTTP Trigger.
 */
public final class Function {
    /**
     * This function listens at endpoint "/api/HttpExample". Two ways to invoke it using "curl" command in bash:
     * 1. curl -d "HTTP Body" {your host}/api/HttpExample
     * 2. curl "{your host}/api/HttpExample?name=HTTP%20Query"
     */

    private final String connectionString = System.getenv("AZURE_SQL_CONNECTIONSTRING");

    @FunctionName("GetDownIPAddresses")
    public final HttpResponseMessage run(
            @HttpTrigger(
                name = "req",
                methods = {HttpMethod.GET, HttpMethod.POST},
                authLevel = AuthorizationLevel.FUNCTION)
                HttpRequestMessage<Optional<String>> request,
            final ExecutionContext context) {
        context.getLogger().info("Java HTTP trigger processed a request.");


        List<String> ipAddresses = new ArrayList<>();

        try {
            // Load the SQL Server JDBC driver
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

            // Connect to the database
            String connectionUrl = connectionString;
            try (Connection conn = DriverManager.getConnection(connectionUrl)) {
                Statement stmt = conn.createStatement();
                String sql = "SELECT IPAddress FROM Availability WHERE Status = 'Down'";
                ResultSet rs = stmt.executeQuery(sql);

                while (rs.next()) {
                    ipAddresses.add(rs.getString("IPAddress"));
                }
            }
        } catch (Exception e) {
            context.getLogger().severe("Error querying database: " + e.getMessage());
            return request.createResponseBuilder(HttpStatus.INTERNAL_SERVER_ERROR).body("Error querying database").build();
        }

        return request.createResponseBuilder(HttpStatus.OK).body(ipAddresses).build();
    }
}

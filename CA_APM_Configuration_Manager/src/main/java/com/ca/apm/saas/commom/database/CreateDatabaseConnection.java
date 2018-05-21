package com.ca.apm.saas.commom.database;

/*
 * Author: Bassanta Kumar Dwibedy(dwiba01@ca.com)
 * 
 * Copyright (c) 2017 CA. All rights reserved.
 * 
 * This software and all information contained therein is confidential and
 * proprietary and shall not be duplicated, used, disclosed or disseminated in
 * any way except as authorized by the applicable license agreement, without
 * the express written permission of CA. All authorized reproductions must be
 * marked with this language.
 * 
 * EXCEPT AS SET FORTH IN THE APPLICABLE LICENSE AGREEMENT, TO THE EXTENT
 * PERMITTED BY APPLICABLE LAW, CA PROVIDES THIS SOFTWARE WITHOUT WARRANTY OF
 * ANY KIND, INCLUDING WITHOUT LIMITATION, ANY IMPLIED WARRANTIES OF
 * MERCHANTABILITY OR FITNESS FOR A PARTICULAR PURPOSE. IN NO EVENT WILL CA BE
 * LIABLE TO THE END USER OR ANY THIRD PARTY FOR ANY LOSS OR DAMAGE, DIRECT OR
 * INDIRECT, FROM THE USE OF THIS SOFTWARE, INCLUDING WITHOUT LIMITATION, LOST
 * PROFITS, BUSINESS INTERRUPTION, GOODWILL, OR LOST DATA, EVEN IF CA IS
 * EXPRESSLY ADVISED OF SUCH LOSS OR DAMAGE.
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateDatabaseConnection {

    private Connection connection = null;
    private Statement statement = null;
    private ResultSet resultSet = null;
    private PreparedStatement preparedStatement = null;

    public CreateDatabaseConnection() {

    }

    private Connection createConnection(DatabaseConnectionPojo dcp) {
        if (connection == null) {
            // Step 1: Loading or registering Oracle JDBC driver class
            try {
                Class.forName(dcp.getDriverClassName());
            } catch (ClassNotFoundException cnfex) {
                System.out.println("Problem in loading Oracle JDBC driver");
                cnfex.printStackTrace();
            }

            // Step 2: Opening database connection
            try {

                // Step 2.A: Create and get connection using DriverManager class
                connection = DriverManager.getConnection("jdbc:oracle:thin:@" + dcp.getDbHost() + ":" + dcp.getDbPort()
                        + ":" + dcp.getDbServiceName(), dcp.getDbUser(), dcp.getDbPassword());
            } catch (SQLException sqlex) {
                sqlex.printStackTrace();
            }
        }
        return connection;
    }

    public Statement getStatement(DatabaseConnectionPojo dcp) {
        if (connection == null) {
            createConnection(dcp);
        }
        try {

            // Step 2.B: Creating JDBC Statement
            statement = connection.createStatement();

        } catch (SQLException sqlex) {
            sqlex.printStackTrace();
        }

        return statement;
    }

    public PreparedStatement getPreparedStatement(DatabaseConnectionPojo dcp, String insertTableSQL) {
        System.out.println("connection Obj:::" + connection);
        if (connection == null) {
            createConnection(dcp);
        }
        try {

            // Step 2.B: Creating JDBC Statement
            preparedStatement = connection.prepareStatement(insertTableSQL);

        } catch (SQLException sqlex) {
            sqlex.printStackTrace();
        }

        return preparedStatement;
    }

    public ResultSet getResultSet(String query) {
        try {
            // Step 2.C: Executing SQL &amp;amp; retrieve data into ResultSet
            resultSet = statement.executeQuery(query);

        } catch (SQLException sqlex) {
            sqlex.printStackTrace();
        }

        return resultSet;
    }

    public void closeConnection() {
        // Step 3: Closing database connection
        try {
            if (null != connection) {

                // cleanup resources, once after processing
                resultSet.close();
                statement.close();

                // and then finally close connection
                connection.close();
            }
        } catch (SQLException sqlex) {
            sqlex.printStackTrace();
        }
    }

}

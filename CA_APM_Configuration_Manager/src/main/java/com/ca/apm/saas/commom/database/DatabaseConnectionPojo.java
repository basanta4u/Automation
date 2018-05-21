/*
 *   Copyright (c) 2018. CA Technologies.  All rights reserved.
 *  
 *  
 *   Author:  Basanta Kumar Dwibedy (dwiba01)
 *
 */

package com.ca.apm.saas.commom.database;

public class DatabaseConnectionPojo {

    private String dbHost;
    private String dbPort;
    private String dbServiceName;
    private String dbUser;
    private String dbPassword;
    private String driverClassName;

    public DatabaseConnectionPojo(String dbHost, String dbPort, String dbServiceName, String dbUser, String dbPassword,
            String driverClassName) {
        this.dbHost = dbHost;
        this.dbPort = dbPort;
        this.dbServiceName = dbServiceName;
        this.dbUser = dbUser;
        this.dbPassword = dbPassword;
        this.driverClassName = driverClassName;
    }

    /**
     * @return the dbHost
     */
    public String getDbHost() {
        return dbHost;
    }

    /**
     * @param dbHost
     *            the dbHost to set
     */
    public void setDbHost(String dbHost) {
        this.dbHost = dbHost;
    }

    /**
     * @return the dbPort
     */
    public String getDbPort() {
        return dbPort;
    }

    /**
     * @param dbPort
     *            the dbPort to set
     */
    public void setDbPort(String dbPort) {
        this.dbPort = dbPort;
    }

    /**
     * @return the dBServiceName
     */
    public String getDbServiceName() {
        return dbServiceName;
    }

    /**
     * @param dBServiceName
     *            the dBServiceName to set
     */
    public void setDbServiceName(String dbServiceName) {
        this.dbServiceName = dbServiceName;
    }

    /**
     * @return the dBUser
     */
    public String getDbUser() {
        return dbUser;
    }

    /**
     * @param dBUser
     *            the dBUser to set
     */
    public void setDbUser(String dbUser) {
        this.dbUser = dbUser;
    }

    /**
     * @return the dBPassword
     */
    public String getDbPassword() {
        return dbPassword;
    }

    /**
     * @param dBPassword
     *            the dBPassword to set
     */
    public void setDbPassword(String dbPassword) {
        this.dbPassword = dbPassword;
    }

    /**
     * @return the driverClassName
     */
    public String getDriverClassName() {
        return driverClassName;
    }

    /**
     * @param driverClassName
     *            the driverClassName to set
     */
    public void setDriverClassName(String driverClassName) {
        this.driverClassName = driverClassName;
    }
}

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

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import  java.util.Calendar;

import com.ca.apm.saas.pojo.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DBQuery  {

    public static final String DRIVER_CLASS = "oracle.jdbc.driver.OracleDriver";
    public static final String HOSTNAME = "swasa02-rhel01";
    public static final String PORT = "1521";
    public static final String SERVICE_ID = "cemdb";
    public static final String USER_ID = "c##DXIDEMO";
    public static final String PASSWORD = "c##DXIDEMO";

    DatabaseConnectionPojo dcp = new DatabaseConnectionPojo(HOSTNAME, PORT, SERVICE_ID, USER_ID, PASSWORD, DRIVER_CLASS);
    private final Logger LOGGER = LoggerFactory.getLogger(getClass());
    CreateDatabaseConnection conn = new CreateDatabaseConnection();

    public int getMaxDXIVP_ID() {
        String query = "SELECT MAX(DXIVP_ID) from DXIVALIDATIONPOINT" ;
        int num=-1;
        try {
            conn.getStatement(dcp);
            System.out.println("Coon"+conn);
            LOGGER.info("final query to execute::"+query);
            ResultSet resultSet = conn.getResultSet(query);
            System.out.println("Restset"+resultSet);
            LOGGER.info("ID\tName\t");
            LOGGER.info("==\t================\t===\t=======");

            // processing returned data and printing into console
            while (resultSet.next()) {
                num=resultSet.getInt(1);

                LOGGER.info("Max count for Validation point::"+num);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {

            //  conn.closeConnection();
        }
        return num;

    }

    public boolean insertValidationPoint(String name) {
        String query = "SELECT MAX(DXIVP_ID) from DXIVALIDATIONPOINT" ;
        boolean flag=false;
        int num;
        try {
            String insertTableSQL = "INSERT INTO DXIVALIDATIONPOINT"
                    + "(DXIVP_ID,NAME) VALUES" + "(?,?)";
            PreparedStatement preparedStatement = conn.getPreparedStatement(dcp, insertTableSQL);
            //conn.getStatement(dcp);
            System.out.println("Coon"+conn);

            LOGGER.info("preparedStatement created sucessfully");
            num=getMaxDXIVP_ID();
            if(num>1) {
                preparedStatement.setInt(1, ++num);
                preparedStatement.setString(2, name);
                preparedStatement.executeUpdate();
                LOGGER.info("Record added to database::::::::"+name);
                flag=true;
            }
            else return flag;

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {

            //  conn.closeConnection();
        }
        return flag;

    }
    public Map<String, Integer> getDXIVALIDATIONPOINT() {
        String query = "SELECT * FROM DXIVALIDATIONPOINT";
        Map<String, Integer> result = new HashMap<String, Integer>();
        try {
            conn.getStatement(dcp);
            ResultSet resultSet = conn.getResultSet(query);

            LOGGER.info("ID\tName\t");
            LOGGER.info("==\t================\t===\t=======");

            // processing returned data and printing into console
            while (resultSet.next()) {
                result.put(resultSet.getString(2), resultSet.getInt(1));
                LOGGER.info(resultSet.getInt(1) + "\t" + resultSet.getString(2) + "\t");
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {

          //  conn.closeConnection();
        }
        return result;

    }

    public void getDXIRESPONSETIME() {
        String query = "SELECT * FROM DXIRESPONSETIME";
        try {
            conn.getStatement(dcp);
            ResultSet resultSet = conn.getResultSet(query);

            LOGGER.info("ID\tName\t");
            LOGGER.info("==\t================\t===\t=======");

            // processing returned data and printing into console
            while (resultSet.next()) {
                LOGGER.info(resultSet.getInt(1) + "\t" + resultSet.getString(2) + "\t" + "\t" + resultSet.getString(3)
                        + "\t" + "\t" + resultSet.getString(4));
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {

          //  conn.closeConnection();
        }

    }
     
    
    public List<Result> getDXIDemoResult(int numberOfDays, int startRange, int endRange) {
        String query = "SELECT EXETIME,RESPONE_TIME,RESPONE_TIME_FROM_AXA,NAME,RESULT from DXIRESPONSETIME,DXIVALIDATIONPOINT where DXIVALIDATIONPOINT.DXIVP_ID = DXIRESPONSETIME.DXIVP_ID AND DXIRESPONSETIME.DXIVP_ID BETWEEN "+startRange+" AND "+endRange+" AND EXETIME BETWEEN '"+getRangeDateTimeStamp(numberOfDays)+"' AND '"+getRangeDateTimeStamp(0)+"'" ;
        List<Result> list = new ArrayList<Result>();
        try {
            conn.getStatement(dcp);
            System.out.println("Coon"+conn);
            LOGGER.info("final query to execute::"+query);
            ResultSet resultSet = conn.getResultSet(query);
            System.out.println("Restset"+resultSet);
            LOGGER.info("ID\tName\t");
            LOGGER.info("==\t================\t===\t=======");

            // processing returned data and printing into console
            while (resultSet.next()) {
            	Result result = new Result();
            	result.setExeTime(resultSet.getString(1));
               	result.setResponseTime(resultSet.getLong(2));
            	result.setAxaValues(resultSet.getLong(3));
            	result.setValidationPoint(resultSet.getString(4));
            	if(resultSet.getString(5).equalsIgnoreCase("Y"))
            	result.setResult(true);
            	else
            		result.setResult(false);
            	list.add(result);
               LOGGER.info(resultSet.getString(1) + "\t" + resultSet.getLong(2) + "\t" + "\t" + resultSet.getLong(3)
                        + "\t" + "\t" + resultSet.getString(4) + "\t" + "\t" + resultSet.getString(5));
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {

          //  conn.closeConnection();
        }
        return list;

    }

    public Map<String,Long> getMaxResult(int startRange,int endRange) {
        String query = "SELECT a.NAME,b.\"response_time\" from DXIVALIDATIONPOINT a,(SELECT MAX(RESPONE_TIME) \"response_time\",DXIVP_ID from DXIRESPONSETIME where DXIVP_ID BETWEEN "+startRange+" AND "+endRange+" GROUP BY  DXIVP_ID) b where a.DXIVP_ID=b.DXIVP_ID" ;
        Map<String,Long> map=new HashMap<String,Long>();
        try {
            conn.getStatement(dcp);
            System.out.println("Coon"+conn);
            LOGGER.info("final query to execute::"+query);
            ResultSet resultSet = conn.getResultSet(query);
            System.out.println("Restset"+resultSet);
            LOGGER.info("ID\tName\t");
            LOGGER.info("==\t================\t===\t=======");

            // processing returned data and printing into console
            while (resultSet.next()) {
                map.put(resultSet.getString(1),resultSet.getLong(2));
                LOGGER.info(resultSet.getString(1) + "\t" + resultSet.getLong(2));
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {

            //  conn.closeConnection();
        }
        return map;

    }

    public Map<String,Long>  getMinResult(int startRange,int endRange) {
        String query = "SELECT a.NAME,b.\"response_time\" from DXIVALIDATIONPOINT a,(SELECT Min(RESPONE_TIME) \"response_time\",DXIVP_ID from DXIRESPONSETIME where DXIVP_ID BETWEEN "+startRange+" AND "+endRange+" GROUP BY  DXIVP_ID) b where a.DXIVP_ID=b.DXIVP_ID" ;
        Map<String,Long> map=new HashMap<String,Long>();
        try {
            conn.getStatement(dcp);
            System.out.println("Coon"+conn);
            LOGGER.info("final query to execute::"+query);
            ResultSet resultSet = conn.getResultSet(query);
            System.out.println("Restset"+resultSet);
            LOGGER.info("ID\tName\t");
            LOGGER.info("==\t================\t===\t=======");

            // processing returned data and printing into console
            while (resultSet.next()) {
                    map.put(resultSet.getString(1),resultSet.getLong(2));
                  LOGGER.info(resultSet.getString(1) + "\t" + resultSet.getLong(2));
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {

            //  conn.closeConnection();
        }
        return map;

    }
    public Map<String,Long> getAvgResult(int startRange,int endRange) {
        String query = "SELECT a.NAME,b.\"response_time\" from DXIVALIDATIONPOINT a,(SELECT ROUND(AVG(RESPONE_TIME),0) \"response_time\",DXIVP_ID from DXIRESPONSETIME where DXIVP_ID BETWEEN "+startRange+" AND "+endRange+" GROUP BY  DXIVP_ID) b where a.DXIVP_ID=b.DXIVP_ID" ;
        Map<String,Long> map=new HashMap<String,Long>();
        try {
            conn.getStatement(dcp);
            System.out.println("Coon"+conn);
            LOGGER.info("final query to execute::"+query);
            ResultSet resultSet = conn.getResultSet(query);
            System.out.println("Restset"+resultSet);
            LOGGER.info("ID\tName\t");
            LOGGER.info("==\t================\t===\t=======");

            // processing returned data and printing into console
            while (resultSet.next()) {
                map.put(resultSet.getString(1),resultSet.getLong(2));
                LOGGER.info(resultSet.getString(1) + "\t" + resultSet.getLong(2));
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {

            //  conn.closeConnection();
        }
        return map;

    }


    public void writeResult(ArrayList<Result> responseTime) {
        LOGGER.info("Started write Result into database");
        Map<String, Integer> chkPoint = getDXIVALIDATIONPOINT();
        try {
            Timestamp ts = getCurrentTimeStamp();

            String insertTableSQL = "INSERT INTO DXIRESPONSETIME"
                    + "(EXETIME, RESPONE_TIME, RESPONE_TIME_FROM_AXA, DXIVP_ID,result) VALUES" + "(?,?,?,?,?)";
            PreparedStatement preparedStatement = conn.getPreparedStatement(dcp, insertTableSQL);
            LOGGER.info("preparedStatement created sucessfully");

            Iterator<Result> itr = responseTime.iterator();
            LOGGER.info("hashMap contain number of records:::"+responseTime.size());
            int i=1;
            // traverse elements of ArrayList object
            while (itr.hasNext()) {
                Result result = (Result) itr.next();

                preparedStatement.setTimestamp(1, ts);
                preparedStatement.setInt(2, (int) result.getResponseTime());
                preparedStatement.setInt(3, (int) result.getAxaValues());
              //  LOGGER.info("Response time & Axa value set to pointer::::::::");
                preparedStatement.setInt(4, chkPoint.get(result.getValidationPoint()));
             //   LOGGER.info("Map to Validation point sucessful set to pointer::::::::");
                if (result.isResult())
                    preparedStatement.setString(5, "Y");
                else
                    preparedStatement.setString(5, "N");
                // execute insert SQL stetement
                preparedStatement.executeUpdate();
                LOGGER.info("Record added to database::::::::"+i++);
            }

            LOGGER.info("Completed write Result into database");

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {

            conn.closeConnection();
        }

    }

    private  java.sql.Timestamp getCurrentTimeStamp() {

        java.util.Date today = new java.util.Date();
        LOGGER.info("Current time:-------:"+today.getTime());
        return new java.sql.Timestamp(today.getTime());

    }

    private  String getRangeDateTimeStamp(int days) {

       // java.util.Date today = new java.util.Date();
        DateFormat dateFormat = new SimpleDateFormat("dd-MMM-yy hh:mm:ss aa");
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, -days);
        LOGGER.info("Date = "+ cal.getTime());
        java.util.Date utilDate = cal.getTime();
      //  LOGGER.info("Current time:-------:"+today.getTime());
        return dateFormat.format(utilDate.getTime());

    }

}

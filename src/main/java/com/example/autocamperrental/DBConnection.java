package com.example.autocamperrental;

import java.sql.*;

public   class DBConnection {
      Connection conn;
      PreparedStatement ps;
      ResultSet rs;


    //use DBConnection as singleton to all project
    public Connection getConnection(){
        String dataBaseName=" ";
        String dataBaseUser="sa";
        String dataBasePassword="1234";
        String url="jdbc:sqlserver://localhost:1433;databaseName=AutoCamper";
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn= DriverManager.getConnection(url,dataBaseUser,dataBasePassword);
        }catch (Exception e){
            e.printStackTrace();
            e.getMessage();
        }
        return conn;
    }
}

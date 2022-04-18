package com.example.hello;
import android.annotation.SuppressLint;
import android.os.StrictMode;
import android.util.Log;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionHelper {
    Connection connection;
    String ip,port,db,un,pass;
    @SuppressLint("NewApi")
    public Connection conclass(){
     ip="192.168.1.107";
     port="3306";
     un="root";
     pass="";
     StrictMode.ThreadPolicy tpolicy=new StrictMode.ThreadPolicy.Builder().permitAll().build();
     StrictMode.setThreadPolicy(tpolicy);
     Connection con = null;
     String ConnectionURL=null;
     try
     {
         Class.forName(("net.sourceforge.jtds.jdbc.Driver"));
         ConnectionURL = "jdbc:jtds:sqlserver://"+ip+":"+port+"j"+"databaseName="+db+"juser"+un+"jpassword"+pass+"j";
         con = DriverManager.getConnection(ConnectionURL);

     }catch (Exception ex)
     {
         Log.e("Error : ", ex.getMessage());
     }
     return con;
    }
}


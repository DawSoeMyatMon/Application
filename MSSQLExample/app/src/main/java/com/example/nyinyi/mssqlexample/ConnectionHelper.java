package com.example.nyinyi.mssqlexample;

import android.annotation.SuppressLint;
import android.os.StrictMode;
import android.util.Log;

import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by SMM on 10/30/2017.
 */

public class ConnectionHelper {

    String IP,DB,DBUsername,DBPassword;

    @SuppressLint("NewAPI")
    public java.sql.Connection connections()
    {
        IP="DESKTOP-5EQTIHI\\SQL2012";
        DB="App";
        DBUsername="sa";
        DBPassword="yatthargyi1357";
        StrictMode.ThreadPolicy policy=new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        java.sql.Connection connection=null;
        String ConnectionURL=null;
        try{

            Class.forName("net.sourceforge.jtds.jdbc.Driver");
            ConnectionURL="jdbc:jtds:sqlserver://"+IP+"databaseName="+DB+"user="+DBUsername+"password="+DBPassword;
            connection= DriverManager.getConnection(ConnectionURL);


        }
        catch (SQLException se)
        {
            Log.e("Error from SQL",se.getMessage());
        }
         catch (ClassNotFoundException ce)
         {
             Log.e("Error from Class",ce.getMessage());
         }
         catch(Exception ex){
             Log.e("Error from Exception",ex.getMessage());
         }
        return connection;
    }

}

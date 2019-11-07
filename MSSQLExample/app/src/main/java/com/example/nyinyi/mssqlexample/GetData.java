package com.example.nyinyi.mssqlexample;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by SMM on 10/30/2017.
 */

public class GetData {
    Connection connect;
    String ConnectionResult="";
    boolean isSuccess=false;

    public List<Map<String,String>> getdata() throws SQLException {



        List<Map<String,String>> data=null;
        data=new ArrayList<Map<String,String>>();

        try {
            ConnectionHelper connectionHelper = new ConnectionHelper();
             connect = connectionHelper.connections();

            if (connect == null) {
                ConnectionResult = "Check your Internet Access";
            } else {
                String query = "select * from countries";
                Statement stmt = connect.createStatement();
                ResultSet res = stmt.executeQuery(query);

                while (res.next()) {
                    Map<String, String> datanum = new HashMap<String, String>();
                    datanum.put("ID", res.getString("CountryId"));
                    datanum.put("Country", res.getString("CountryName"));
                    datanum.put("Capital", res.getString("CapitalCity"));
                    data.add(datanum);

                }
                ConnectionResult = "Successful";
                isSuccess = true;
                connect.close();
            }
        }
        catch (Exception ex)
        {
            isSuccess=false;
            ConnectionResult=ex.getMessage();
        }
        return data;
    }

}

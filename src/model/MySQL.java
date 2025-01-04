
package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

public class MySQL {
    
    private static Connection connection;
    
    private static void createConnection()throws Exception{
        Class.forName("com.mysql.cj.jdbc.Driver");
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/courtcase","root","Kavindu@dilshan");
    }
    
    
    public static ResultSet executeSearch(String query)throws Exception{
        createConnection();
        return connection.createStatement().executeQuery(query);
    }
    
    public static Integer executeIUD(String query)throws Exception{
        createConnection();
        return connection.createStatement().executeUpdate(query);
    }
    
    public static void closeConnection() throws Exception{
        
        if (connection != null) {
             connection.close();
        }
    }
}

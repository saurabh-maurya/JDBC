/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBC {

    public static final String USERNAME = "dbtest";//databse username
    public static final String PASSWORD = "root";//database 
    public static final String CONN_STRING =
            "jdbc:mysql://localhost/practice";

    
    
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn= null;
        Statement stmt = null;
        ResultSet result = null;
        try {         
            conn = (Connection) DriverManager.getConnection(CONN_STRING, USERNAME, PASSWORD);
            stmt = conn.createStatement();
            result = stmt.executeQuery("SELECT * FROM mytable");//sql query
            DataDisplay.display(result);
        } catch (SQLException e) {
            //Logger.getLogger(JDBC.class.getName()).log(Level.SEVERE, null, e);
            System.err.println(e);
        } finally{
            if(result != null){
                result.close();
            }
            if(stmt != null){
                stmt.close();
            }
            if(conn != null){
                conn.close();
            }
        } 
    }
    
}

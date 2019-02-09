
package jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DataDisplay {
    public static void display(ResultSet rs) throws SQLException {
        while(rs.next()){
            String name = rs.getString("name"); //pass databse column name in parameter 
            int age = rs.getInt("age");  
            System.out.print("NAME:" +name+"\tAGE:");
            System.out.println(age);
        }
    }
}

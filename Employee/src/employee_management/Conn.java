
package employee_management;
import java.sql.*;


public class Conn {
    Connection c; // it is interface 
    Statement s;  // it is interface
    
    public Conn(){
        
        try{
            Class.forName("com.mysql.cj.jdbc.Driver"); // mysql driver registring 
            c=DriverManager.getConnection("jdbc:mysql:///employeemanagementsystem","root","Shishupal@2004");
            // jdbc:mysql://localhost location of mysql where that is running
            
            s=c.createStatement(); //  step 3
            
            
            
            
        }
        catch(Exception e){
            e.printStackTrace();
        } 
    }
}

/*
There are 5 steps for jdbc

1. register the driver
2. create the connection string
3. creating statement 
4. executing mysql queries
5. closing the connection

*/


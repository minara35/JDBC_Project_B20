package day1;

import java.sql.*;

public class TestConnection {
    public static void main(String[] args) throws SQLException {

        //REPLACE THIS IP ADDRESS WITH YOUR OWN THAT WORKING IN SQL DEVELOPER
        //make sure do not delete @ in front of it
        String connectionStr = "jdbc:oracle:thin:@34.207.129.172:1521:XE";
        String username = "hr" ;
        String password = "hr" ;


        Connection conn = DriverManager.getConnection(connectionStr,username,password) ;

        // creating statement object using the connection we have established
        Statement stmnt = conn.createStatement();

        // ResultSet object is what we use to store the actual result we get from query
        ResultSet rs   =   stmnt.executeQuery("SELECT * FROM REGIONS") ;

// this qill move the cursor from beforefirst location to first row

        rs.next(); // currently we are at the very first row
        // rs.getString(column index) can be used to read the data of that column in current row

        // getting the column data  we use multiple get methods available in ResultSet
        //  print out region id and region name  , both as String
        System.out.println("first column value using index: --> " +  rs.getString(1)   );
        System.out.println("second column value using index: --> " +  rs.getString(2)   );

        //rs.getString(column lable)
        System.out.println("Region_ID at this row is : " + rs.getString("REGION_ID")  );
        System.out.println("Region_Name at this row is : " + rs.getString("REGION_NAME")  );
        rs.next(); // this will move us to next row so we can read next row
        System.out.println("Region_ID at this row is : " + rs.getString("REGION_ID")  );
        System.out.println("Region_Name at this row is : " + rs.getString("REGION_NAME")  );

        rs.next(); // this will move us to next row so we can read next row
        System.out.println("Region_ID at this row is : " + rs.getString("REGION_ID")  );
        System.out.println("Region_Name at this row is : " + rs.getString("REGION_NAME")  );
    }

}

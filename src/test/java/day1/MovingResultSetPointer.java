package day1;

import java.sql.*;

public class MovingResultSetPointer {
    // we want to create as statement obj that generate
    // resultSet that can move forward and backward anytime
    public static void main(String[] args) throws SQLException {

        String connectionStr = "jdbc:oracle:thin:@34.207.129.172:1521:XE";
        String username = "hr";
        String password = "hr";


        Connection conn = DriverManager.getConnection(connectionStr, username, password);

        // creating statement object using the connection we have established
        Statement stmnt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

        // ResultSet object is what we use to store the actual result we get from query
        ResultSet rs = stmnt.executeQuery("SELECT * FROM REGIONS");


        while (rs.next()){
            System.out.println("REGION_NAME " + rs.getString("REGION_NAME"));
        }

//        rs.previous();
//        System.out.println("REGION_NAME " + rs.getString("REGION_NAME"));


        while (rs.previous()){
            System.out.println("REGION_NAME " + rs.getString("REGION_NAME"));
        }
        rs.beforeFirst();
        rs.first(); // first row
        rs.last(); // last row
        rs.afterLast();
        rs.absolute(3); // move to specific row

        // how to find out which row tje pointer is at right now
        rs.last();
        int currentRow = rs.getRow();
        System.out.println(" Row count = " + currentRow);
        //




    }
}

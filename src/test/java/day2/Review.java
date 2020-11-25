package day2;

import java.sql.*;

public class Review {
    public static void main(String[] args) throws SQLException {
        String connectionStr = "jdbc:oracle:thin:@34.207.129.172:1521:XE";
        String username = "hr" ;
        String password = "hr" ;


        Connection conn = DriverManager.getConnection(connectionStr,username,password) ;


        Statement stmnt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE , ResultSet.CONCUR_READ_ONLY);


        ResultSet rs   =   stmnt.executeQuery("SELECT * FROM JOBS") ;

        // I want to read the first row


        rs.next(); // currently we are at the very first row
        System.out.println("first column value in Jobs: --> " +  rs.getString(1)   );
        System.out.println("second column value in Jobs: --> " +  rs.getString(2) );



        rs.absolute(7);//move to row number 7 and get above 2 columns calue

        System.out.println("first column value in Jobs in 7 row : --> " +  rs.getString(1)   );
        System.out.println("second column value in Jobs in 7 row: --> " +  rs.getString(2) );


        rs.last();

        System.out.println("first column value in Jobs in last row: --> " +  rs.getString(1)   );
        System.out.println("second column value in Jobs in last row:: --> " +  rs.getString(2) );

        rs.previous();

        System.out.println("first column value in Jobs in  2nd row from last : --> " +  rs.getString(1)   );
        System.out.println("second column value in Jobs in 2nd row from last:: --> "+  rs.getString(2) );

        System.out.println("----------Loop from top to bottom ----------------");

        rs.beforeFirst();
        while (rs.next()){
            System.out.println("Loop first column " + rs.getString("JOB_ID") );
        }


        System.out.println("\n----------Loop from last row till row get MIN_SALARY COLUMN AS NUMBER ----------------");
//WE ARE CURRENTLY AFTER LAST LOCATION
        //if you really want to make sure and explicitly say so
        // we can do below

        rs.afterLast();
        while (rs.previous()){
            //nothing wrong getting it as a string , just for the sake of demo , we are getting as double
            System.out.println("MIN SALARY COLUMN AS NUMBER $" + rs.getDouble("MIN_SALARY"));
        }


        // clean u[ the connection statement and result object after usage
        rs.close();
        stmnt.close();
        conn.close();










    }
}

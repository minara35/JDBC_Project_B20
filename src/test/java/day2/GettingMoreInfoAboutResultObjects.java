package day2;

import java.sql.*;

public class GettingMoreInfoAboutResultObjects {

    public static void main(String[] args) throws SQLException {
        String connectionStr = "jdbc:oracle:thin:@34.207.129.172:1521:XE";
        String username = "hr" ;
        String password = "hr" ;


        Connection conn = DriverManager.getConnection(connectionStr,username,password) ;


        Statement stmnt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE , ResultSet.CONCUR_READ_ONLY);


        ResultSet rs   =   stmnt.executeQuery("SELECT * FROM EMPLOYEES") ;

        //MetaData -- data about the data  --
        //ResultSetMetaData -- data about the ResultSet object that contain our resulting rows and columns
        // for example column names column counts .. and more
        // this is how we get the ResultSetMetaData object
//ResultSetMetaData itself does not contains any row data
        // it only has information about the columns
        ResultSetMetaData rsmd = rs.getMetaData();

        //we only need two methods from this to get column count and column name | label

     int columnCount=   rsmd.getColumnCount();
        System.out.println("columnCount = " + columnCount);
        // this how we get column label| name using index
        // get first column name
        System.out.println("First Column Name is " + rsmd.getColumnLabel(1));
        System.out.println("Second Column Name is " + rsmd.getColumnLabel(2));
// now print out all column names:

        for(int colNum =1; colNum <= columnCount ; colNum++){
            System.out.println("column name " + rsmd.getColumnLabel(colNum));
        }

        rs.close();
        stmnt.close();
        conn.close();

















    }
}

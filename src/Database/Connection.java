package Database;

import java.sql.*;

public class Connection {

    private static String dbURL = "jdbc:derby:D:/PUC/LeilaoProArq/src/Database/LeilaoDB;create=true";
    private static java.sql.Connection conn = null;


    //EXEMPLO
    private static String tableName = "TESTE";
    // jdbc Connection

    private static Statement stmt = null;

    public static void main (String args[]){

        try
        {
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
            //Get a connection
            conn = DriverManager.getConnection(dbURL);
            stmt = conn.createStatement();
            ResultSet results = stmt.executeQuery("select * from " + tableName);
            ResultSetMetaData rsmd = results.getMetaData();
            int numberCols = rsmd.getColumnCount();
            for (int i=1; i<=numberCols; i++)
            {
                //print Column Names
                System.out.print(rsmd.getColumnLabel(i)+"\t\t");
            }

            System.out.println("\n-------------------------------------------------");

            while(results.next())
            {
                int id = results.getInt(1);
                String restName = results.getString(2);
                String cityName = results.getString(3);
                System.out.println(id + "\t\t" + restName + "\t\t" + cityName);
            }
            results.close();
            stmt.close();
        }
        catch (SQLException sqlExcept)
        {
            sqlExcept.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}

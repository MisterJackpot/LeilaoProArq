package Database;

import java.sql.DriverManager;

public class SingletonConnection {

    private static SingletonConnection ourInstance = new SingletonConnection();
    private static String dbURL = "jdbc:derby:C:/Users/vitor/Documents/LeilaoProArq/src/Database/LeilaoDB;create=true";
    private static java.sql.Connection conn = null;

    public static SingletonConnection getInstance() {
        return ourInstance;
    }

    private SingletonConnection() {
    }

    public java.sql.Connection getConnection(){

        try
        {
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver").newInstance();
            //Get a connection
            conn = DriverManager.getConnection(dbURL);
        }
        catch (Exception except)
        {
            except.printStackTrace();
        }

        return conn;

    }

}

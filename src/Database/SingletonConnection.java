package Database;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;
import java.sql.DriverManager;

public class SingletonConnection {

    private static SingletonConnection ourInstance = new SingletonConnection();
    private static String dbURL = "jdbc:derby:D:/PUC/LeilaoProArq/src/Database/LeilaoDB;create=true";
    private static java.sql.Connection conn = null;

    public static SingletonConnection getInstance() {
        return ourInstance;
    }

    private SingletonConnection() {
    }

    public java.sql.Connection getConnection(){

        try
        {
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
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

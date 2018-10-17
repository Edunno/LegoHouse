package DB;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnector {

    private Connection connection = null;

    //Constants
    private static final String IP = "104.248.22.167";
    private static final String PORT = "3306";
    public static final String DATABASE = "LegoSite";
    private static final String USERNAME = "transformer";
    private static final String PASSWORD = "manabomb";

    /**
     * Connects to the MySQL database via <code>IP</code>,<code>PORT</code> to a database, under a username and password. This has to be set up manually in the class.
     *
     * @throws Exception if no connection can be made.
     */
    public DBConnector() throws Exception {
        Class.forName("com.mysql.jdbc.Driver").newInstance();
        String url = "jdbc:mysql://" + IP + ":" + PORT + "/" + DATABASE;
        this.connection = (Connection) DriverManager.getConnection(url, USERNAME, PASSWORD);
    }

    /**
     * Returns the connection made from the variables in this class.
     *
     * @return the <code>Connection</code> object.
     */
    public Connection getConnection() {
        return this.connection;
    }

}
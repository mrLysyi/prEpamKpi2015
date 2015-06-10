package pr4.lysyi.jdbcconnect;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import resources.ConfigurationManager;
import resources.ConnectionManager;

/**
 *
 * @author Lysyi Andrii
 */
public class ConnectorDAO {
    private static volatile ConnectorDAO instance;
    private static volatile Connection connection;
//    private static final String PROPERTY_FILE_PATH = "./src/db.properties";
   
    private ConnectorDAO() {                // private constructor
        connection = createConnection();
       
    }
    
    /**
     * synchronized
     * @return  instance (only one), singleton 
     */
//    public static ConnectorDAO getInstance() {
//        if (instance == null) {
//            synchronized (ConnectorDAO.class) {
//                if (instance == null) {
//                    instance = new ConnectorDAO();
//                }
//            }
//        }
//        return instance;
//    }
    
    /**
     * check for valid
     * @return connection
     */
    public Connection getConnection(){
        try {
            if( !connection.isValid(1) ){
                connection.close();
                connection  = createConnection();
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConnectorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return connection;
    }

    /**
     * read property file and return connection
     * @return new connection
     */
    private static java.sql.Connection createConnection() {
        
        try {
            java.sql.Driver driver = new com.mysql.jdbc.Driver();
            
//            FileInputStream in = null;
            String connectionString = ConnectionManager.getProperty("dbUrl");
            String password = ConnectionManager.getProperty("password");
            String login = ConnectionManager.getProperty("user");
//            try {                       // read properties
//                in = new FileInputStream(PROPERTY_FILE_PATH);
//                Properties props = new Properties();
//                props.load(in);
//                connectionString = props.getProperty("dbUrl");
//                login = props.getProperty("user");
//                password = props.getProperty("password");
//            } finally {
//                if (in != null) {
//                    in.close();
//                }
//            }
            if (connection == null || connection.isClosed()) {
                connection = DriverManager.getConnection(connectionString, login, password);
                connection.setAutoCommit(false);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConnectorDAO.class
                    .getName()).log(Level.SEVERE, null, ex);
        } //catch (IOException ex) {
//            Logger.getLogger(ConnectorDAO.class
//                    .getName()).log(Level.SEVERE, null, ex);
//        }
        return connection;
    }

    

}

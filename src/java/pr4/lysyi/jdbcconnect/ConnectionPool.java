package pr4.lysyi.jdbcconnect;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;


/**
 *
 * @author Lysyi Andrii
 */
public class ConnectionPool {

    /**
     * @return connection
     */
    public Connection getConnection() {   
        Context context = null;
        DataSource ds = null;
        Connection cn = null;
        try {
            //        try {
//            envCtx = (Context) (new InitialContext().lookup("java:comp/env/pr4"));
//            ds = (DataSource) envCtx.lookup("jdbc/pr4Pool");
//
//        } catch (NamingException ex) {
//            Logger.getLogger(ConnectorDAO.class.getName()).log(Level.SEVERE, null, ex);
//        }
            context = new InitialContext();
        } catch (NamingException ex) {
            Logger.getLogger(ConnectorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            ds = (DataSource) context.lookup("jdbc/pr4");
        } catch (NamingException ex) {
            Logger.getLogger(ConnectorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            cn = ds.getConnection();
        } catch (SQLException ex) {
            Logger.getLogger(ConnectorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cn;
    }
    public static void main(String[] args) throws SQLException {
        Connection con = con = new ConnectionPool().getConnection();
        
        System.out.println(con.getMetaData());
    }
}

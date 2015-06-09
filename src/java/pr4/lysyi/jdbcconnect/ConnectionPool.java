package pr4.lysyi.jdbcconnect;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.naming.Context;
import javax.naming.InitialContext;


import javax.naming.NamingException;
import sun.jdbc.odbc.ee.DataSource;


/**
 *
 * @author Lysyi Andrii
 */
public class ConnectionPool {

    /**
     * @return connection
     */
    public Connection getConnection() {
        Connection con = null;
//        try {
//            Context envCtx = (Context) (new InitialContext().lookup("java:comp/env"));
//            DataSource ds = (DataSource) envCtx.lookup("jdbc/pr");
//        } catch (NamingException ex) {
//            Logger.getLogger(ConnectionPool.class.getName()).log(Level.SEVERE, null, ex);
//        }
        
       
        try {
             InitialContext context = new InitialContext();
            DataSource dataSource = (DataSource) context.lookup("jdb/pr");
            con = dataSource.getConnection();
        } catch (NamingException | SQLException ex) {
            Logger.getLogger(ConnectionPool.class.getName()).log(Level.SEVERE, null, ex);
        }
        return con;
    }
    
    public static void main(String[] args) {
       ConnectionPool pool = new ConnectionPool(); 
       Connection con =  pool.getConnection();
        System.out.println("");
    }
}

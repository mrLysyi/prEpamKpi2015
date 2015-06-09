package pr4.lysyi.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import pr4.lysyi.dao.jdbc.JDBCUserDAO;
import pr4.lysyi.dto.Entity;

/**
 *
 * @author Lysyi Andrii This class represent upper point of DAO hierarchy, and
 * describe common methods witch will be used in interaction with relation
 * tables (sql)
 *
 * @param <T> transientObject - entity
 * @param <PK> Primary key
 */
public abstract class AbstractDAO<PK, T extends Entity> {
//    protected WrapperConnector connector;
//    protected Connection connection;

    /**
     * save object newInstance in DataBase
     *
     * @param newInstance
     * @return true, if creation success, otherwise false
     */
    public abstract boolean create(T newInstance);

    /**
     * Extract object, previously stored in Database , using specified id as
     * primary key
     *
     * @param id
     * @return Entity
     */
    /**
     *
     * @param id
     * @return true, if delete operation success, otherwise false
     */
    public abstract boolean delete(PK id);

    /**
     *
     * @param persistentObject - object to delete
     * @return true, if delete operation success, otherwise false
     */
    public abstract boolean delete(T persistentObject);

    /**
     *
     * @param id - key
     * @return entity
     */
    public abstract T read(PK id);

    /**
     * Save changes,witch was made in the object.
     *
     * @param transientObject - entity
     * @return 
     */
    public abstract boolean update(T transientObject);

    /**
     *
     * @return List with all Entity's in table
     */
    public abstract List<T> findAll();

     /**
     * close Statement
     * @param st Statement
     */
    public void close(Statement st) {
        try {
            if (st != null) {
                st.close();
            }
        } catch (SQLException e) {
            Logger.getLogger(JDBCUserDAO.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    /**
     *
     * @param connection
     */
    public void close(Connection connection) {
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
             Logger.getLogger(JDBCUserDAO.class.getName()).log(Level.SEVERE, null, e);
        }
    }   

}

package pr4.lysyi.dao;

import pr4.lysyi.dao.jdbc.JDBCFacultetDAO;
import pr4.lysyi.dao.jdbc.JDBCUserDAO;
import pr4.lysyi.dao.jdbc.JDBCUserFacultetDAO;


/**
 * @author Lysyi Andrii
 * 
 */
public abstract class DAOFactory {

    // List of DAO types supported by the factory
//    public static final int USER = 1;
//    public static final int FACULTET = 2;
//    public static final int USER_FACULTET = 3;

    // There will be a method for each DAO that can be 
    // created. The concrete factories will have to 
    // implement these methods.
    
//    public abstract   DAOFactory();
//    public abstract FacultetDAO getFacultetDAO();
//    public abstract UserFacultetDAOInterface getUserFacultetDAO();

    public static AbstractDAO getDAOFactory(EnumDAOType wichDao) {
        switch (wichDao) {
            case USER:
                return (JDBCUserDAO) new JDBCUserDAO();
            case FACULTET:
                return new JDBCFacultetDAO();
            case USER_FACULTET:
                return new JDBCUserFacultetDAO();
            default:
                return null;
        }
    }
    

}

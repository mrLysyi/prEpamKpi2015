
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import pr4.lysyi.dao.AbstractDAO;
import pr4.lysyi.dao.DAOFactory;
import pr4.lysyi.dao.EnumDAOType;
import pr4.lysyi.dao.jdbc.JDBCFacultetDAO;
import pr4.lysyi.dao.jdbc.JDBCUserDAO;
import pr4.lysyi.dto.Facultet;
import pr4.lysyi.dto.User;
import pr4.lysyi.jdbcconnect.ConnectorDAO;

/**
 *
 * @author Lysyi Andrii
 */
public class MainTest {
    public static final String SQL_SELECT_BY_LASTNAME = "SELECT * FROM user WHERE last_name=?";
    
    static Logger logger = Logger.getLogger(MainTest.class);
    public static void main(String[] args) throws SQLException {
        
//     Connection conect = ConnectorDAO.getInstance().getConnection();
//     Statement st = conect.createStatement();
//     PreparedStatement prst = null;
//     ResultSet rs = null;
//
//        
//        JDBCUserDAO userDao  = (JDBCUserDAO) DAOFactory.getDAOFactory(EnumDAOType.USER);
//         List<User> userList = userDao.findAll();
//         Iterator iterator   = userList.iterator();
//         while (iterator.hasNext()){
//             System.out.println("111");
//             System.out.println(iterator.next().toString());
//         }
//         
//         Facultet facultet = new Facultet("pff", 150, "adm", 50, 135, "Biologi Mathematic Languadge");
//        JDBCFacultetDAO facultetDAO =  (JDBCFacultetDAO) DAOFactory.getDAOFactory(EnumDAOType.FACULTET);
//        
//        facultetDAO.create(facultet);
//        Facultet facultet2 = facultetDAO.read(facultet.getName());
//        facultet2.setName("new facultet name2");
//        facultetDAO.update(facultet2);
//        System.out.println(facultetDAO.delete(facultet2.getId()));
//        
//        User user = new User("Koko", "sgr", "Petrovich", "test@mail.com",
//                "Koko", "_city", "_country", "user"); //, new Date(2012, 12, 12
//        JDBCUserDAO userDao2 = (JDBCUserDAO) DAOFactory.getDAOFactory(EnumDAOType.USER);
//
//        System.out.println(userDao2.create(user));
////        user.setId(11);
//        User user2 = userDao2.read(user.getEmail());
////        int id = user.getId();
////        System.out.println(user.getEmail());
////                System.out.println(userDao.delete(65));
//        
//        user2.setCity("Kazahstan");
////        user2.setId(2);
//        System.out.println(user2.toString());
//        System.out.println(userDao.update(user2));        
//        System.out.println(userDao.delete(user2)); 
         
//        new DOMConfigurator().doConfigure("log4j.properties", LogManager.getLoggerRepository());
//      log.debug("Hello this is a debug message");
//        BasicConfigurator.configure();
       PropertyConfigurator.configure("log4j.properties");
//        BasicConfigurator.configure();
        
      logger.info("Hello this is an info message");
      logger.debug("Log4j appender configuration is successful !!");
    }
}


import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Iterator;
import java.util.List;
import org.apache.log4j.LogManager;
import pr4.lysyi.dao.AbstractDAO;
import pr4.lysyi.dao.DAOFactory;
import pr4.lysyi.dao.EnumDAOType;
import pr4.lysyi.dao.jdbc.JDBCFacultetDAO;
import pr4.lysyi.dao.jdbc.JDBCUserDAO;
import pr4.lysyi.dto.Facultet;
import pr4.lysyi.dto.User;
import pr4.lysyi.jdbcconnect.ConnectorDAO;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

/**
 *
 * @author Lysyi Andrii
 */
public class MainTest {
    public static final String SQL_SELECT_BY_LASTNAME = "SELECT * FROM user WHERE last_name=?";
    public static void main(String[] args) throws SQLException {
        
     Connection conect = ConnectorDAO.getInstance().getConnection();
     Statement st = conect.createStatement();
     PreparedStatement prst = null;
     ResultSet rs = null;
//     ResultSet rs = st.executeQuery("SELECT * FROM user");
//     
//     while(rs.next()){                          // try catch finnaly close
//         String s = rs.getString(2);
//         Date date = rs.getDate(12);
//         System.out.println(s + " " + date);
//     }
//    String name = "Petrov";
//    prst = conect.prepareStatement(SQL_SELECT_BY_LASTNAME);     
//    prst.setString(1, name);
//    rs =  prst.executeQuery();
//    rs.next();
//    System.out.println(rs.getString("first_name"));
//    rs.next();
//    System.out.println(rs.getString("first_name"));
//    
//     String s = rs.getString(1);
//     
//        try {
//            conect.close();
//            
//            
//        } catch (SQLException ex) {
//            Logger.getLogger(ConnectorDAO.class.getName()).log(Level.SEVERE, null, ex);
//            
//        } finally{
//            System.out.println("finish");
//            
//            System.out.println("EnumDAOType.USER");
//        }
        
        JDBCUserDAO userDao  = (JDBCUserDAO) DAOFactory.getDAOFactory(EnumDAOType.USER);
         List<User> userList = userDao.findAll();
         Iterator iterator   = userList.iterator();
         while (iterator.hasNext()){
             System.out.println("111");
             System.out.println(iterator.next().toString());
         }
         
         Facultet facultet = new Facultet("pff", 150, "adm", 50, 135, "Biologi Mathematic Languadge");
        JDBCFacultetDAO facultetDAO =  (JDBCFacultetDAO) DAOFactory.getDAOFactory(EnumDAOType.FACULTET);
        
        facultetDAO.create(facultet);
        Facultet facultet2 = facultetDAO.read(facultet.getName());
        facultet2.setName("new facultet name2");
        facultetDAO.update(facultet2);
        System.out.println(facultetDAO.delete(facultet2.getId()));
        
        User user = new User("Koko", "sgr", "Petrovich", "test@mail.com",
                "Koko", "_city", "_country", "user"); //, new Date(2012, 12, 12
        JDBCUserDAO userDao2 = (JDBCUserDAO) DAOFactory.getDAOFactory(EnumDAOType.USER);

        System.out.println(userDao2.create(user));
//        user.setId(11);
        User user2 = userDao2.read(user.getEmail());
//        int id = user.getId();
//        System.out.println(user.getEmail());
//                System.out.println(userDao.delete(65));
        
        user2.setCity("Kazahstan");
//        user2.setId(2);
        System.out.println(user2.toString());
        System.out.println(userDao.update(user2));        
        System.out.println(userDao.delete(user2)); 
        new DOMConfigurator().doConfigure("log4j.properties", LogManager.getLoggerRepository());

    }
}

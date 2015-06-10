package pr4.lysyi.dao.jdbc;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import pr4.lysyi.dao.DAOFactory;
import pr4.lysyi.dao.EnumDAOType;
import pr4.lysyi.dao.UserDAO;
import pr4.lysyi.dto.User;
import pr4.lysyi.jdbcconnect.ConnectionPool;
import pr4.lysyi.jdbcconnect.ConnectorDAO;

/**
 * DAO realization for concrete business object
 *
 * @author Lysyi Andrii
 */
public class JDBCUserDAO extends UserDAO {

    private static final String SQL_SELECT_ALL_USERS = "SELECT * FROM user";
    private static final String CREATE = "INSERT INTO pr4.user (first_name,last_name, patronymic, email,"
            + "password, creation_date, city, country, role) VALUES (?,"
            + "?, ?, ?, ?, ?, ?, ?, ?)";
    private static final String UPDATE = "UPDATE pr4.user SET first_name=?, last_name=?, patronymic=?, email=?, password=?, role=?, city=?, country=? WHERE id=?";

    private static final String READ_BY_ID = "SELECT * FROM pr4.user where id = ?";
    private static final String READ_BY_EMAIL = "SELECT * FROM pr4.user where email = ?";
    private static final String DELETE_ID = "DELETE user FROM pr4.user where id = ?";
    private static final String DELETE_EMAIL = "DELETE user FROM pr4.user where email = ?";
//    public static final String CREATE = " INSERT INTO user (email) VALUES (?)";

    public JDBCUserDAO() {

    }

    /**
     * save new user instance in DataBase
     *
     * @param user
     * @param newInstance
     * @return true, if creation success, otherwise false
     */
    @Override
    public boolean create(User user) {
        boolean rezult = false;
        Statement query = null;
        PreparedStatement st = null;
//        Connection con = ConnectorDAO.getInstance().getConnection();      // singletone connection
         Connection con =  new ConnectionPool().getConnection();            // Pool conection
        try {
            con.setAutoCommit(false);
            st = con.prepareStatement(CREATE);
            st.setString(1, user.getFirstName());
            st.setString(2, user.getLastName());
            st.setString(3, user.getPartonymic());
            st.setString(4, user.getEmail());
            st.setString(5, user.getPassword());
            st.setDate(6, user.getCreationDate());
            st.setString(7, user.getCity());
            st.setString(8, user.getCountry());
            st.setString(9, user.getRole());
            st.execute(); //rezult =
            rezult = true;
            con.commit();
        } catch (SQLException e) {
            try {
                con.rollback();
                rezult = false;
            } catch (SQLException ex) {
                Logger.getLogger(JDBCUserDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            Logger.getLogger(JDBCUserDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            this.close(st);
            this.close(query);
        }
        return rezult;
    }

    /**
     * Attention! by default users id = 0, delete will not work correct
     *
     * @param id user's id
     * @return true if success
     */
    @Override
    public boolean delete(Integer id) {
        if (id <= 0) {
            return false;
        }
        boolean rezult = false;
        
        PreparedStatement st = null;
//        Connection con = ConnectorDAO.getInstance().getConnection();
        Connection con =  new ConnectionPool().getConnection();
        try {
            st = con.prepareStatement(DELETE_ID);
            st.setInt(1, id);

            st.execute();
//            System.out.println(st.getUpdateCount());
            rezult = (int) (st.getUpdateCount()) == 1;
            con.commit();
        } catch (SQLException e) {
            rezult = false;
            Logger.getLogger(JDBCUserDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            this.close(st);
            this.close(con);
        }
        return rezult;
    }

    /**
     * delete by user's email
     *
     * @param user
     * @return true if success
     */
    @Override
    public boolean delete(User user) {
        boolean rezult = false;
        
        PreparedStatement st = null;
//        Connection con = ConnectorDAO.getInstance().getConnection();
        Connection con =  new ConnectionPool().getConnection();
        try {
            st = con.prepareStatement(DELETE_EMAIL);
            st.setString(1, user.getEmail());
            st.execute();
            rezult = (int) (st.getUpdateCount()) == 1;
            con.commit();
        } catch (SQLException e) {
            rezult = false;
            Logger.getLogger(JDBCUserDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            this.close(st);
            this.close(con);
        }
        return rezult;
    }

    @Override
    public User read(Integer id) {
        User user = new User();        
        ResultSet rs = null;
        PreparedStatement query = null;
//        Connection con = ConnectorDAO.getInstance().getConnection();
        Connection con =  new ConnectionPool().getConnection();
        try {
            query = con.prepareStatement(READ_BY_ID);
            query.setInt(1, id);
            rs = query.executeQuery();
            rs.next();
            user.add(rs.getInt(1), rs.getString(2), rs.getString(3),
                    rs.getString(4), rs.getString(5), rs.getString(6),
                    rs.getDate(7), rs.getString("role"), rs.getString(9), rs.getString(10)); //rs.getDate(10)

        } catch (SQLException e) {
            Logger.getLogger(JDBCUserDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            this.close(con);
            this.close(query);
        }
        return user;
    }

    @Override
    public User read(String email) {
        User user = new User();        
        ResultSet rs = null;
        PreparedStatement query = null;
//        Connection con = ConnectorDAO.getInstance().getConnection();
        Connection con =  new ConnectionPool().getConnection();
        try {
            query = con.prepareStatement(READ_BY_EMAIL);
            query.setString(1, email);
            rs = query.executeQuery();
            rs.next();
            user.add(rs.getInt(1), rs.getString(2), rs.getString(3),
                    rs.getString(4), rs.getString(5), rs.getString(6),
                    rs.getDate(7), rs.getString("role"), rs.getString(9), rs.getString(10)); //rs.getDate(10)

        } catch (SQLException e) {
            Logger.getLogger(JDBCUserDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            this.close(con);
            this.close(query);
        }
        return user;
    }

    /**
     * update user data, by field email user object mast contain valid id
     *
     * @param user - user entity with new data
     * @return
     */
    @Override
    public boolean update(User user) {
        boolean rezult = false;
        Statement query = null;
        PreparedStatement st = null;
//        Connection con = ConnectorDAO.getInstance().getConnection();
        Connection con =  new ConnectionPool().getConnection();
        try {
            con.setAutoCommit(false);
            st = con.prepareStatement(UPDATE);
//             st = con.prepareStatement("UPDATE pr4.user SET first_name=?, last_name=?, patronymic=?, email=?, password=?, role=?, city=?, country=? WHERE id=?");
            st.setString(1, user.getFirstName());
            st.setString(2, user.getLastName());
            st.setString(3, user.getPartonymic());
            st.setString(4, user.getEmail());
            st.setString(5, user.getPassword());
            st.setString(6, user.getRole());
            st.setString(7, user.getCity());
            st.setString(8, user.getCountry());
            if (user.getId() == 0) {
                return false;                         //  UPDATE = "UPDATE pr4.user SET first_name=?, last_name=?,"
//                                                      //+ " patronymic=?, email=?, password=? city=?, country=?, role=? WHERE id=?";
            }
            st.setInt(9, 11);
            st.execute(); //rezult =
            rezult = true;
            con.commit();
        } catch (SQLException e) {
            try {
                con.rollback();
                rezult = false;
            } catch (SQLException ex) {
                Logger.getLogger(JDBCUserDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            Logger.getLogger(JDBCUserDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            this.close(st);
            this.close(query);
        }
        return rezult;
    }

    /**
     *
     * @return
     */
    @Override
    public List<User> findAll() {
        List<User> userList = new ArrayList<User>();
       
//        Connection con = ConnectorDAO.getInstance().getConnection();
        Connection con =  new ConnectionPool().getConnection();
        try (Statement query = con.createStatement()) {
            ResultSet rs = query.executeQuery("SELECT * FROM user ");
            while (rs.next()) {
                userList.add(new User(rs.getInt(1), rs.getString(2), rs.getString(3),
                        rs.getString(4), rs.getString(5), rs.getString(6),
                        rs.getString(7),  rs.getString(9), rs.getString("role"))); //rs.getDate(10)
            }
        } catch (SQLException e) {
            Logger.getLogger(JDBCUserDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            this.close(con);
//            this.close();
        }
        return userList;
    }

    /**
     *
     * @param userId
     * @return ArrayList with users marks from user_grade table
     */
//    @Override
//    public ArrayList<Integer> getMarks(int userId) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }

//    /**
//     * set marks into user_grade table
//     *
//     * @param grades arrayList with 3 int marks
//     * @param userId
//     * @return true if success
//     */
//    @Override
//    public boolean setMarks(ArrayList<Integer> grades, int userId) {
//        if (grades.size() < 3) {
//            return false;
//        }
//        int gradeOne   = grades.get(0);
//        int gradeTwo   = grades.get(1);
//        int gradeThree = grades.get(2);
//    }

//    /**
//     *
//     * @param examNames string with examen names (3) separated by space
//     * @param FacultetName - facultet id
//     * @return true if success
//     */
//    @Override
//    public boolean setExamNames(String examNames, int FacultetName) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }

//    /**
//     *
//     * @param userId
//     * @return String with 3 examen names separated by space
//     */
//    @Override
//    public String getExamNames(int userId) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }

    public static void main(String[] args) {
        User user = new User("Koko", "sgr", "Petrovich", "test@mail.com",
                "Koko", "_city", "_country", "user"); //, new Date(2012, 12, 12
        JDBCUserDAO userDao = (JDBCUserDAO) DAOFactory.getDAOFactory(EnumDAOType.USER);

        System.out.println(userDao.create(user));
//        user.setId(11);
        User user2 = userDao.read(user.getEmail());
//        int id = user.getId();
//        System.out.println(user.getEmail());
//                System.out.println(userDao.delete(65));

        user2.setCity("Kazahstan");
//        user2.setId(2);
        System.out.println(user2.toString());
        System.out.println(userDao.update(user2));
        System.out.println(userDao.delete(user2));
    }

}

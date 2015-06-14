/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pr4.lysyi.dao.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import pr4.lysyi.dao.DAOFactory;
import pr4.lysyi.dao.EnumDAOType;
import pr4.lysyi.dao.UserFacultetDAO;
import pr4.lysyi.dto.Facultet;
import pr4.lysyi.dto.User;
import pr4.lysyi.dto.UserFacultet;
import pr4.lysyi.jdbcconnect.ConnectorDAO;

/**
 *
 * @author Lysyi Andrii
 */
public class JDBCUserFacultetDAO extends UserFacultetDAO {

    private static final String INSERT_ID = "INSERT INTO pr4.facultet_user (id_facultet, id_user, zno)\n"
            + "SELECT '4', '3', '345' FROM pr4.facultet_user \n"
            + "WHERE NOT exists ( SELECT * FROM pr4.facultet_user\n"
            + "		WHERE id_facultet ='3' AND id_user ='3')\n"
            + "LIMIT 1";
    private static final String INSERT = "INSERT INTO pr4.facultet_user (id_facultet, "
            + "id_user,  zno, grade_one, grade_two, grade_three) "
            + "VALUES (?, ?, ?, ?, ?, ? )";
    private static final String DELETE = "";
//  private static final String FIND_ID = "SELECT u.* FROM user u join facultet_user fu on u.id = fu.id_user where fu.id_facultet = ?";
    private static final String FIND_ID = "SELECT u.id, fu.id_facultet, fu.zno, fu.grade_one, fu.grade_two, fu.grade_three,"+
"fu.enrolled, fu.inconcurs, u.first_name, u.last_name FROM user u join facultet_user fu on u.id = fu.id_user where fu.id_facultet = ?"; 
//    private static final String FIND_ID_INCOURS = "SELECT u.* FROM user u join facultet_user fu on u.id = fu.id_user where fu.id_facultet = ? AND fu.inconcurs = ?";
     private static final String FIND_ID_INCOURS =  "SELECT u.id, fu.id_facultet, fu.zno, fu.grade_one, fu.grade_two, fu.grade_three,"+
"fu.enrolled, fu.inconcurs, u.first_name, u.last_name FROM user u join facultet_user fu on u.id = fu.id_user where fu.id_facultet = ? AND fu.inconcurs = ?";
    private static final String FIND_ID_INCOURS_GRADE = "SELECT u.* FROM user u join facultet_user fu on u.id = fu.id_user where fu.id_facultet = ? AND fu.inconcurs = ? AND fu.zno + fu.grade_one + fu.grade_two + fu.grade_three > ?";
     private static final String SET_INCORSE = "UPDATE pr4.facultet_user SET inconcurs='1' WHERE id_facultet=? AND id_user=?";
//    private static final String

    /**
     * create new userFacultet instance in DB facultetId and userId together
     * must be unic(distinct)
     * @param userID
     * @param facultetId
     * @return if success
     */
    public boolean setUserFaultet(int facultetId, int userID, int zno, int grade_one, int grade_two, int grade_three) {
        UserFacultet userFacultet = new UserFacultet(userID, facultetId);        
        boolean rezult = false;
        PreparedStatement st = null;
    // Connection con =  new ConnectionPool().getConnection();
       Connection  con = ConnectorDAO.getInstance().getConnection();
        try {
            st = con.prepareStatement(INSERT);
            st.setInt(1, facultetId);
            st.setInt(2, userID);
            st.setInt(3, zno);
            st.setInt(4, grade_one);
            st.setInt(5, grade_two);
            st.setInt(6, grade_three);
            rezult = true;
            st.execute();
            con.commit();
        } catch (SQLException e) {
            rezult = false;
            Logger.getLogger(JDBCUserDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            this.close(con);
            this.close(st);
        }
        return rezult;
    }

    /**
     * UNREALIZED
     */
    @Override
    public boolean setUserFaultet(int userID, int facultetId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    /**
     * UNREALIZED    
     */
    @Override
    public boolean deleteUserFaultet(int userID, int facultetId) {
       throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     *
     *UNREALIZED
     * @param facultetId
     * @param minSumGrade select minimum sum of grades to select user (0
     * default)
     * @return list with users registred on one facultet
     */
    @Override
    public List<User> getUsersInFacultet(int facultetId, int minSumGrade) {
         throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.

    }

    /**
     *UNREALIZED
     * @param userId
     * @return list with facultets, where User "userID" is registred
     */
    @Override
    public List<Facultet> getFacultetOnUsers(int userId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    /**
     * UNREALIZED     
     */
    @Override
    public ArrayList<Integer> getMarks(int userId, int facultetId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    /**
     * UNREALIZED   
     */
    @Override
    public boolean setMarks(ArrayList<Integer> grades, int userId, int facultetId) {
         throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    /**
     * UNREALIZED   
     */
    @Override
    public boolean setExamNames(String examNames, int facultetId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * UNREALIZED  
     */
    @Override
    public String getExamNames(int userId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    /**
     * UNREALIZED   
     */
    @Override
    public boolean isEnrolled(int userId, int facultetId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * UNREALIZED
     * @return 
     */
    @Override
    public List<UserFacultet> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    /**
     * 
     * @param facultetId
     * @return userList
     */
     public List<UserFacultet> findId(int facultetId) {
         List<UserFacultet> list = new LinkedList<>();
       
        ResultSet rs = null;
        PreparedStatement query = null;
        // Connection con =  new ConnectionPool().getConnection();      // Pool
       Connection  con = ConnectorDAO.getInstance().getConnection();    // Singltn
        try {
            query = con.prepareStatement(FIND_ID);
            query.setInt(1, facultetId);          
            rs = query.executeQuery();
             while (rs.next()) {
                list.add(new UserFacultet(rs.getInt("id"), rs.getInt("id_facultet"), rs.getInt("zno"),
                 rs.getInt("grade_one"),rs.getInt("grade_two"),rs.getInt("grade_three"),
                 rs.getBoolean("enrolled"),rs.getBoolean("inconcurs"), rs.getString("first_name")
                 +" "+rs.getString("last_name"))); 
            }           

        } catch (SQLException e) {
            Logger.getLogger(JDBCUserDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            this.close(con);
            this.close(query);
        }
        return list;
    }
     
     /**
      * 
      * @param facultetId
      * @return List with users, on selected facultet, who are added in concurs by admin (incourses = true)
      */
      public List<UserFacultet> findIdIncourse(int facultetId) {
         List<UserFacultet> list = new LinkedList<>();
     
        ResultSet rs = null;
        PreparedStatement query = null;
    // Connection con =  new ConnectionPool().getConnection();      // Pool
       Connection  con = ConnectorDAO.getInstance().getConnection();    // Singltn
        try {
            query = con.prepareStatement(FIND_ID_INCOURS);
            query.setInt(1, facultetId); 
             query.setInt(2, 1); 
            rs = query.executeQuery();
             while (rs.next()) {
                list.add(new UserFacultet(rs.getInt("id"), rs.getInt("id_facultet"), rs.getInt("zno"),
                 rs.getInt("grade_one"),rs.getInt("grade_two"),rs.getInt("grade_three"),
                rs.getBoolean("enrolled"),rs.getBoolean("inconcurs"), rs.getString("first_name")
                 +" "+rs.getString("last_name"))); 
            }           

        } catch (SQLException e) {
            Logger.getLogger(JDBCUserDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            this.close(con);
            this.close(query);
        }
        return list;
    }
      /**
       * 
       * @param facultetId
       * @param minGrade
       * @return List with users, who are set in concurse by admin, and where grade > minGrade
       */
       public List<User> findIdIncourseGrade(int facultetId, int minGrade) {
         List<User> list = new LinkedList<>();
       
        ResultSet rs = null;
        PreparedStatement query = null;
     // Connection con =  new ConnectionPool().getConnection();      // Pool
       Connection  con = ConnectorDAO.getInstance().getConnection();    // Singltn
        try {
            query = con.prepareStatement(FIND_ID_INCOURS_GRADE);
            query.setInt(1, facultetId); 
            query.setInt(2, 1);
            query.setInt(3, minGrade);
            rs = query.executeQuery();
             while (rs.next()) {
                 list.add(new User(rs.getInt("id"), rs.getString(2), rs.getString(3),
                        rs.getString(4), rs.getString("email"), rs.getString("password"),
                        rs.getString("city"), rs.getString("country"),  rs.getString("role"))); //rs.getDate(7)
            }           

        } catch (SQLException e) {
            Logger.getLogger(JDBCUserDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            this.close(con);
            this.close(query);
        }
        return list;
    }
     
    public boolean setIncourse(int userId, int facultetId) {         
        Connection con;
        boolean rezult = false;
        PreparedStatement st = null;
        con = ConnectorDAO.getInstance().getConnection();
        try {
            st = con.prepareStatement(SET_INCORSE);           
            st.setInt(1, facultetId);
            st.setInt(2, userId);            
            rezult = true;
            st.execute();
            con.commit();
        } catch (SQLException e) {
            rezult = false;
            Logger.getLogger(JDBCUserDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            this.close(con);
            this.close(st);
        }
        return rezult;
    }

    public static void main(String[] args) {
        JDBCUserFacultetDAO jdbc = (JDBCUserFacultetDAO) DAOFactory.getDAOFactory(EnumDAOType.USER_FACULTET);
//        System.out.println(jdbc.setUserFaultet(4, 3, 12, 134, 135, 136));
        LinkedList<UserFacultet> list = (LinkedList<UserFacultet>) jdbc.findId(1);
        Iterator it = list.iterator();
        while (it.hasNext()) {
            UserFacultet next = (UserFacultet) it.next();
            System.out.println(next.toString());
        }
        System.out.println(jdbc.setIncourse(2, 1));
    }

    @Override
    public boolean setEnrolled(int userId, int facultetId, boolean enrolled) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}

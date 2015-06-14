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
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;
import pr4.lysyi.dao.DAOFactory;
import pr4.lysyi.dao.EnumDAOType;
import pr4.lysyi.dao.FacultetDAO;
import pr4.lysyi.dto.Facultet;
import pr4.lysyi.dto.User;
import pr4.lysyi.jdbcconnect.ConnectionPool;
import pr4.lysyi.jdbcconnect.ConnectorDAO;

/**
 *
 * @author Lysyi Andrii
 */
public class JDBCFacultetDAO extends FacultetDAO {

    private static final String CREATE = "INSERT INTO pr4.facultet (name, budget_quote, "
            + "admin, comerrcial_quote, min_grade, examen_names) VALUES (?, ?, ?, ?, ?, ?)";
    private static final String DELETE_ID = "DELETE facultet FROM pr4.facultet where id = ?;";
    private static final String DELETE_FACULTET = "DELETE facultet FROM pr4.facultet WHERE name = ?";
    private static final String READ_ID = "SELECT * FROM pr4.facultet WHERE id = ?";
    private static final String READ_NAME = "SELECT * FROM pr4.facultet WHERE name = ?";
    private static final String UPDATE = "UPDATE pr4.facultet SET name=?, budget_quote=?, admin=?, comerrcial_quote=?, min_grade=?, examen_names=? WHERE id=?";
    private static final String SET_EXAM = "UPDATE pr4.facultet SET examen_names=? WHERE name=?";
    private static final String GET_EXAM = "SELECT examen_names FROM pr4.facultet WHERE name=?";

    @Override
    public boolean create(Facultet facultet) {
        boolean rezult = false;
        Statement query = null;
        PreparedStatement st = null;
     Connection con =  new ConnectionPool().getConnection();      // Pool
//       Connection  con = ConnectorDAO.getInstance().getConnection();    // Singltn
        try {
            con.setAutoCommit(false);
            st = con.prepareStatement(CREATE);
            st.setString(1, facultet.getName());
            st.setInt(2, facultet.getBudgetQuote());
            st.setString(3, facultet.getAdmin());
            st.setInt(4, facultet.getComerrcialQuote());
            st.setInt(5, facultet.getMinGrade());
            st.setString(6, facultet.getExamenNames());
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

    @Override
    public boolean delete(Integer id) {
        if (id <= 0) {
            return false;
        }
        boolean rezult = false;
        Statement query = null;
        PreparedStatement st = null;
     Connection con =  new ConnectionPool().getConnection();      // Pool
//       Connection  con = ConnectorDAO.getInstance().getConnection();    // Singltn
        try {
            st = con.prepareStatement(DELETE_ID);
            st.setInt(1, id);
            st.execute();
            rezult = (int) (st.getUpdateCount()) == 1;
            con.commit();
        } catch (SQLException e) {
            rezult = false;
            Logger.getLogger(JDBCUserDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            this.close(st);
            this.close(query);
        }
        return rezult;
    }

    /**
     * delete from DB by admin name
     *
     * @param facultet getAdminName
     * @return
     */
    @Override
    public boolean delete(Facultet facultet) {
        boolean rezult = false;
        Statement query = null;
        PreparedStatement st = null;
     Connection con =  new ConnectionPool().getConnection();      // Pool
//       Connection  con = ConnectorDAO.getInstance().getConnection();    // Singltn
        try {
            st = con.prepareStatement(DELETE_FACULTET);
            st.setString(1, facultet.getName());
            st.execute();
            rezult = (int) (st.getUpdateCount()) == 1;
            con.commit();
        } catch (SQLException e) {
            rezult = false;
            Logger.getLogger(JDBCUserDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            this.close(st);
            this.close(query);
        }
        return rezult;
    }

    @Override
    public Facultet read(Integer id) {
        Facultet facultet = new Facultet();        
        ResultSet rs = null;
        PreparedStatement query = null;
     Connection con =  new ConnectionPool().getConnection();      // Pool
//       Connection  con = ConnectorDAO.getInstance().getConnection();    // Singltn
        try {
            query = con.prepareStatement(READ_ID);
            query.setInt(1, id);
            rs = query.executeQuery();
            rs.next();
            facultet.add(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4),
                    rs.getInt(5), rs.getInt(6), rs.getString(7));

        } catch (SQLException e) {
            Logger.getLogger(JDBCUserDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            this.close(con);
            this.close(query);
        }
        return facultet;
    }

    @Override
    public Facultet read(String facultetName) {
        Facultet facultet = new Facultet();
        
        ResultSet rs = null;
        PreparedStatement query = null;
     Connection con =  new ConnectionPool().getConnection();      // Pool
//       Connection  con = ConnectorDAO.getInstance().getConnection();    // Singltn
        try {
            query = con.prepareStatement(READ_NAME);
            query.setString(1, facultetName);
            rs = query.executeQuery();
            rs.next();
            facultet.add(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4),
                    rs.getInt(5), rs.getInt(6), rs.getString(7));

        } catch (SQLException e) {
            Logger.getLogger(JDBCUserDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            this.close(con);
            this.close(query);
        }
        return facultet;
    }

    @Override
    public boolean update(Facultet facultet) {
        boolean rezult = false;
        PreparedStatement st = null;
      Connection con =  new ConnectionPool().getConnection();      // Pool
//       Connection  con = ConnectorDAO.getInstance().getConnection();    // Singltn
        if (facultet.getId() == 0 || facultet.getName() == "") {
            return false;
        }
        try {
            con.setAutoCommit(false);
            st = con.prepareStatement(UPDATE);
            st.setString(1, facultet.getName());    // new name
            st.setInt(2, facultet.getBudgetQuote());
            st.setString(3, facultet.getAdmin());
            st.setInt(4, facultet.getComerrcialQuote());
            st.setInt(5, facultet.getMinGrade());
            st.setInt(6, facultet.getId());           
            st.setString(7, facultet.getExamenNames());
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
            this.close(con);
        }
        return rezult;
    }

    @Override
    public List<Facultet> findAll() {
        List<Facultet> facultList = new ArrayList<Facultet>();       
      Connection con =  new ConnectionPool().getConnection();      // Pool
//       Connection  con = ConnectorDAO.getInstance().getConnection();    // Singltn
        try (Statement query = con.createStatement()) {
            ResultSet rs = query.executeQuery("SELECT * FROM facultet");
            while (rs.next()) {
                facultList.add(new Facultet(rs.getString(2), rs.getInt(3), rs.getString(4),
                        rs.getInt(5), rs.getInt(6), rs.getInt(1), rs.getString(7)));
            }
        } catch (SQLException e) {
            Logger.getLogger(JDBCUserDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            this.close(con);
//            this.close();
        }
        return facultList;
    }
    
    
    public Facultet findByAdmin(String adminEmail) {
        Facultet facultet = null;
        PreparedStatement st = null;
      Connection con =  new ConnectionPool().getConnection();      // Pool
//       Connection  con = ConnectorDAO.getInstance().getConnection();    // Singltn
        try  {           
            st = con.prepareStatement("SELECT * FROM facultet WHERE admin=?");
            st.setString(1, adminEmail);  
            ResultSet rs = st.executeQuery();
            rs.next();
                facultet = new Facultet(rs.getString(2), rs.getInt(3), rs.getString(4),
                        rs.getInt(5), rs.getInt(6), rs.getInt(1), rs.getString(7));
            
        } catch (SQLException e) {
            Logger.getLogger(JDBCUserDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            this.close(con);
//            this.close();
        }
        return facultet;
    }

    @Override
    public boolean setExamNames(String facultetName, String examNames) {
        Boolean rezult = false;
        
        PreparedStatement st = null;
      Connection con =  new ConnectionPool().getConnection();      // Pool
//       Connection  con = ConnectorDAO.getInstance().getConnection();    // Singltn
        try {            
            st = con.prepareStatement(SET_EXAM);
            st.setString(1, examNames);
            st.setString(2, facultetName);
            st.execute();
            rezult = true;
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

    @Override
    public String getExamNames(String facultetName) {
        String rezult=null;
     Connection con =  new ConnectionPool().getConnection();      // Pool
//       Connection  con = ConnectorDAO.getInstance().getConnection();    // Singltn
        PreparedStatement query = null;
        
        try {            
            query = con.prepareStatement(GET_EXAM);           
            query.setString(1, facultetName);
            ResultSet rs = query.executeQuery();
            rs.next();
            rezult=rs.getString(1);
        } catch (SQLException e) {            
            Logger.getLogger(JDBCUserDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            this.close(con);
            this.close(query);
        }
        return rezult;
    }

    public static void main(String[] args) {
        Facultet facultet = new Facultet("pff", 150, "adm", 50, 135, "name1 name2 name3");
        JDBCFacultetDAO facultetDAO = (JDBCFacultetDAO) DAOFactory.getDAOFactory(EnumDAOType.FACULTET);
        JDBCUserDAO userDao = (JDBCUserDAO) DAOFactory.getDAOFactory(EnumDAOType.USER);
        facultetDAO.create(facultet);
        Facultet facultet2 = facultetDAO.read(facultet.getName());
        facultet2.setName("new facultet name2");
        facultetDAO.update(facultet2);
        System.out.println(facultetDAO.delete(facultet2.getId()));
        List<Facultet> facList = facultetDAO.findAll();
        Iterator it = facList.iterator();
        while (it.hasNext()) {
            System.out.println(it.next().toString());;
        }
        System.out.println(facultetDAO.setExamNames("FIOT", "Exam1 Exam2 Exam3"));
        System.out.println(facultetDAO.getExamNames("FIOT"));
        System.out.println(facultetDAO.findByAdmin("admin@mail.com").toString());
    }

}

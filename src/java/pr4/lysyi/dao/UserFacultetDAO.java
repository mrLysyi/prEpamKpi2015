/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pr4.lysyi.dao;

import java.util.ArrayList;
import java.util.List;
import pr4.lysyi.dto.Facultet;
import pr4.lysyi.dto.User;
import pr4.lysyi.dto.UserFacultet;

/**
 *
 * @author Lysyi Andrii
 */
public abstract class UserFacultetDAO extends AbstractDAO<Integer, UserFacultet> {
    /**
     * create new userFacultet instance in DB facultetId and userId together
     * must be unic(distinct)
     * @return if success
     */
    public abstract boolean setUserFaultet(int userID, int facultetId);
    
    /**
     * 
     * @param userID
     * @param facultetId
     * @return 
     */
    public abstract boolean deleteUserFaultet(int userID, int facultetId);
    
    /**
     * 
     * 
     * @param facultetId
     * @param minSumGrade select minimum sum of grades to select user (0 default)
     * @return list with users registred on one facultet
     */
    public abstract List<User> getUsersInFacultet(int facultetId, int minSumGrade);
    
    /**
     * 
     * @param userId
     * @param facultetId
     * @return  list with facultets, where User "userID" is registred
     */
    public abstract List<Facultet> getFacultetOnUsers(int userId);   
    
    /**
     * 
     * @param userId
     * @param facultetId
     * @return 
     */
    public abstract ArrayList<Integer> getMarks(int userId,  int facultetId);
    
    /**
     * 
     * @param grades
     * @param userId
     * @param facultetId
     * @return 
     */
    public abstract boolean setMarks(ArrayList<Integer> grades, int userId,  int facultetId);
    
    /**
     *
     * @param examNames
     * @param facultetId
     * @return
     */
    public abstract boolean setExamNames(String examNames, int facultetId);

    /**
     *
     * @param userId
     * @return
     */
    public abstract String getExamNames (int userId);

    /**
     *
     * @param userId
     * @param facultetId
     * @return
     */
    public abstract boolean isEnrolled(int userId,  int facultetId);
    
    
    public abstract boolean setEnrolled(int userId,  int facultetId, boolean enrolled);
    
    
    /**
     * UNSUPORTED
     * @param userFacultet
     * @return 
     */
     @Override
    public boolean create(UserFacultet userFacultet) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    /**
     * UNSUPORTED
     * @param id
     * @return 
     */
    @Override
    public boolean delete(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    /**
     * UNSUPORTED
     * @param persistentObject
     * @return 
     */
    @Override
    public boolean delete(UserFacultet persistentObject) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    /**
     * UNSUPORTED
     * @param id
     * @return 
     */
    @Override
    public UserFacultet read(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    /**
     * UNSUPORTED
     * @param userFaculet
     * @return 
     */
    @Override
    public boolean update(UserFacultet userFaculet) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

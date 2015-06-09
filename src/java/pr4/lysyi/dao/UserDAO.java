/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pr4.lysyi.dao;

import java.util.ArrayList;
import pr4.lysyi.dto.User;

/**
 *
 * @author Lysyi Anderii
 */
public abstract class UserDAO extends AbstractDAO<Integer, User> {
     public abstract User read(String email);
//     public abstract ArrayList<Integer> getMarks(int userId);
//     public abstract boolean setMarks(ArrayList<Integer> grades,int userId);
//     public abstract boolean setExamNames(String examNames, int facultetId);
//     public abstract String getExamNames (int userId);
}

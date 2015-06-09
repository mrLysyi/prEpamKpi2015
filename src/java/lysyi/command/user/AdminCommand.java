/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lysyi.command.user;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import lysyi.contoller.logic.ActionCommand;
import pr4.lysyi.businessLogic.AdminLogic;
import pr4.lysyi.businessLogic.FindNameLogic;
import pr4.lysyi.dao.DAOFactory;
import pr4.lysyi.dao.EnumDAOType;
import pr4.lysyi.dao.jdbc.JDBCUserFacultetDAO;
import pr4.lysyi.dto.Facultet;
import pr4.lysyi.dto.User;
import pr4.lysyi.dto.UserFacultet;
import resources.ConfigurationManager;

/**
 *
 * @author Lysyi Andrii
 */
public class AdminCommand implements ActionCommand {

    @Override
    public String execute(HttpServletRequest request) {
        HttpSession session = request.getSession(true);
        String page = null;
        String action = (String) request.getParameter("whatDo");
        System.out.println(action + "action ");
        Facultet adminFacultet = (Facultet) session.getAttribute("adminFacultet");
        JDBCUserFacultetDAO ufDao = (JDBCUserFacultetDAO) DAOFactory.getDAOFactory(EnumDAOType.USER_FACULTET);

        if (Objects.equals(action, "setUserIncourse")) {                   // set userIncourse
            if (!request.getParameter("userId").isEmpty()) {
                int userId = Integer.parseInt(request.getParameter("userId"));
                boolean isAdded = ufDao.setIncourse(userId, adminFacultet.getId());
                if (isAdded) {
                    request.setAttribute("setRezult", "user " + userId + "added in concurs!");
                } else {
                     request.setAttribute("setRezult", "error for adding " + userId + "in concurs.");
                }
            }
        } else if (Objects.equals(action, "allUsers")) {                    //get list with all users for this facultet
            List<UserFacultet> userFacultet = ufDao.findId(adminFacultet.getId());
            List<String> outUsers = new AdminLogic().transformToStringList((LinkedList<UserFacultet>) userFacultet);
            request.setAttribute("list", outUsers);
        } else if (Objects.equals(action, "selectedUsers")) {               // get list with Incourse users only
            List<UserFacultet> ufList = ufDao.findIdIncourse(adminFacultet.getId());
            request.setAttribute("ufList", ufList);
        } else if (Objects.equals(action, "concursUsers")) {                // get list with winners (minimum grade)
            if (((String) request.getParameter("minGrade")).isEmpty()) {        // add logic with CONCURS plasec for abiturients!
                request.setAttribute("error", "Void number");
                return page = ConfigurationManager.getProperty(ConfigurationManager.START_ADMIN);
            }
            Integer minGrade = Integer.parseInt(request.getParameter("minGrade"));
            List<User> userList = ufDao.findIdIncourseGrade(adminFacultet.getId(), minGrade);   // remove pass from userList + add hash!!!
            request.setAttribute("userList", userList);
        } else {
            request.setAttribute("list", "ERROR");
        }
        return page = ConfigurationManager.getProperty(ConfigurationManager.START_ADMIN);

    }

}

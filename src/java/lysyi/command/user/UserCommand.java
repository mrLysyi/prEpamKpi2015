/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lysyi.command.user;

import java.util.LinkedList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import lysyi.contoller.logic.ActionCommand;
import pr4.lysyi.businessLogic.FindNameLogic;
import pr4.lysyi.dto.Facultet;
import resources.ConfigurationManager;
import resources.MessageManager;

/**
 *
 * @author Lysyi Andrii
 */
public class UserCommand implements ActionCommand{

    @Override
    public String execute(HttpServletRequest request) {
        String page=null;
        HttpSession session = request.getSession(true); 
        request.setAttribute("user", session.getAttribute("name"));
        String facultetName = (String) request.getParameter("facultet");     // previous registred facultet  
        List<Facultet> facultetList = (List<Facultet>) session.getAttribute("facultetList");
        request.setAttribute("facultetList", facultetList);
        int facultetId = new FindNameLogic().existFacultName(facultetList, facultetName);
        System.out.println(facultetId);
        if (facultetName.isEmpty() || facultetId == -1){  // incorect
            page = ConfigurationManager.getProperty(ConfigurationManager.START_USER);
            request.setAttribute("wrongData",MessageManager.getProperty(MessageManager.INCRORECT_DATA));
        } else{                                                                                             //sucsess
            String examName = (new FindNameLogic().getExamName(facultetName)).trim();
            session.setAttribute("curentFacultetName", facultetName);
            session.setAttribute("curentFacultetId", facultetId);
            session.setAttribute("ExamName", examName);
            request.setAttribute("ExamName", examName);
            page = ConfigurationManager.getProperty(ConfigurationManager.ADD_FACULTET_USER);
        }        
        return page;      
    }
    
}

package pr4.lysyi.command.autorization;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import pr4.lysyi.contoller.logic.ActionCommand;
import pr4.lysyi.businessLogic.LoginLogic;
import pr4.lysyi.dao.AbstractDAO;
import pr4.lysyi.dao.DAOFactory;
import pr4.lysyi.dao.EnumDAOType;
import pr4.lysyi.dao.jdbc.JDBCFacultetDAO;
import pr4.lysyi.dao.jdbc.JDBCUserDAO;
import pr4.lysyi.dto.Facultet;
import pr4.lysyi.dto.User;
import pr4.lysyi.filter.ClientType;
import pr4.lysyi.util.Validator;
import pr4.lysyi.resources.ConfigurationManager;
import pr4.lysyi.resources.MessageManager;

/**
 * Login page
 * @author Lysyi Andrii
 */
public class LoginCommand implements ActionCommand {

    private static final String PARAM_NAME_LOGIN = "login";
    private static final String PARAM_NAME_PASSWORD = "password";

    @Override
    public String execute(HttpServletRequest request) {
        String page = null;// extract password and login from request

        String login = request.getParameter(PARAM_NAME_LOGIN);  // add FILTER
        String pass = request.getParameter(PARAM_NAME_PASSWORD);// for login and password  
        Validator v = new Validator();
        if(!v.validateLogin(login, pass) ) {    // empty string, not valid string
            request.setAttribute("errorLoginPassMessage",
                    MessageManager.getProperty("message.loginerror"));
            page = ConfigurationManager.getProperty("path.page.login");
            System.out.println("ERROR");
            return page;
            
        }
        
        JDBCUserDAO userDao = (JDBCUserDAO) DAOFactory.getDAOFactory(EnumDAOType.USER);
        User loginUser = userDao.read(login); // read user from DB by email
        if (new LoginLogic().checkLogin(loginUser, pass, login)) {                      // check login and password           
           
            String userName = loginUser.getFirstName() + " " + loginUser.getPartonymic() + " " + loginUser.getLastName();
            request.setAttribute("user", userName);
            HttpSession session = request.getSession(true);            
            session.setAttribute("name", userName);
            session.setAttribute("userID", loginUser.getId());
            List<Facultet> facultetList = new LoginLogic().getFacultetList();          // send facultet list to JSP  
            session.setAttribute("facultetList", facultetList);
            request.setAttribute("facultetList", facultetList);
            if(loginUser.getRole().equals("admin")){                         // redirect, admin or user?
                JDBCFacultetDAO facultetDao = (JDBCFacultetDAO) DAOFactory.getDAOFactory(EnumDAOType.FACULTET);
                Facultet adminFacultet = facultetDao.findByAdmin(loginUser.getEmail());
                session.setAttribute("adminFacultet", adminFacultet);
                if(adminFacultet == null){                                  //admin login (email did not find in DB.facultet)
                     request.setAttribute("errorLoginPassMessage",
                     MessageManager.getProperty(MessageManager.LOGIN_ERROR));
                     ConfigurationManager.getProperty(ConfigurationManager.LOGIN);
                     return ConfigurationManager.getProperty(ConfigurationManager.LOGIN);
                }
//                System.out.println("ADMIN");
                 page = ConfigurationManager.getProperty(ConfigurationManager.START_ADMIN);
                 session.setAttribute("userType", ClientType.ADMINISTRATOR);                 
            } else {
                page = ConfigurationManager.getProperty(ConfigurationManager.START_USER);   //user
                session.setAttribute("userType", ClientType.USER);                 
            }

        } else {
            request.setAttribute("errorLoginPassMessage",
            MessageManager.getProperty(MessageManager.LOGIN_ERROR));
            page = ConfigurationManager.getProperty(ConfigurationManager.LOGIN);
        }
        return page;
    }

}

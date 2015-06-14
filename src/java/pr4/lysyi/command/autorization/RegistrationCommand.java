
package pr4.lysyi.command.autorization;

import pr4.lysyi.contoller.logic.ActionCommand;
import javax.servlet.http.HttpServletRequest;
import pr4.lysyi.dao.DAOFactory;
import pr4.lysyi.dao.EnumDAOType;
import pr4.lysyi.dao.jdbc.JDBCUserDAO;
import pr4.lysyi.dto.User;
import pr4.lysyi.util.Validator;
import pr4.lysyi.resources.ConfigurationManager;
import pr4.lysyi.resources.MessageManager;

/**
 * Registration new user
 * @author Lysyi Andrii
 */
public class RegistrationCommand implements ActionCommand {

    private static final String PARAM_NAME_FIRSTNAME = "firstname";
    private static final String PARAM_NAME_LASTNAME = "lastname";
    private static final String PARAM_NAME_PATRONYMIC = "patronymic";
    private static final String PARAM_NAME_PASS = "password";
    private static final String PARAM_NAME_PASS2 = "password2";
    private static final String PARAM_NAME_MAIL = "mail";
    private static final String PARAM_NAME_CITY = "city";
    private static final String PARAM_NAME_COUNTRY = "country";

    /**
     *
     * @param request
     * @return
     */
    @Override
    public String execute(HttpServletRequest request) {
        String page = null;// extract password and login from request
        String firstname = request.getParameter(PARAM_NAME_FIRSTNAME);
        String lastname = request.getParameter(PARAM_NAME_LASTNAME);
        String patronymic = request.getParameter(PARAM_NAME_PATRONYMIC);
        String pass = request.getParameter(PARAM_NAME_PASS);
        String pass2 = request.getParameter(PARAM_NAME_PASS2);
        String email = request.getParameter(PARAM_NAME_MAIL);
        String city = request.getParameter(PARAM_NAME_CITY);
        String country = request.getParameter(PARAM_NAME_COUNTRY);
        request.setAttribute("firstname", firstname);
        request.setAttribute("lastname", lastname);
        request.setAttribute("patronymic", patronymic);      
        request.setAttribute("mail", email);
        request.setAttribute("city", city);
        request.setAttribute("country", country);       
//        String email = request.getParameter(PARAM_NAME_MAIL);
        Validator validator = new Validator();
        if (!validator.validateUserRegistration(firstname, lastname, patronymic, city, country)){
            request.setAttribute("wrongData", MessageManager.getProperty(MessageManager.INCRORECT_DATA));
            System.out.println("incorect data"+" "+firstname+" "+lastname+" "+patronymic+" "+city+" "+ country);
            return ConfigurationManager.getProperty(ConfigurationManager.CREATE_USER);
        }
        else if (!pass.equals(pass2)|| pass.isEmpty()){
            request.setAttribute("pass12", MessageManager.getProperty(MessageManager.PASS_EQUALS_EACHOTHER));
            return ConfigurationManager.getProperty(ConfigurationManager.CREATE_USER);
        } else if(!validator.validEmail(email)){
            request.setAttribute("emailError", MessageManager.getProperty(MessageManager.INVALID_EMAIL));
            return ConfigurationManager.getProperty(ConfigurationManager.CREATE_USER);
        }        
         User user = new User(firstname, lastname, patronymic, email, pass2, city, country, "user");
        user.setEmail(email);       
        JDBCUserDAO userDao = (JDBCUserDAO) DAOFactory.getDAOFactory(EnumDAOType.USER);
        if (!userDao.create(user)){ // unsucsess User creation (error or busy email)
            request.setAttribute("emailError", MessageManager.getProperty(MessageManager.INVALID_EMAIL));
            return ConfigurationManager.getProperty(ConfigurationManager.CREATE_USER);
        }       
         page = ConfigurationManager.getProperty(ConfigurationManager.LOGIN);
        return page;

    }

}

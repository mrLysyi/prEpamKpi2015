/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lysyi.command.autorization;


import lysyi.contoller.logic.ActionCommand;
import resources.ConfigurationManager;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Lysyi Andrii
 */
public class LogoutCommand implements ActionCommand {

    @Override
    public String execute(HttpServletRequest request) {
        System.out.println("LogoutCommand");
        String page = ConfigurationManager.getProperty(ConfigurationManager.LOGIN);
        // уничтожение сессии
        request.getSession().invalidate();
        return page;
    }
}

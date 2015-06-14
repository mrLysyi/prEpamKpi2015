/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pr4.lysyi.command.autorization;


import pr4.lysyi.contoller.logic.ActionCommand;
import pr4.lysyi.resources.ConfigurationManager;
import javax.servlet.http.HttpServletRequest;

/**
 * Logout
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

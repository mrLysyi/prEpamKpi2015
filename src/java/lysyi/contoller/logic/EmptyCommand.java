/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lysyi.contoller.logic;

import lysyi.contoller.logic.ActionCommand;
import resources.ConfigurationManager;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Lysyi Andrii
 */
public class EmptyCommand implements ActionCommand {

    @Override
    public String execute(HttpServletRequest request) {
        /* в случае ошибки или прямого обращения к контроллеру
         * переадресация на страницу ввода логина */
        String page = ConfigurationManager.getProperty("path.page.login");
        return page;
    }

   
}

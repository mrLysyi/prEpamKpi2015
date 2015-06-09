/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package resources;

import java.util.ResourceBundle;

/**
 *
 * @author Lysyi Andrii
 */
public class MessageManager {
// класс извлекает информацию из файла messages.properties
    private final static ResourceBundle resourceBundle = ResourceBundle.getBundle("resources.messages");
    
    public final static String LOGIN_ERROR = "message.loginerror";
    public final static String PAGE_NOT_FOUND= "message.nullpage";
    public final static String WRONGACTION= "message.wrongaction";
    public final static String INCRORECT_DATA = "message.incorectData";
    public final static String PASS_EQUALS_EACHOTHER= "message.passEquals";
    public final static String INVALID_EMAIL= "message.invalidEmail";
//    public final static String = "";


    private MessageManager() {
    }

    public static String getProperty(String key) {

        return resourceBundle.getString(key);
    }
//    public static void main(String[] args) {
//        MessageManager mm = new  MessageManager();
//        
//        System.out.println(mm.getProperty("message.nullpage"));
//    }
}

package resources;

import java.util.ResourceBundle;

/**
 * класс извлекает информацию из файла config.properties
 *
 * @author Lysyi Andrii
 */
public class ConfigurationManager {

    public final static String INDEX            = "path.page.index";
    public final static String LOGIN            = "path.page.login";
    public final static String MAIN             = "path.page.main";
    public final static String ERROR            = "path.page.error";
    public final static String START_USER       = "path.page.startUser";
    public final static String START_ADMIN      = "path.page.startAdmin";
    public final static String CREATE_USER      = "path.page.createUser";
    public final static String CONFIG_ADMIN     = "path.page.configAdmin";
    public final static String CONFIG_USER      = "path.page.configUser";
    public final static String ADD_FACULTET_USER= "path.page.addFacultetUser";
    public final static String FACULTET_ACTION  = "path.page.facultetAction";
    public final static String ADD_USER_TO_SHEET= "path.page.addUserToSheet";
        //        public final static String = "";

    private final static ResourceBundle resourceBundle = ResourceBundle.getBundle("resources.config");

    private ConfigurationManager() {
    }

    public static String getProperty(String key) {

        return resourceBundle.getString(key);
    }

//        public static void main(String[] args) {
//        String page = ConfigurationManager.getProperty("path.page.index");
//        
//        System.out.println(ConfigurationManager.getProperty(LOGIN));
//    }
}

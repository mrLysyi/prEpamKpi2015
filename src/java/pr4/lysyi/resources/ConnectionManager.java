

package pr4.lysyi.resources;

import java.util.ResourceBundle;

/**
 *
 * @author hellow
 */
public class ConnectionManager {
    //    public final static String = "";
    
    
    
    
    private final static ResourceBundle resourceBundle = ResourceBundle.getBundle("resources.db");


    private ConnectionManager() {
    }

    public static String getProperty(String key) {

        return resourceBundle.getString(key);
    }
    public static void main(String[] args) {
        System.out.println(ConnectionManager.getProperty("dbUrl"));
        
    }
}

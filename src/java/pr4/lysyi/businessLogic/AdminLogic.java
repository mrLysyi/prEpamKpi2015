package pr4.lysyi.businessLogic;

import java.util.Iterator;
import java.util.LinkedList;
import pr4.lysyi.dto.UserFacultet;

/**
 * work with admin page
 * @author Lysyi Andrii
 */
public class AdminLogic {
    
    public LinkedList<String>  transformToStringList(LinkedList<UserFacultet> userFacultet){
        LinkedList<String> outList = new LinkedList<>();
        Iterator it = userFacultet.iterator();
        while (it.hasNext()) {
            UserFacultet obj = (UserFacultet)it.next();
            outList.add("User ID: "+obj.getUserId()+"   User Name: "+obj.getUserName()+"; incourse - "+obj.isIncourse()+"  sumMark: "+obj.getSumMark());
        }
        return outList;
    }
    
}

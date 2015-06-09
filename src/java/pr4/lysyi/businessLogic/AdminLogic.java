/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pr4.lysyi.businessLogic;

import java.util.Iterator;
import java.util.LinkedList;
import pr4.lysyi.dto.UserFacultet;

/**
 *
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

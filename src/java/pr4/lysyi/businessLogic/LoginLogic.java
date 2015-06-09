package pr4.lysyi.businessLogic;


import java.util.Iterator;
import java.util.List;
import pr4.lysyi.dao.DAOFactory;
import pr4.lysyi.dao.EnumDAOType;
import pr4.lysyi.dao.jdbc.JDBCFacultetDAO;
import pr4.lysyi.dto.Facultet;
import pr4.lysyi.dto.User;


/**
 *
 * @author Lysyi Andrii
 */
public class LoginLogic {

    public boolean checkLogin(User loginUser, String enterPass, String enterPassword) {
        String enterLogin = loginUser.getEmail();        
        if (loginUser== null || loginUser.getEmail() == null || !loginUser.getEmail().equals(enterLogin) ){
            return false;
        }
        //String name = loginUser.getFirstName() + " " + loginUser.getPartonymic()+ " " + loginUser.getLastName();
        return loginUser.checkPass(enterPass, enterPassword);
//        return ADMIN_LOGIN.equals(enterLogin) && ADMIN_PASS.equals(enterPass);
    }
    public List<Facultet> getFacultetList(){
       JDBCFacultetDAO facultetDao = (JDBCFacultetDAO) DAOFactory.getDAOFactory(EnumDAOType.FACULTET);
       return facultetDao.findAll(); 
    }
    
    
    public static void main(String[] args) {
//        System.out.println(LoginLogic.checkLogin("ivan@mail.com", "ivan"));
        List<Facultet> list = new LoginLogic().getFacultetList();
        Iterator it  =  list.iterator();
        while (it.hasNext()) {
            Facultet next = (Facultet) it.next();
            System.out.println(next.getId());
        }
    }
}

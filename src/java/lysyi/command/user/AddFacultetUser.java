
package lysyi.command.user;

import java.util.Objects;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import lysyi.contoller.logic.ActionCommand;
import pr4.lysyi.dao.DAOFactory;
import pr4.lysyi.dao.EnumDAOType;
import pr4.lysyi.dao.jdbc.JDBCUserFacultetDAO;
import pr4.lysyi.dto.UserFacultet;
import pr4.lysyi.util.Validator;
import resources.ConfigurationManager;
import resources.MessageManager;

/**
 *
 * @author Lysyi Andrii
 */
public class AddFacultetUser implements ActionCommand {

    @Override
    public String execute(HttpServletRequest request) {
        String page = null;
        if(Objects.equals (request.getParameter("back"), "back")){
            return ConfigurationManager.getProperty(ConfigurationManager.START_USER);
        }
        HttpSession session = request.getSession(true);
        String facName = (String) session.getAttribute("curentFacultetName");
        String examNames = (String) session.getAttribute("ExamName");
//        System.out.println("examNames" + examNames);
        request.setAttribute("examNames", examNames);
        String znoStr = request.getParameter("zno");
        String gradeOneStr = request.getParameter("grade1");
        String gradeTwoStr = request.getParameter("grade2");
        String gradeThreeStr = request.getParameter("grade3");
        if (znoStr.isEmpty() || gradeOneStr.isEmpty() || gradeTwoStr.isEmpty() || gradeThreeStr.isEmpty()) {    // void string validation
            request.setAttribute("zno", znoStr);
            request.setAttribute("grade1", gradeOneStr);
            request.setAttribute("grade2", gradeTwoStr);
            request.setAttribute("grade3", gradeThreeStr);
            request.setAttribute("wrongData", MessageManager.getProperty(MessageManager.INCRORECT_DATA));
            return ConfigurationManager.getProperty(ConfigurationManager.ADD_FACULTET_USER);

        }
        int zno = Integer.parseInt(znoStr);
        int grade1 = Integer.parseInt(gradeOneStr);
        int grade2 = Integer.parseInt(gradeTwoStr);
        int grade3 = Integer.parseInt(gradeThreeStr);

        if (!new Validator().valideMarks(zno, grade1, grade2, grade3)) {        // Faild grades walidation
            request.setAttribute("zno", zno);
            request.setAttribute("grade1", grade1);
            request.setAttribute("grade2", grade2);
            request.setAttribute("grade3", grade3);
            page = ConfigurationManager.getProperty(ConfigurationManager.ADD_FACULTET_USER);
            request.setAttribute("wrongData", MessageManager.getProperty(MessageManager.INCRORECT_DATA));
        } else {
            //  add int USER_Facultet DAO 
            int facultetId = (int) session.getAttribute("curentFacultetId");
            int userId = (int) session.getAttribute("userID");
            UserFacultet userFacultet = new UserFacultet(userId, facultetId, zno, grade1, grade2, grade3);
            JDBCUserFacultetDAO userFacultetDao = (JDBCUserFacultetDAO) DAOFactory.getDAOFactory(EnumDAOType.USER_FACULTET);
            
            // sucsess registration to facultet
            if (userFacultetDao.setUserFaultet(facultetId, userId, zno, grade3, grade3, grade3)) {//DAO
                request.setAttribute("sucsessFacultReg", "registration to facultet " +facName + " sucsess!");    // sucsess DAO, redirect
                page = ConfigurationManager.getProperty(ConfigurationManager.START_USER);
            } else {
                 request.setAttribute("wrongData", MessageManager.getProperty(MessageManager.WRONGACTION));        
                 page = ConfigurationManager.getProperty(ConfigurationManager.ADD_FACULTET_USER);
            }
        }
    
    return page ;
}

}

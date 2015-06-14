package pr4.lysyi.businessLogic;

import java.util.Iterator;
import java.util.List;
import pr4.lysyi.dao.DAOFactory;
import pr4.lysyi.dao.EnumDAOType;
import pr4.lysyi.dao.jdbc.JDBCFacultetDAO;
import pr4.lysyi.dto.Facultet;

/**
 *
 * @author Lysyi Andrii
 */
public class FindNameLogic {
    
    /**
     * 
     * @param list
     * @param facultetName
     * @return -1 if facultetName DO NOT exist, otherwise - facultet's number 
     */
    public int existFacultName(List<Facultet> list, String facultetName){
        int FacId=-1;
        Iterator it = list.iterator();
        while(it.hasNext()){
        Facultet fac = (Facultet) it.next();
            if(fac.getName().equals(facultetName)){                
                return fac.getId();
            }
        }
        return FacId;
    }
    
    /**
     * 
     * @param facultetName
     * @return selected facultet name
     */
    public String getExamName(String facultetName){
        JDBCFacultetDAO facultetDao = (JDBCFacultetDAO) DAOFactory.getDAOFactory(EnumDAOType.FACULTET);
        return facultetDao.getExamNames(facultetName);
    }
    
}

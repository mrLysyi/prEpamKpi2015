
package pr4.lysyi.dto;

/**
 *  This class represent User with minimum information inside 
 * @author Lysyi Andrii
 */
public class TransUser {
    private final int id ;
    private String name ;
    private int grade ;
    private String email;
    public TransUser(User user) {
        this.id = user.getId();
        this.email = user.getEmail();
//        this.grade = user.get
    }
    
    
}

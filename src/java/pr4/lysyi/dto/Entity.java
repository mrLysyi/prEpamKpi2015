package pr4.lysyi.dto;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Lysyi Andrii
 */
public abstract class Entity {

   private int id;

    public Entity() {
    }

    public Entity(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }   

    public void setId(int id) {
        this.id = id;
    }
    
   
}

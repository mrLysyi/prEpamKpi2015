package pr4.lysyi.dto;

import java.sql.Date;
import java.sql.Timestamp;

/**
 *
 * @author Lysyi Anderii
 */
public class User extends Entity {

    private String firstName;
    private String lastName;        //surename
    private String partonymic;      // Sergievich
    private String email;
    private String login;
    private String password;
    private String city;
    private String country;
    private Date creationDate;
    private String role;

    public User() {
        Timestamp stamp = new Timestamp(System.currentTimeMillis());
        this.creationDate = new Date(stamp.getTime());
    }

    public User(String email, String password) {
        this.email = email;
        this.password = password;
        Timestamp stamp = new Timestamp(System.currentTimeMillis());
        this.creationDate = new Date(stamp.getTime());
    }

    public User(int id, String firstName, String lastName, String partonymic,
            String email, String password, String city,
            String country, String role) { //, Date creationDate 
        super(id);
        this.firstName = firstName;
        this.lastName = lastName;
        this.partonymic = partonymic;
        this.email = email;
        this.password = password;
        this.city = city;
        this.country = country;
        this.role = role;
        Timestamp stamp = new Timestamp(System.currentTimeMillis());
        this.creationDate = new Date(stamp.getTime());
    }

    public User(String firstName, String lastName, String partonymic,
            String email, String password, String city,
            String country, String role) { //without id    
        this.firstName = firstName;
        this.lastName = lastName;
        this.partonymic = partonymic;
        this.email = email;
        this.password = password;
        this.city = city;
        this.country = country;
        Timestamp stamp = new Timestamp(System.currentTimeMillis());
        this.creationDate = new Date(stamp.getTime());
        this.role = role;
    }

    public void add(int id, String firstName, String lastName, String partonymic,
            String email, String password, Date date, String role, String city,
            String country) {
        super.setId(id);
        this.firstName = firstName;
        this.lastName = lastName;
        this.partonymic = partonymic;
        this.email = email;
        this.setPassword(password);
        this.city = city;
        this.country = country;
        this.creationDate = date;
        this.setRole(role);

    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPartonymic() {
        return partonymic;
    }

    public void setPartonymic(String partonymic) {
        this.partonymic = partonymic;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    private void setCreationDate(Date date) {
//        Timestamp stamp = new Timestamp(System.currentTimeMillis());
//        Date date = new Date(stamp.getTime());
        this.creationDate = date;
    }

    public boolean checkPass(String pass, String login) {
        if (pass == "" || pass == null || login == "" || login==null) {
            return false;
        }
        return this.getPassword().equals(pass) && this.getEmail().equals(login);
    }

    @Override
    public String toString() {
        return "User{" + "id= " + super.getId() + "firstName=" + firstName
                + ", lastName=" + lastName + ", partonymic=" + partonymic
                + ", email=" + email + ", password=" + password + ", city=" + city
                + ", country=" + country + ", creationDate=" + creationDate
                + ", role=" + role + '}';
    }

    public static void main(String[] args) {
        Timestamp stamp = new Timestamp(System.currentTimeMillis());
        Date date = new Date(stamp.getTime());
        System.out.println(date);
    }

}

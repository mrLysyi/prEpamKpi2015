package pr4.lysyi.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * check incoming String
 *
 * @author Lysyi Andrii
 */
public class Validator {

    private static final Pattern UUID_PATTERN = Pattern.compile("^[0-9a-f]{8}(-[0-9a-f]{4}){3}-[0-9a-f]{12}$");
    private static final Pattern INTEGER_PATTERN = Pattern.compile("[0-9]+");
    private static final Pattern DOUBLE_PATTERN= Pattern.compile("([0-9]*\\.[0-9]+)|([0-9]+\\.[0-9]*)");
    private static final Pattern CHARACTER_PATTERN = Pattern.compile("'.'");
    private static final Pattern STRING_PATTERN= Pattern.compile("^[а-яА-ЯёЁa-zA-Z0-9]+$");
   private static final Pattern PASSWORD_PATTERN= Pattern.compile("(?=^.{8,}$)((?=.*\\d)|(?=.*\\W+))(?![.\\n])(?=.*[A-Z])(?=.*[a-z]).*$")  ; //8 symbols
//    private static final Pattern = Pattern.compile();
  

    public boolean validateUserRegistration(String firstname, String lastname, String patronymic, String city, String country) {
       if ((!stringWordValid(firstname)|| !stringWordValid(lastname)|| 
                !stringWordValid(patronymic)|| !stringWordValid(city)|| !stringWordValid(country) )){
           return false;
       }
       return true;
    }
    
    public boolean valideMarks(int zno, int gr1, int gr2, int gr3){
        if((zno>=0 && zno<500) && (gr1>=0 && gr1<500)&& (gr2>=0 && gr2<500)&& (gr2>=0 && gr2<500)){
            return true;
        }
        return false;
    }

    public boolean validateLogin(String login, String pass) {
//        if ("".equals(pass) || "".equals(login) || pass == null || login == null
//                || "null".equals(pass) || "null".equals(login)) {
//            return false;
//        }
        Matcher matcher = PASSWORD_PATTERN.matcher(pass);
        if (!this.minMaxLength(pass, 2, 25)) {
            return false;
        } else if (!this.validEmail(login) ) {
            return false;
        } 
//        else if(!matcher.find()){     // pass validation
//            return false;
//        }
        
        return true;
    }
    
    public boolean stringWordValid(String str){
        Matcher matcher = STRING_PATTERN.matcher(str);
        boolean found = matcher.find(); // true if matches pattern
        if(str==null || str.equals(""))
            return false;
        return found;
    }
    
    
    /**
     *
     * @param str
     * @param minLen minimal String length
     * @return true, if str.length > minLen and do not contain whitespace
     */
    public  boolean minLength(String str, int minLen) { //throws IllegalArgumentException
        Pattern pattern = Pattern.compile("\\s");                                   //contain whitespace
        Matcher matcher = pattern.matcher(str);
        boolean found = matcher.find();

        if (!found && !str.contains(" ")) {
            if (str.length() > minLen) {
                return true;    //throw new IllegalArgumentException();
            }
        }
        return false;
    }

    /**
     *
     * @param str
     * @param len - max str length
     * @return true, if do not contain whitespace, and str.length < len
     */
    public  boolean maxLength(String str, int len) {
        Pattern pattern = Pattern.compile("\\s");                                   //contain whitespace
        Matcher matcher = pattern.matcher(str);
        boolean found = matcher.find();
        
        if (!found && !str.contains(" ")) {
            if (str.length() < len) {
                return true;    //throw new IllegalArgumentException();
            }
        }
        return false;
    }

    /**
     *
     * @param str
     * @param minLen
     * @param maxLen
     * @return true, if string is in borers minLen && maxLen exclusive
     */
    public boolean minMaxLength(String str, int minLen, int maxLen) {       //@return true if string is valid
        Pattern pattern = Pattern.compile("\\s");                                   //----contain whitespace
        Matcher matcher = pattern.matcher(str);
        boolean found = matcher.find();

        if (!found && !str.contains(" ")) {
            if (str.length() > minLen) {
                if (str.length() < maxLen) {
                    return true;    //throw new IllegalArgumentException();
                }
            }
        }
        return false;
    }

    /**
     * must contain '@' symbol
     * @param email
     * @return true if email length is in border (4..30) and do not contain
     * whitespace
     */
    public  boolean validEmail(String email) {
        if (!minMaxLength(email, 3, 25)) {
            return false;
        } else if (!email.contains("@")) {
            return false;
        } else {
            return true;
        }
    }
    
    /**
     * length (2..25), no whitespace, valid email
     * @param passOne
     * @param passTwo
     * @param email
     * @return 
     */
    public  boolean validRegistration(String passOne, String passTwo, String email) {
        if (!passOne.equals(passTwo)) {
            return false;
        } else if (!this.minMaxLength(passOne, 2, 25)) {
            return false;
        } else if (!this.validEmail(email)) {
            return false;
        }
        return true;
    }
    
    /**
     * UNUSED
     * @param uuid
     * @return 
     */
    public boolean isValidUuid(String uuid) {
        return UUID_PATTERN.matcher(uuid).matches();
    }
    
//    public  String parse(String data) {
//        String s = data;
//        String filter = "[^\\w\\s]";//[^'\\-!@#$%^&*()] ";
//        String patternstring = "((\\w*\\s)*)";
//        Pattern pattern = Pattern.compile(patternstring);
//        Matcher m = pattern.matcher(data);
//
//        data = data.replaceAll(filter, "");
//        StringBuilder sb = new StringBuilder(data);
//        int q = 0;
//        int w = 0;
//        if (data.charAt(0) == ' ') {
//            w = q + 1;
//            while (sb.charAt(w) == ' ') {
//                sb.deleteCharAt(w);
//            }
//            q++;
//            sb.deleteCharAt(0);
//        }
//        for (int i = 0; i < sb.length() - 1; i++) {
//            int j = 0;
//            if (sb.charAt(i) == ' ') {
//                j = i + 1;
//                while (sb.charAt(j) == ' ') {
//                    sb.deleteCharAt(j);
//                }
//            }
//        }
//        return sb.toString();
//    }
    
    public static void main(String[] args) {
        Validator v = new Validator();
        System.out.println(v.stringWordValid("as;#$@*&%(@#&$()*@&#$(*d") + ""+ v.stringWordValid("@")+ ""+ v.stringWordValid("Имя")+ ""+ v.stringWordValid("Name"));
        System.out.println(v.validateUserRegistration("aa", "asdasd", "zzz", "asdasd", "aasd"));
        System.out.println(v.validEmail("qqqq@"));
    }
}

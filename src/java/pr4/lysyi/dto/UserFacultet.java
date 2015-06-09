package pr4.lysyi.dto;

import java.util.ArrayList;

/**
 *
 * @author Lysyi Anderii
 */
public class UserFacultet extends Entity{
    private final int userId;
    private final int facultetId;
    private int znoGrade=0;
    private int grade_one= 0;
    private int grade_two = 0;
    private int grade_three = 0;
    private boolean enrolled = false;
    private boolean incourse = false;
    private String userName;

    public boolean isIncourse() {
        return incourse;
    }

    public void setIncourse(boolean incourse) {
        this.incourse = incourse;
    }
    
    public UserFacultet(int userId, int facultetId) {
        this.userId = userId;
        this.facultetId = facultetId;
    }

    public UserFacultet(int userId, int facultetId, int znoGrade, int grade_one,
            int grade_two, int grade_three, boolean enrolled, boolean incourse,
            String userName) {
        this.userId = userId;
        this.facultetId = facultetId;
        this.znoGrade = znoGrade;
        this.grade_one = grade_one;
        this.grade_two = grade_two;
        this.grade_three = grade_three;
        this.enrolled = enrolled;
        this.incourse = incourse;
        this.userName = userName;
    }
      public UserFacultet(int userId, int facultetId, int znoGrade, int grade_one,
            int grade_two, int grade_three) {
        this.userId = userId;
        this.facultetId = facultetId;
        this.znoGrade = znoGrade;
        this.grade_one = grade_one;
        this.grade_two = grade_two;
        this.grade_three = grade_three;       
    }

    public int getZnoGrade() {
        return znoGrade;
    }

    public void setZnoGrade(int znoGrade) {
        this.znoGrade = znoGrade;
    }

    public int getGrade_one() {
        return grade_one;
    }

    public void setGrade_one(int grade_one) {
        this.grade_one = grade_one;
    }

    public int getGrade_two() {
        return grade_two;
    }

    public void setGrade_two(int grade_two) {
        this.grade_two = grade_two;
    }

    public int getGrade_three() {
        return grade_three;
    }

    public void setGrade_three(int grade_three) {
        this.grade_three = grade_three;
    }

    public boolean isEnrolled() {
        return enrolled;
    }

    public void setEnrolled(boolean enrolled) {
        this.enrolled = enrolled;
    }

    public int getUserId() {
        return userId;
    }

    public int getFacultetId() {
        return facultetId;
    }

    public ArrayList<Integer>  getMarks(){
        ArrayList<Integer> list = new ArrayList<>(4);
        list.add(znoGrade);
        list.add(grade_one);
        list.add(grade_two);
        list.add(grade_three);
        return list;
    }
    
    public boolean setMarks(ArrayList<Integer> list){
        if (list.size() < 4)
        this.znoGrade = list.get(0);
        this.grade_one = list.get(1);
        this.grade_two = list.get(2);
        this.grade_three = list.get(3);
        return true;        
    }
    
    public int getSumMark(){
        return this.znoGrade + this.grade_one + this.grade_two + this.grade_three;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
    
    
    
    @Override
    public String toString() {
        return "UserFacultet{" + "userId=" + userId + ", facultetId=" + facultetId + ", znoGrade=" + znoGrade + ", grade_one=" + grade_one + ", grade_two=" + grade_two + ", grade_three=" + grade_three + ", enrolled=" + enrolled + ", incourse=" + incourse + ", userName=" + userName + '}';
    }

   
    
     
     
}

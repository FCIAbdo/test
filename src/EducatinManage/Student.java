package EducatinManage;
import java.util.*;
public class Student {
    private int studId;
    private int studUserName;
    private int studPassword;
    private String studFirstName;
    private String studMidleName;
    private String studLastName;
    private String studEmail;
    private ArrayList<Course>studListOfCourses;
    public Student() {
        studListOfCourses=new ArrayList<Course>();
    }
    public void setId(int id) {
        studId=id;
    }
    public void setUserName(int userName) {
        studUserName=userName;
    }
    public void setPassword(int password) {
        studPassword=password;
    }
    public void setFullName(String firstName,String midleName,String lastName) {
        studFirstName=firstName;
        studMidleName=midleName;
        studLastName=lastName;
    }
    public void setEmail(String Email) {
        studEmail=Email;
    }
    public int getStudId() {
        return studId;
    }
    public int getStudUserName() {
         return studUserName;        
    }
    public int getStudPassword() {
        return studPassword;
    }
    public String getStudFullName() {
        return studFirstName+" "+studMidleName+" "+studLastName;
    }
    public String getStudEmail() {
        return studEmail;
    }
    public void registeration(Course course) {
        studListOfCourses.add(course);
        course.registerInCourse(studId);
    }
    public void unRegisteration(Course course) {
        studListOfCourses.remove(course);
    }
    public ArrayList<Course> getCourses() {
        return studListOfCourses;
    }
}

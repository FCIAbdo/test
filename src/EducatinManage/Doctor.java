package EducatinManage;
import java.util.*;
import java.io.*;
public class Doctor {
    private int docId;
    private int docUserName;
    private int docPassword;
    private String docFirstName;
    private String docMidleName;
    private String docLastName;
    private String docEmail;
    private ArrayList<Course>docListOfCourses;
    public Doctor() {
        docListOfCourses=new ArrayList<Course>();
    }
    public void setId(int id) {
        docId=id;
    }
    public void setUserName(int userName) {
        docUserName=userName;
    }
    public void setPassword(int password) {
        docPassword=password;
    }
    public void setFullName(String firstName,String midleName,String lastName) {
        docFirstName=firstName;
        docMidleName=midleName;
        docLastName=lastName;
    }
    public void setEmail(String email) {
        docEmail=email;
    }
    public void addCourse(Course course) {
        docListOfCourses.add(course);
    }
    public ArrayList<Course> getListOfCourses() {
        return docListOfCourses;
    }
    public Course getCourse(String courseCode) {
        for(Course course:docListOfCourses) {
            if(course.getCourCode()==courseCode)
                return course;
        }
        return null;
    }
    public int getDocId() {
        return docId;
    }
    public int getDocUserName() {
         return docUserName;        
    }
    public int getDocPassword() {
        return docPassword;
    }
    public String getDocFullName() {
        return docFirstName+" "+docMidleName+" "+docLastName;
    }
    public String getDocEmail() {
        return docEmail;
    }
    
}

package EducatinManage;
import java.util.*;
public class Course {
    private String coursName;
    private String coursCode;
    private String doctorName;
    private ArrayList<Integer>studId;
    private   int  doctorId;
    private ArrayList<Assignment>assignmentList;
    public Course() {
        assignmentList=new ArrayList<Assignment>();
        studId=new ArrayList<Integer>();
    }
    public void addAssignment(Assignment ass) {
        assignmentList.add(ass);
    }
    public void setCoursName(String coursName) {
        this.coursName=coursName;
    }
    public void setCourseCode(String coursCode) {
        this.coursCode=coursCode;
    }
    public void  setStudentId(int id) {
        studId.add(id);
    }
    public void setDocName(String doctorName) {
        this.doctorName=doctorName;
    }
    public void setDocId(int doctorId) {
        this.doctorId=doctorId;
    } 
    public String getCourCode() {
        return coursCode;
    }
    public String getCourName() {
        return coursName;
    }
    public ArrayList<Integer> getStudsId() {
        return studId;
    }
    public String getDocName() {
        return doctorName;
    }
    public int getDocId() {
        return doctorId;
    }
    public ArrayList<Assignment> getListOfAssignment() {
        return assignmentList;
    }
    public Assignment getAssgnment(int num) {
        for(Assignment a :assignmentList) {
            if(a.getNum()==num)
                return a;
        }
        return null;
    }
    public void registerInCourse(int studId) {
        this.studId.add(studId);
    }
    public void unRegistFromCourse(int studId) {
        for(int id:this.studId) {
            if(id==studId)
                this.studId.remove(id);
        }
    }
}

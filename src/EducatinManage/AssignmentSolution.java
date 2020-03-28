package EducatinManage;
import java.util.Scanner;
public class AssignmentSolution {
   private float grade;
   private int studentId;
   private String content;
   private String studFirstName;
   private String studMidleName;
   private String studLastName;
   private String comment;
   public AssignmentSolution() {
       grade=-1;
       comment="";
   }
   public void setComment(String com) {
       comment=com;
   }
   public void setGrad(float grad) {
       grade=grad;
   }
   public void setStudentId(int id) {
       studentId=id;
   }
   public void setContent(String content) {
       this.content=content;
   }
   public void setStudentName(String firstName,String midleName,String lastName) {
       studFirstName=firstName;
       studMidleName=midleName;
       studLastName=lastName;
   }
   public String getComment() {
       return comment;
   }
   public float getGrade() {
       return grade;
   }
   public int getStudentId() {
       return studentId;
   }
   public String getContent() {
       return content;
   }
   public String getStudName() {
       return studFirstName+" "+studMidleName+" "+studLastName;
   }
   
}
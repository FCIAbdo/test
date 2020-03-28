package EducatinManage;
import java.util.*;
public class Assignment {
    private int assignNum;
    private float assignGrad;
    private String assignContent;
    ArrayList<AssignmentSolution>assignSoluList;
    public Assignment() {
        assignSoluList=new ArrayList<AssignmentSolution>();
        assignGrad=10;
    }
    public void setNum(int num) {
        assignNum=num;
    }
    public void setGrad(float grad) {
        assignGrad=grad;
    }
    public void setContent(String content) {
        assignContent=content;
    }
    public void addAssignSol(AssignmentSolution as) {
         assignSoluList.add(as);
    }
    public float getGrad() {
        return assignGrad;
    }
    public int getNum() {
        return assignNum;
    }
    public String getContent() {
        return assignContent;
    }
   public ArrayList<AssignmentSolution> getAssignSolutList() {
       return assignSoluList;
   }
   public AssignmentSolution getAssignSolut(int stuId) {
       for(AssignmentSolution as:assignSoluList) {
          if(as.getStudentId()==stuId)
              return as;
       }
     return null;
   }
   public boolean checkStudExist(int id) {
       for(AssignmentSolution a:assignSoluList) {
           if(a.getStudentId()==id)
               return true;
       }
       return false;
   }
}

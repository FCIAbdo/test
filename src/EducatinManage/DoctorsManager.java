package EducatinManage;
import java.util.*;
public class DoctorsManager {
   private Doctor doctor=null;     //to keep  doctor that entered or student.
   Scanner in;
   private ArrayList<Doctor>doctorList;
   public DoctorsManager() {
        doctorList=new ArrayList<Doctor>();
        in=new Scanner(System.in);
   } 
   public  void logInAsDoctor(int userName,int password) {
     boolean check=true;
     while(check==true) {
         for(Doctor d : doctorList) {
           if(d.getDocPassword()==password&&d.getDocUserName()==userName) {
               doctor=d;
               check=false;
               break;
           }
       }
       if(check==true) {
           System.out.println("userName or password is wrong try again ");
           userName=in.nextInt();
           password=in.nextInt();
       }
       else
           break;
     }
     while(true)
       docMainList();
   }
   public void signUpAsDoctor(Doctor doctor) {
       doctorList.add(doctor);
       this.doctor=doctor;
       while(true)
          docMainList();
   }
    private void docMainList() {
       System.out.println("to list your courses enter 1:\n"+"to view your courses enter 2:\n"
                          +"to create course enter 3:\n"+"to log out enter 4:");
       int val=in.nextInt();         in.nextLine();
       if(val==1) {
           listCourses();
       }
       else if(val==2) {
             viewCourses();
       }
       else if(val==3) {
           Course course=new Course();
           try{
               System.out.println("please enter course name and then course code ");
               course.setCoursName(in.nextLine());
               course.setCourseCode(in.nextLine());
               course.setDocName(doctor.getDocFullName());
               course.setDocId(doctor.getDocId());
               doctor.addCourse(course);
           }catch(Exception e) {
               System.out.println(e.getMessage());
           }
       }
       else if(val==4) {
           SystemManager.start();
       }
       else
           System.out.println("your choice is wronge ");
   }
   private boolean listCourses() {
       ArrayList<Course>list=doctor.getListOfCourses();
       if(list.size()!=0){
          for(Course course:list) {
           System.out.println("course "+course.getCourName()+"  code "+course.getCourCode());
          }
          return true;
       }
       else {
           System.out.println("you have not courses .");
           return false;
       }
   }
   private boolean listAssignments(Course course) {
       ArrayList<Assignment>list=course.getListOfAssignment();
       if(list.size()>0) {
           for(Assignment a : list) {
               System.out.println("assignment number "+a.getNum());
           }
           return true;
       }
       return false;
   }
   private boolean listAssignmentSol(Assignment a) {
       ArrayList<AssignmentSolution>list=a.assignSoluList;
       if(list.size()>0){
           for(AssignmentSolution aa:list) {
               System.out.println("1->solution of "+aa.getStudName());
           }
           return true;
        }
       return false;
   }
   private void viewAssignmentSolution(Assignment as,Course course) {
     if(listAssignmentSol(as)){
           System.out.print("chose one to view : ");
           int val=in.nextInt();   in.nextLine();
           AssignmentSolution assignSol=as.getAssignSolut(val-1);
         while(true) {
           System.out.println("to show information enter 1:\n"+"to set grade enter 2:\n"+
                              "to set comment enter 3:\n"+"to back enter 4:");
           int valchose=in.nextInt();     in.nextLine();
           if(valchose==1) {
               System.out.print(assignSol.getStudName()+" ");
               if(assignSol.getGrade()>=0) {
                   System.out.println("grade is "+assignSol.getGrade()+"\ncontent is "+assignSol.getContent()+"\n"+
                                      "comment:" + assignSol.getComment());
                }
                else {
                    System.out.println("not checked\n"+"  content is  "+assignSol.getContent()+"\n"+
                                       "comment:" + assignSol.getComment());
                }
            }
            else if(valchose==2) {
                System.out.print("plese enter grade : ");
                assignSol.setGrad(in.nextFloat());    in.nextLine();
            }
            else if(valchose==3) {
                System.out.println("please enter comment :");
                assignSol.setComment(in.nextLine());
            }
            else if(valchose==4){
                viewAssignment(course);
            }
            else {
                 System.out.println("your choice is wronge try again.");
            }
         }
     }
     else {
         System.out.println("no assignment solution ");
     }
     
   }
   private void viewAssignment(Course course) {
     if(listAssignments(course)) {
         
           System.out.print("please enter assignment number from list : ");
           int num=in.nextInt();     in.nextLine();
           Assignment as=new Assignment();
           as=course.getAssgnment(num);
        while(true) {
           System.out.println("to show information enter 1 :\n"+"to show grades report enter 2 :\n"+
                              "to list solution enter 3 :\n"+"to view assignment solution enter 4 :\n"+
                              "to back enter 5 :");
           int numCheck=in.nextInt();        in.nextLine();
           if(numCheck==1) {
               System.out.println("assignment number "+as.getNum()+" grade "+as.getGrad()+
                      "\ncontent "+as.getContent());
           }
           else if(numCheck==2) {
               ArrayList<AssignmentSolution>list=as.getAssignSolutList();
               for(AssignmentSolution a:list) {
                   System.out.print(a.getStudName()+" ");
                   if(a.getGrade()>=0) {
                       System.out.println(a.getGrade());
                   }
                   else{
                       System.out.println("not checked");
                   }
               }
           }
           else if(numCheck==3) {
               listAssignmentSol(as);
           }
           else if(numCheck==4) {
               viewAssignmentSolution(as,course);
           }
           else if(numCheck==5) {
               viewCourses();
           }
           else {
               System.out.println("your choice is wronge ");
           }
         }
     }
       else 
           System.out.println("not found assignment ");      
   }
   private void viewCourses() {
     if(listCourses()) {
           System.out.print("please chose course to view : ");
          int valView=in.nextInt();       in.nextLine();
          Course course=doctor.getListOfCourses().get(valView-1);  //course that want to see
       while(true) {
          System.out.println("to list assignments enter 1:\n"+"to create Assignment enter 2 :\n"+
                             "to view assignment enter 3:\n"+"to back enter 4 :");
          int val=in.nextInt();       in.nextLine(); 
          if(val==1) {
             listAssignments(course);
          }
          else if(val==2) {
             Assignment as=new Assignment();
             System.out.print("plese enter assignment number : ");
             as.setNum(in.nextInt());   in.nextLine();
             System.out.print("plese enter assignment content : ");
             as.setContent(in.nextLine());
             System.out.print("plese enter assignment grade : ");
             as.setGrad(in.nextFloat());   in.nextLine();
             course.addAssignment(as);
          }
          else if(val==3) {
                  viewAssignment(course);
          }
          else if(val==4) {
             docMainList();
             break;
          }
          else
             System.out.println("your choice is wronge ");
       }
    }
   }
   public  ArrayList<Course> getDoctorsCourses() {
       ArrayList <Course> list=new ArrayList<Course>();
       for(Doctor d:doctorList) {
          ArrayList<Course>listc=d.getListOfCourses();
          for(Course c:listc) {
             list.add(c);
          }
       }
       return list;
   }
}

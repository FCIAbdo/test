package EducatinManage;
import java.util.*;
public class StudentsManager {
     private ArrayList<Student>studentList;
     private Student student;
     private Scanner in;
     public StudentsManager()
     {
         studentList=new ArrayList<Student>();
         student=null;
         in=new Scanner(System.in);
     }
     public void logInAsStudent(int userName,int password) {
       boolean continueLoop=true;
       while(continueLoop==true){
           for(Student s:studentList) {
              if(s.getStudUserName()==userName&&s.getStudPassword()==password) {
                 student=s;
                 break;
              }
           }
       if(student==null) {
           System.out.println("userName or password is wrong try again ");
           continueLoop=true;
       }
       else {
           continueLoop=false;
       }
       }
       while(true)
          studCommon();
     }
     public void signUpAsStudent(Student student) {
       studentList.add(student);
       this.student=student;
       while(true)
          studCommon();
     }
     private void studCommon() {
         System.out.println("to register in course enter 1 : \n"+"to list your courses enter 2 : \n"+
                            "to view courses enter 3 : \n"+"to show grades report enter 4 : \n"+
                            " to log out enter 5 : \n"+"to showtdown enter 6 : ");
         int val=in.nextInt();     in.nextLine();
         if(val==1) {
             int countLine=1;
             DoctorsManager dm=new DoctorsManager();
             ArrayList<Course>allCour=dm.getDoctorsCourses();
             ArrayList<Course>allCourStudent=student.getCourses();
             for(Course c : allCour) {
                 for(Course cs:allCourStudent) {
                     if(c.getCourCode()==cs.getCourCode()) {
                        allCour.remove(c);
                        break;
                     }
                 }
             }
             if(allCour.size()>0) {
                for(Course cs : allCour) {
                   System.out.println(countLine+"->"+cs.getCourName()+"  "+cs.getCourCode()+"  "+cs.getDocName());
                   countLine++;
                }
                System.out.print("please enter line number to register choced course : ");
                allCour.get(in.nextInt()-1).registerInCourse(student.getStudId());
             }
             else
                 System.out.println("no exist courses to register ");
         }
         else if(val==2) {
             listMyCourses();
         }
         else if(val==3) {
             ArrayList<Assignment> list;
             if(listMyCourses()){
                System.out.print("please enter line number to view course choiced : ");
                Course course=student.getCourses().get(in.nextInt());  in.nextLine();
                list=course.getListOfAssignment();
                System.out.println(course.getCourName()+"  "+course.getCourCode()+"  "+course.getDocName());
                int studentId=student.getStudId();
                AssignmentSolution assignSol;
                for(Assignment assign:list) {
                    assignSol=assign.getAssignSolut(studentId);
                    if(assignSol!=null) {
                        if(assignSol.getGrade()>=0) {
                           System.out.println("Assignment solution is submited    grade "+assignSol.getGrade());
                        }
                        else {
                         System.out.println("Assignment solution is submitted but not corrected ");
                        }
                    }
                    else {
                        System.out.println("not submited ");
                    }
                }
                while(true) {
                    System.out.println("to sunmit assignment enter 1 : \n"+"to un register from course enter 2 : ");
                    int value=in.nextInt();        in.nextLine();
                    if(value==1) {
                        for(Assignment asign:list) {
                            System.out.println(asign.getNum());
                     }
                     System.out.print("please enter assignment number : ");
                     int assignNum=in.nextInt();         in.nextLine();
                     if(list.get(assignNum).checkStudExist(studentId)==false) {
                         System.out.println("please enter content : ");
                         String studNam[]=student.getStudFullName().split(" ");
                         list.get(assignNum).getAssignSolut(studentId).setContent(in.nextLine());
                         list.get(assignNum).getAssignSolut(studentId).setStudentId(studentId);
                         list.get(assignNum).getAssignSolut(studentId).setStudentName(studNam[0],studNam[1],studNam[2]);
                     }
                     else
                         System.out.println("you already submit assignment before ");
                     break;
                 }
                 else if(value==2) {
                     student.registeration(course);
                     break;
                 }
                 else {
                       System.out.println("wronge choice : ");
                 }
                 }
            }
            else
                 System.out.println("no courses registered to show ");
         }
         else if(val==4) {
             ArrayList<Course>courseList=student.getCourses();
             ArrayList<Assignment>list;
             for(Course c:courseList) {
                 System.out.println("course "+c.getCourName());
                 list=c.getListOfAssignment();
                 for(Assignment a : list) {
                     if(a.getAssignSolut(student.getStudId())!=null) {
                         if(a.getAssignSolut(student.getStudId()).getGrade()>=0)
                             System.out.println(a.getAssignSolut(student.getStudId()).getGrade());
                         else
                             System.out.println("not corrected ");
                     }
                     else {
                         System.out.println("not submitted ");
                     }
                 }
             }
         }
         else if(val==5) {
             SystemManager.start();
         }
         else if(val==6) {
             System.exit(0);
         }
     }
     private boolean listMyCourses() {
         int lineNum=1;
          ArrayList<Course>courseList=student.getCourses();
          if(courseList.size()!=0) {
              for(Course cs:courseList) {
                  System.out.println(lineNum+"->"+cs.getCourName()+" "+cs.getCourCode()+" "+cs.getDocName());
                  lineNum++;
              }
          return true;
          }
          return false;
     }
}
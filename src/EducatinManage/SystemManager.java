package EducatinManage;
import java.util.*;
public class SystemManager {
   private static DoctorsManager dm;
   private static StudentsManager sm;
   public SystemManager() {
      dm=new DoctorsManager();
      sm=new StudentsManager();
   }
   public static void start() {
      Scanner in=new Scanner(System.in);
       System.out.print("to sign in as doctor enter 1 :\nto sign up as doctor enter 2 :\n"
               + "to sign in as student enter 3 :\nto sign up as student enter 4 :"+
               "\nto shoutdown enter 5 : ");
       int check=in.nextInt();     in.nextLine();
       if(check==1) {
           System.out.print("please enter user name as integer number : ");
           while(!in.hasNextInt()) {
               System.out.print("please enter user name as integer number : ");
               in.next();
           }
           int userName=in.nextInt();      in.nextLine();
           System.out.print("please enter password as anteger number : ");
           while(!in.hasNextInt()) {
               System.out.print("please enter password as anteger number : ");
               in.next();
           }
           int pass=in.nextInt();       in.nextLine();
           dm.logInAsDoctor(userName,pass); 
       }
       else if(check==2) {
           Doctor doctor=new Doctor();
           System.out.print("please enter id as integer number : ");
           while(!in.hasNextInt()) {
                 System.out.print("please enter id as integer number : ");
                 in.next();
                }   
           doctor.setId(in.nextInt());      in.nextLine();
           System.out.print("please enter username as integer number : ");
           while(!in.hasNextInt()) {
               System.out.print("please enter username as integer number : ");
               in.next();
           }
           doctor.setUserName(in.nextInt());      in.nextLine();
           System.out.print("please enter password as integer number : ");
           while(!in.hasNextInt()) {
               System.out.print("please enter password as integer number : ");
               in.next();
           }
           doctor.setPassword(in.nextInt());       in.nextLine();
           System.out.print("please enter Email and end with @gmail.com : ");
           String email=in.nextLine();
           while(email.endsWith("@gmail.com")==false) {
                System.out.print("please enter Email and end with @gmail.com : ");
                email=in.nextLine();
           }
           doctor.setEmail(email);
           System.out.print("please enter first name and midle name and last name :");
           doctor.setFullName(in.next(),in.next(),in.next());   in.nextLine();
           dm.signUpAsDoctor(doctor);
       }
       else if(check==3) {
           System.out.print("please enter user name as integer number : ");
           while(!in.hasNextInt()) {
               System.out.print("please enter user name as integer number : ");
               in.next();
           }
           int userName=in.nextInt();    in.nextLine();
           System.out.print("please enter password as integer number : ");
           while(!in.hasNextInt()) {
               System.out.print("please enter password as integer number : ");
               in.next();
           }
           int password=in.nextInt();    in.nextLine();
           sm.logInAsStudent(userName,password);
       }
       else if(check==4) {
           Student student=new Student();
           System.out.print("please enter id as integer number : ");
           while(!in.hasNextInt()) {
                 System.out.print("please enter id as integer number : ");
                 in.next();
            }   
           student.setId(in.nextInt());      in.nextLine();
           System.out.print("please enter username as integer number : ");
           while(!in.hasNextInt()) {
               System.out.print("please enter username as integer number : ");
               in.next();
           }
           student.setUserName(in.nextInt());      in.nextLine();
           System.out.print("please enter password as integer number : ");
           while(!in.hasNextInt()) {
               System.out.print("please enter password as integer number : ");
               in.next();
           }
           student.setPassword(in.nextInt());       in.nextLine();
           System.out.print("please enter Email and end with @gmail.com : ");
           String email=in.nextLine();
           while(email.endsWith("@gmail.com")==false) {
                System.out.print("please enter Email and end with @gmail.com : ");
                email=in.nextLine();
           }
           student.setEmail(email);
           System.out.print("please enter first name and midle name and last name :");
           student.setFullName(in.next(),in.next(),in.next());   in.nextLine();
           sm.signUpAsStudent(student);
       }
       else if(check==5) {
           System.exit(0);
       }
       else {
           System.out.println("your choice is wrong try again with another choice : ");
           start();
       }
   }
   
}

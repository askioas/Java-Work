package Week3;

import java.util.ArrayList;

// Declaration of Student Class
class Student {
    int studentID;
    String studentName;
    Course studentCourse;
// Constructor of Student Class
public Student() {
    studentID = 106;
    studentName = "John Smith";
}
//Enrol Method
public void enrol(Course Computing) {
    studentCourse = Computing;
}
public void print() {
    System.out.println("Student's ID is: " + studentID);
    System.out.println("Student's Name is: " + studentName);
studentCourse.print();
}
}
// Declaration of Course Class
class Course {
    String courseCode;
    String courseName;
    public void print() {
        System.out.println("Course's Code is: " + courseCode);
        System.out.println("Course's Name is: " + courseName);
    }
    

// Constructor of Course Class
public Course(String coursecode, String coursename) {
    courseCode = coursecode;
    courseName = coursename;
}}

// Declaration of Module Class
class Module {
    String moduleCode;
    String moduleName;
// Constructor of Module Class
public Module(String modulecode, String modulename) {
    moduleCode = modulecode;
    moduleName = modulename;
}}
// Main Code
class Main {
public static void main(String[] args){
    Student student1 = new Student();
    Course course1 = new Course("A104", "Computing");
    student1.enrol(course1);
    student1.print();
    
}
}






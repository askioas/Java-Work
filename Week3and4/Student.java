package Week3and4;
import java.util.ArrayList;

// enum to convert mark to grade
enum markGrade {
    A, B, C, D, F
}

// Declaration of Student Class
class Student {
    int studentID;
    String studentName;
    Course studentCourse;
// Integer Array 
    int[] studentMark;
// Constructor of Student Class
public Student(int studentID, String studentName) {
    this.studentID = studentID;
    this.studentName = studentName;
    // While loop to randomise marks in an integer array
    int studentMarkRandomiser = 0;
    studentMark = new int[5];
    while (studentMarkRandomiser != 5) {
        studentMark [studentMarkRandomiser] = (int)(Math.random() * 101);
        studentMarkRandomiser++;
    }
}

//Enrol Method
public void enrol(Course Computing) {
    studentCourse = Computing;
}
public void print() {
    System.out.println("Student's ID is: " + studentID);
    System.out.println("Student's Name is: " + studentName);
    studentCourse.print();

// declaring int to be used in while loop
int MarkModuleMatch = 0;    
// while loop to handle matching marks to module. Cleaned code to contain both module's code and name alongside the relevant mark.
while (MarkModuleMatch != 5) {
    Module module = studentCourse.courseModule.get(MarkModuleMatch);
    int mark = studentMark[MarkModuleMatch];
    System.out.println(studentCourse.courseModule.get(MarkModuleMatch).moduleCode + " - " + studentCourse.courseModule.get(MarkModuleMatch).moduleName + " | Mark: " + studentMark[MarkModuleMatch] + " | Grade: " + module.markLetterGradeConvert(mark));
    MarkModuleMatch++;
}
}
}

// Declaration of Course Class
class Course {
    String courseCode;
    String courseName;
    ArrayList<Module> courseModule;
    public void print() {
        System.out.println("Course's Code is: " + courseCode);
        System.out.println("Course's Name is: " + courseName);
        }

// Constructor of Course Class
public Course(String coursecode, String coursename) {
    courseCode = coursecode;
    courseName = coursename;
// Module Array
    courseModule = new ArrayList<Module>();
    courseModule.add(new Module("M101", "Coding Fundamentals"));
    courseModule.add(new Module("M102", "Databases"));
    courseModule.add(new Module("M103", "Coding Preplanning"));
    courseModule.add(new Module("M104", "Networking"));
    courseModule.add(new Module("M105", "Object Oriented Programming"));
}}

// Declaration of Module Class
class Module {
    String moduleCode;
    String moduleName;

// Constructor of Module Class
public Module(String modulecode, String modulename) {
    moduleCode = modulecode;
    moduleName = modulename;
}

// Method to convert mark to letter grade reusing code from PercentageToUndergraduate
public markGrade markLetterGradeConvert(int studentMark) {
    if (studentMark >= 70){return markGrade.A;}
    else if (studentMark >= 60){return markGrade.B;}
    else if (studentMark >= 50){return markGrade.C;}
    else if (studentMark >= 40){return markGrade.D;}
    else {return markGrade.F;}
}
public void print() {
    System.out.println("Module's Code is: " + moduleCode);
    System.out.println("Module's Name is: " + moduleName);
}}
// Main Code
class Main {
public static void main(String[] args){
    Student student1 = new Student(106, "John Smith");
    Course course1 = new Course("A104", "Computing");
    student1.enrol(course1);
    student1.print();    
}
}






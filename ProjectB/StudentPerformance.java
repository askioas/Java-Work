package ProjectB;
import java.util.ArrayList;
import java.util.Scanner;

// Declaration of Student Class
class Student {
    private int studentID;
    private String studentFirstName;
    private String studentLastName;
    private int studentYear;
// Constructor of Student Class
public Student(int studentID, String studentFirstName, String studentLastName, int studentYear){
    this.studentID = studentID;
    this.studentFirstName = studentFirstName;
    this.studentLastName = studentLastName;
    this.studentYear = studentYear;
}
// Getters of Student Class
public int getStudentID() {return studentID;}
public String getStudentFirstName() {return studentFirstName;}
public String getStudentLastName() {return studentLastName;}
public int getStudentYear() {return studentYear;}
// Setters of Student Class
public void setStudentID(int studentID) {this.studentID = studentID;}
public void setStudentFirstName(String studentFirstName) {this.studentFirstName = studentFirstName;}
public void setStudentLastName(String studentLastName) {this.studentLastName = studentLastName;}
public void setStudentYear(int studentYear) {this.studentYear = studentYear;}
// Storing string format using toString
public String toString() {
    return "Student ID: " + studentID + " | Student Name: " + studentFirstName + " " + studentLastName + " | Year: " + studentYear;
    }
}

// Declaration of Module Class
class Module {
    private String moduleCode;
    private String moduleName;
    private int moduleYear;
// Constructor of Module Class
public Module(String moduleCode, String moduleName, int moduleYear){
    this.moduleCode = moduleCode;
    this.moduleName = moduleName;
    this.moduleYear = moduleYear;
    }
// Getter of Module Class
public String getModuleCode() {return moduleCode;}
public String getModuleName() {return moduleName;}
public int getModuleYear() {return moduleYear;}
// Setter of Module Class
public void setModuleCode(String moduleCode) {this.moduleCode = moduleCode;}
public void setModuleName(String moduleName) {this.moduleName = moduleName;}
public void setModuleYear(int moduleYear) {this.moduleYear = moduleYear;}
// Storing string format using toString
public String toString() {
    return "Module Code: " + moduleCode + " | Module Name: " + moduleName + " | Module Year: " + moduleYear;
    }    
}

// Declaration of Mark Class
class Mark {
    private Student markStudent;
    private Module markModule;
    private int markValue;
// Constructor of Mark Class
public Mark (Student markStudent, Module markModule, int markValue){
    this.markStudent = markStudent;
    this.markModule = markModule;
    this.markValue = markValue;}
// Getter of Mark Class
public Student getMarkStudent() {return markStudent;}
public Module getMarkModule() {return markModule;}
public int getMarkValue() {return markValue;}
// Setter of Mark Class
public void setMarkStudent(Student markStudent) {this.markStudent = markStudent;}
public void setMarkModule(Module markModule) {this.markModule = markModule;}
public void setMarkValue(int markValue) {this.markValue = markValue;}
// CalculateGrade Method to convert mark number to Uni Classification. Reused code from Week3&4 task
public Grade calculateGrade() {
    if (markValue >= 70){return Grade.A;}
    else if (markValue >= 60){return Grade.B;}
    else if (markValue >= 50){return Grade.C;}
    else if (markValue >= 40){return Grade.D;}
    else {return Grade.F;}
    }
// Storing string format using toString
public String toString() {
    return markStudent.toString() + " | " + markModule.toString() + " | Mark: " + markValue + " | Letter Grade: " + calculateGrade() + " | Grade Classification: " + calculateGrade().getClassification(); 
}
}

// Declaration of Grade enum
enum Grade {
    A("First Class"),
    B("Upper Second Class"),
    C("Lower Second Class"),
    D("Third Class"),
    F("Fail");
// variable to hold Classification String
private String classification;
// Constructor to combine cooperating grades and classifications
Grade(String classification){
    this.classification = classification;}
// Getter to read only the Classification
public String getClassification() {return classification;
    }
}

// Declaration of StudentManager
class StudentManager {
    private ArrayList<Student> studentList;
    // Counter to handle StudentID generation
    private int studentManagerIDCount = 1;
// Constructor of StudentManager
public StudentManager() {
    studentList = new ArrayList<Student>();}
// AddStudent method to add new student entries
public void addStudent(Scanner userInput) {
    System.out.println();
    System.out.print("Input Student's First Name: ");
    // Usage of .trim to sanatise user input
    String addStudentFirstName = userInput.nextLine().trim();
    System.out.println("Input Student's Last Name: ");
    String addStudentLastName = userInput.nextLine().trim();
    System.out.println("Input Student's Year (0-9999): ");
    String addStudentYearTryCatch = userInput.nextLine();
    // Usage of Try-Catch statement to prevent errors
    try {
        int addStudentYear = Integer.parseInt(addStudentYearTryCatch);
        studentList.add(new Student(studentManagerIDCount, addStudentFirstName, addStudentLastName, addStudentYear));
        System.out.println("Student [ " + addStudentFirstName + " " + addStudentLastName + " ] has been added.");
        studentManagerIDCount++;}
    catch (NumberFormatException e) {System.out.println("Invalid input. Please keep your input in a integer format (0-9999)");}
    // findStudent Method to search for student via ID
} 
// RemoveStudent Method to remove student entries
public void removeStudent(Scanner userInput) {
    System.out.println();
    System.out.print("Input Student's ID to remove (0-9999): ");
    String removeStudentIDTryCatch = userInput.nextLine().replace(" ", "").replace(",", "").replace(".", "");
// Try-Catch Statement to prevent error
    try {
        int removeStudentID = Integer.parseInt(removeStudentIDTryCatch);
        // Searching for Student
        int removeStudentCount = 0;
        while (removeStudentCount < studentList.size()) {
            if (studentList.get(removeStudentCount).getStudentID() == (removeStudentID)) {
                // Confirmation if statement including student name to prevent accidental removal
                System.out.print("Are you sure you want to remove " + studentList.get(removeStudentCount).getStudentFirstName() + " " + studentList.get(removeStudentCount).getStudentLastName() +"? (This action cannot be undone) (Y/N): ");
                String removeStudentUserConfirm = userInput.nextLine();
                if (removeStudentUserConfirm.equalsIgnoreCase("Y")) {
                    // Removing Student
                    System.out.println("Student [ " + studentList.get(removeStudentCount).getStudentFirstName() + " " + studentList.get(removeStudentCount).getStudentLastName() + " ] has been removed.");
                    studentList.remove(removeStudentCount);
                    return;
                }
                else {
                    System.out.println("Student Removal Cancelled.");
                    return;
                }
            }
            removeStudentCount++;
        }
    System.out.println("Student ID not found.");
    }
    catch (NumberFormatException e){
        System.out.println("Please input a valid integer (0-9999)");
    }
}
// editStudent Method
public void editStudent(Scanner userInput){
    System.out.println();
    System.out.print("Input the ID of the student to edit: ");
    // usage of Try-Catch alongside both .trim and .replace to clean input
    String editStudentIDTryCatch = userInput.nextLine().replace(" ","").replace(",", "").replace(".", "");
    try {
        int editStudentID = Integer.parseInt(editStudentIDTryCatch);
        int editStudentCount = 0;
        // Loop to search through studentList
        while (editStudentCount < studentList.size()) {
            if (studentList.get(editStudentCount).getStudentID() == (editStudentID)) {
                // Menu to choose what attribute to edit
                System.out.println();
                System.out.println("Select what attribute to edit");
                System.out.println("------------------------------");
                System.out.println("1. First Name");
                System.out.println("2. Last Name");
                System.out.println("3. Year");
                System.out.println("------------------------------");
                System.out.print("Input what to edit (1, 2, 3): ");
                String editStudentAttributeMenuTryCatch = userInput.nextLine();
                try {
                    int editStudentAttributeMenu = Integer.parseInt(editStudentAttributeMenuTryCatch);
                    if (editStudentAttributeMenu == 1) {
                        System.out.println();
                        System.out.print("Input new First Name: ");
                        String editStudentNewFirstName = userInput.nextLine().trim();
                        studentList.get(editStudentCount).setStudentFirstName(editStudentNewFirstName);
                        System.out.println("First Name updated successfully.");
                        return;
                    }
                    else if (editStudentAttributeMenu == 2) {
                        System.out.println();
                        System.out.print("Input new Last Name: ");
                        String editStudentNewLastName = userInput.nextLine().trim();
                        studentList.get(editStudentCount).setStudentLastName(editStudentNewLastName);
                        System.out.println("Last Name updated successfully.");
                        return;
                    }
                    else if (editStudentAttributeMenu == 3) {
                        System.out.println();
                        System.out.print("Input new Year: ");
                        String editStudentNewYearTryCatch = userInput.nextLine().replace(",", "").replace(".","").replace(" ","");
                        try {
                            int editStudentNewYear = Integer.parseInt(editStudentNewYearTryCatch);
                            studentList.get(editStudentCount).setStudentYear(editStudentNewYear);
                            System.out.println("Year updated successfully.");
                            return;
                        }
                        catch (NumberFormatException e){
                            System.out.println("Invalid Input. Please input an Integer (0-9999)");
                            return;
                        }
                    }
                    else {
                        System.out.println("Invalid Input. Please input an Integer between the range. (1, 2, 3)");
                        return;
                    }
                }
                catch (NumberFormatException e){
                    System.out.println("Invalid Input. Please input an Integer between the range. (1, 2, 3)");
                    return;
                }
            }
            editStudentCount++;
        }
        System.out.println("Cannot find Student ID in the Student List.");
    }
    catch (NumberFormatException e){
        System.out.println("Invalid Input. Please input an Integer between the range. (0-9999)");
        return;
    }
}
// displayStudent Method
public void displayStudent() {
    System.out.println();
    // Checks if list is empty first
    if (studentList.size() == 0) {
        System.out.println("No students in list.");
        return;
    }
    // Loop to display each entry
    int displayStudentCount = 0;
    while (displayStudentCount < studentList.size()) {
        Student student = studentList.get(displayStudentCount);
        System.out.println(student.toString());
        displayStudentCount++;
    }
}
// findStudent Method to search for a student via ID
public Student findStudent(int studentID) {
    int findStudentCount = 0;
    while (findStudentCount < studentList.size()) {
        if (studentList.get(findStudentCount).getStudentID() == studentID) {
            return studentList.get(findStudentCount);
        }
        findStudentCount++;
    }
    return null;
}
}

// Declaration of ModuleManager Class
class ModuleManager {
    private ArrayList<Module> moduleList;
// Constructor of ModuleManager
public ModuleManager() {
    moduleList = new ArrayList<Module>();}
// addModule Method
public void addModule(Scanner userInput) {
    System.out.println();
    System.out.print("Input Module Code: ");
    String addModuleCode = userInput.nextLine().trim().replace(",","").replace(".","").replace(" ","");
    System.out.println();
    System.out.print("Input Module Name: ");
    String addModuleName = userInput.nextLine().trim();
    System.out.println();
    System.out.print("Input Module Year: ");
    String addModuleYearTryCatch = userInput.nextLine().trim().replace(",","").replace(".","").replace(" ","");
    // Try-Catch to prevent error
    try {
        int addModuleYear = Integer.parseInt(addModuleYearTryCatch);
        moduleList.add(new Module(addModuleCode, addModuleName, addModuleYear));
        System.out.println("Module [ " + addModuleName + " ] has been added.");
        return;
    }
    catch (NumberFormatException e) {
        System.out.println("Invalid Input. Please input an integer (0-9999): ");
        return;
    }
}
// removeModule Method
public void removeModule(Scanner userInput) {
    System.out.println();
    System.out.print("Input Module's code to remove (M000-M999): ");
    String removeModuleCode = userInput.nextLine().trim().replace(" ", "").replace(",", "").replace(".", "");
        // Searching for Module
        int removeModuleCount = 0;
        while (removeModuleCount < moduleList.size()) {
            if (moduleList.get(removeModuleCount).getModuleCode().equals(removeModuleCode)) {
                // Confirmation if statement including student name to prevent accidental removal
                System.out.print("Are you sure you want to remove " + moduleList.get(removeModuleCount).getModuleName() +"? (This action cannot be undone) (Y/N): ");
                String removeModuleUserConfirm = userInput.nextLine();
                if (removeModuleUserConfirm.equalsIgnoreCase("Y")) {
                    // Removing Module
                    System.out.println("Module [ " + moduleList.get(removeModuleCount).getModuleName() + " ] has been removed.");
                    moduleList.remove(removeModuleCount);
                    return;
                }
                else {
                    System.out.println("Module Removal Cancelled.");
                    return;
                }
            }
            removeModuleCount++;
        }
    System.out.println("Module Code not found.");
    }
// editModule Method
public void editModule(Scanner userInput){
    System.out.println();
    System.out.print("Input the Code of the Module to edit (M000-M999): ");
    String editModuleCode = userInput.nextLine().replace(" ","").replace(",", "").replace(".", "");
    int editModuleCount = 0;
    // Loop to search through moduleList
        while (editModuleCount < moduleList.size()) {
            if (moduleList.get(editModuleCount).getModuleCode().equals(editModuleCode)) {
                // Menu to choose what attribute to edit
                System.out.println();
                System.out.println("Select what attribute to edit");
                System.out.println("------------------------------");
                System.out.println("1. Module Name");
                System.out.println("2. Year.");
                System.out.println("------------------------------");
                System.out.print("Input what to edit (1, 2): ");
                String editModuleAttributeMenuTryCatch = userInput.nextLine();
                try {
                    int editModuleAttributeMenu = Integer.parseInt(editModuleAttributeMenuTryCatch);
                    if (editModuleAttributeMenu == 1) {
                        System.out.println();
                        System.out.print("Input new Name: ");
                        String editModuleNewName = userInput.nextLine().trim();
                        moduleList.get(editModuleCount).setModuleName(editModuleNewName);
                        System.out.println("Name updated successfully.");
                        return;
                    }
                    else if (editModuleAttributeMenu == 2) {
                        System.out.println();
                        System.out.print("Input new Year: ");
                        String editModuleNewYearTryCatch = userInput.nextLine().replace(",", "").replace(".","").replace(" ","");
                        try {
                            int editModuleNewYear = Integer.parseInt(editModuleNewYearTryCatch);
                            moduleList.get(editModuleCount).setModuleYear(editModuleNewYear);
                            System.out.println("Year updated successfully.");
                            return;
                        }
                        catch (NumberFormatException e){
                            System.out.println("Invalid Input. Please input an Integer (0-9999)");
                            return;
                        }
                    }
                    else {
                        System.out.println("Invalid Input. Please input an Integer between the range. (1, 2)");
                        return;
                    }
                }
                catch (NumberFormatException e){
                    System.out.println("Invalid Input. Please input an Integer between the range. (1, 2)");
                    return;
                }
            }
            editModuleCount++;
        }
        System.out.println("Cannot find Module Code in the Module List.");
    }
// displayModule Method
public void displayModule(){

    System.out.println();
    // Checks if list is empty first
    if (moduleList.size() == 0) {
        System.out.println("No Modules in list.");
        return;
    }
    // Loop to display each entry
    int displayModuleCount = 0;
    while (displayModuleCount < moduleList.size()) {
        Module module = moduleList.get(displayModuleCount);
        System.out.println(module.toString());
        displayModuleCount++;
    }
}
// findModule Method to find Modules using ModuleCode
public Module findModule(String moduleCode) {
    int findModuleCount = 0;
    while (findModuleCount < moduleList.size()) {
        if (moduleList.get(findModuleCount).getModuleCode().equals(moduleCode)) {
            return moduleList.get(findModuleCount);
        }
        findModuleCount++;
    }
    return null;
}
}

// Declaration of markManager Class
class MarkManager {
    private ArrayList<Mark> markList;
    private StudentManager studentManager;
    private ModuleManager moduleManager;
// Constructor of markManager Class
public MarkManager(StudentManager studentManager, ModuleManager moduleManager) {
    markList = new ArrayList<Mark>();
    this.studentManager = studentManager;
    this.moduleManager = moduleManager;
    }
// addMark Method
public void addMark(Scanner userInput){
    System.out.println("Input Student ID (0-999): ");
        String addMarkStudentIDTryCatch = userInput.nextLine();
        try {
            int addMarkStudentID = Integer.parseInt(addMarkStudentIDTryCatch);
            // Finding Student
            Student addMarkStudent = studentManager.findStudent(addMarkStudentID);
            if (addMarkStudent == null) {
                System.out.println("Student ID not found.");
                return;
            }
            System.out.print("Input Module Code: ");
            String addMarkModuleCode = userInput.nextLine().trim().toUpperCase();
            // Finding Module
            Module addMarkModule = moduleManager.findModule(addMarkModuleCode);
            if (addMarkModule == null) {
                System.out.println("Module Code not Found.");
                return;
            }
            // Adding Mark
            System.out.print("Input Mark (0-100): ");
            String addMarkValueTryCatch = userInput.nextLine().trim();
            try {
                int addMarkValue = Integer.parseInt(addMarkValueTryCatch);
                if (addMarkValue < 0 || addMarkValue > 100){
                    System.out.println("Invalid Input. Please enter an integer in this range (0-100).");
                    return;
                }
                markList.add(new Mark(addMarkStudent, addMarkModule, addMarkValue));
                System.out.println("Mark [ " + addMarkValue + " ] added for " + addMarkStudent.getStudentFirstName() + " " + addMarkStudent.getStudentLastName() + " in " + addMarkModule.getModuleName() + ".");
            }
            catch (NumberFormatException e) {
                System.out.println("Invalid input. Please input an integer.");
            }
        }
        catch (NumberFormatException e) {
            System.out.println("Invalid input. Please input an integer (0-999).");
        }
}
// removeMark Method
public void removeMark(Scanner userInput){
    // Obtaining Student ID
       System.out.println();
       System.out.print("Input Student ID: ");
       String removeMarkStudentIDTryCatch = userInput.nextLine().trim();
       try {
        int removeMarkStudentID = Integer.parseInt(removeMarkStudentIDTryCatch);
        // Obtaining Module Code
        System.out.print("Input Module Code: ");
        String removeMarkModuleCode = userInput.nextLine().trim().toUpperCase();
        // While loop to search through markList
        int removeMarkCount = 0;
        while (removeMarkCount < markList.size()) {
            if (markList.get(removeMarkCount).getMarkStudent().getStudentID() == removeMarkStudentID && markList.get(removeMarkCount).getMarkModule().getModuleCode().equals(removeMarkModuleCode)) {
                // Confirmation
                System.out.print("Are you sure you want to remove this mark? (This cannot be undone!): ");
                String removeMarkConfirm = userInput.nextLine();
                if (removeMarkConfirm.equalsIgnoreCase("Y")) {
                    System.out.println("Mark removed successfully.");
                    markList.remove(removeMarkCount);
                    return;
                }
                else {
                    System.out.println("Mark Removal Cancelled.");
                    return;
                }
            }
            removeMarkCount++;
       }
       System.out.println("Mark not Found.");
    }
    catch (NumberFormatException e){
        System.out.println("Invalid input. Please input an integer (0-9999).");
    }
}
// EditMark
public void editMark(Scanner userInput) {
    System.out.println();
       System.out.print("Input Student ID: ");
       String editMarkStudentIDTryCatch = userInput.nextLine().trim();
       try {
        int editMarkStudentID = Integer.parseInt(editMarkStudentIDTryCatch);
        // Obtaining Module Code
        System.out.print("Input Module Code: ");
        String editMarkModuleCode = userInput.nextLine().trim().toUpperCase();
        
        // Searching for Mark
        int editMarkCount = 0;
        while (editMarkCount < markList.size()) {
        if (markList.get(editMarkCount).getMarkStudent().getStudentID() == editMarkStudentID && markList.get(editMarkCount).getMarkModule().getModuleCode().equals(editMarkModuleCode)) {
            System.out.print("Input new Mark (0-100): ");
            String editMarkValueTryCatch = userInput.nextLine().trim();
            try {
                int editMarkValue = Integer.parseInt(editMarkValueTryCatch);
                if (editMarkValue < 0 || editMarkValue > 100) {
                    System.out.println("Invalid Input. Please insert an integer in this range (0-100).");
                    return;
                }
                markList.get(editMarkCount).setMarkValue(editMarkValue);
                System.out.println("Mark updated successfully.");
                return;
            }
            catch (NumberFormatException e) {
                System.out.println("Invalid Input. Please input an integer (0-100).");
                return;
            }
        }
        editMarkCount++;
        }
        System.out.println("Mark not found.");
        }
        catch (NumberFormatException e) {
            System.out.println("Invalid Input. Please input an integer (0-9999)");
        }
    }
// displayMark Method
public void displayMark(){
    System.out.println();
    // Checks if list is empty first
    if (markList.size() == 0) {
        System.out.println("No marks in list.");
        return;
    }
    // Loop to display each entry
    int displayMarkCount = 0;
    while (displayMarkCount < markList.size()) {
        Mark mark = markList.get(displayMarkCount);
        System.out.println(mark.toString());
        displayMarkCount++;
    }
}
// getMean Method
public void getMean(Scanner userInput) {
    System.out.print("Input Module Code: ");
    String getMeanModuleCode = userInput.nextLine().trim().toUpperCase();
    // Counter Variables
    int getMeanMarkSum = 0; // running total of marks found
    int getMeanMarkCount = 0; // tracks marks found for module
    int getMeanCount = 0;
    while (getMeanCount < markList.size()) {
        if (markList.get(getMeanCount).getMarkModule().getModuleCode().equals(getMeanModuleCode)) {
            getMeanMarkSum = getMeanMarkSum + markList.get(getMeanCount).getMarkValue();
            getMeanMarkCount++;
        }
    getMeanCount++;
    }
    if (getMeanMarkCount == 0) {
        System.out.println("No marks found.");
        return;
    }

    // Mean Calculation. (double) forces decimal division
    double meanCalculation = (double) getMeanMarkSum / getMeanMarkCount;
    System.out.println("the Mean for marks in " + getMeanModuleCode + " is: " + meanCalculation + ".");
}
// getMin Method
public void getMin(Scanner userInput) {
    System.out.print("Input Module Code: ");
    String getMinModuleCode = userInput.nextLine().trim().toUpperCase();
    // Counting variables
    int getMinMark = 101; // Higher than mark range
    int getMinMarkCount = 0; // Tracks total marks found
    int getMinCount = 0;

    while (getMinCount < markList.size()) {
        if (markList.get(getMinCount).getMarkModule().getModuleCode().equals(getMinModuleCode)) {
            // If Statement that updates getMinMark with the lower number
            if (markList.get(getMinCount).getMarkValue() < getMinMark) {
                getMinMark = markList.get(getMinCount).getMarkValue();
            }
            getMinMarkCount++;
        }
        getMinCount++;
    }
    if (getMinMarkCount == 0) {
        System.out.println("No marks found.");
        return;
    }
    System.out.println("The Minimum mark for " + getMinModuleCode + ": " + getMinMark);
}
// getMax Method
public void getMax(Scanner userInput) {
    System.out.print("Input Module Code: ");
    String getMaxModuleCode = userInput.nextLine().trim().toUpperCase();
    // Counting variables
    int getMaxMark = -1; // Higher than mark range
    int getMaxMarkCount = 0; // Tracks total marks found
    int getMaxCount = 0;

    while (getMaxCount < markList.size()) {
        if (markList.get(getMaxCount).getMarkModule().getModuleCode().equals(getMaxModuleCode)) {
            // If Statement that updates getMaxMark with the higher number
            if (markList.get(getMaxCount).getMarkValue() > getMaxMark) {
                getMaxMark = markList.get(getMaxCount).getMarkValue();
            }
            getMaxMarkCount++;
        }
        getMaxCount++;
    }
    if (getMaxMarkCount == 0) {
        System.out.println("No marks found.");
        return;
    }
    System.out.println("The Maximum mark for " + getMaxModuleCode + ": " + getMaxMark);
}
// gradeProfile Method
public void gradeProfile(Scanner userInput) {
    System.out.print("Input Module Code: ");
    String gradeProfileModuleCode = userInput.nextLine().trim().toUpperCase();
    // Counter Variables to track marks in each grade
    int gradeProfileACount = 0;
    int gradeProfileBCount = 0;
    int gradeProfileCCount = 0;
    int gradeProfileDCount = 0;
    int gradeProfileFCount = 0;
    int gradeProfileTotalCount = 0;
    int gradeProfileCount = 0;
    while (gradeProfileCount < markList.size()) {
        if (markList.get(gradeProfileCount).getMarkModule().getModuleCode().equals(gradeProfileModuleCode)) {
                Grade grade = markList.get(gradeProfileCount).calculateGrade();
                if (grade == Grade.A) {gradeProfileACount++;}
                else if (grade == Grade.B) {gradeProfileBCount++;}
                else if (grade == Grade.C) {gradeProfileCCount++;}
                else if (grade == Grade.D) {gradeProfileDCount++;}
                else if (grade == Grade.F) {gradeProfileFCount++;}
                gradeProfileTotalCount++;
            }
            gradeProfileCount++;
        }
        if (gradeProfileTotalCount != 0) {
            System.out.println("Grade A - " + Grade.A.getClassification() + ": " + ((double) gradeProfileACount / gradeProfileTotalCount * 100) + "%.");
            System.out.println("Grade B - " + Grade.B.getClassification() + ": " + ((double) gradeProfileBCount / gradeProfileTotalCount * 100) + "%.");
            System.out.println("Grade C - " + Grade.C.getClassification() + ": " + ((double) gradeProfileCCount / gradeProfileTotalCount * 100) + "%.");
            System.out.println("Grade D - " + Grade.D.getClassification() + ": " + ((double) gradeProfileDCount / gradeProfileTotalCount * 100) + "%.");
            System.out.println("Grade F - " + Grade.F.getClassification() + ": " + ((double) gradeProfileFCount / gradeProfileTotalCount * 100) + "%.");
        }
        else {System.out.println("No marks found.");}
}
}


// Declaring Menu Class
class Menu {
    private StudentManager studentManager;
    private ModuleManager moduleManager;
    private MarkManager markManager;
    private Scanner userInput;
// Constructor of Menu Class
public Menu() {
    studentManager = new StudentManager();
    moduleManager = new ModuleManager();
    markManager = new MarkManager(studentManager, moduleManager);
    userInput = new Scanner(System.in);
}
// run Method
public void run() {
    boolean active = true;
    while (active == true) {
        System.out.println();
        System.out.println("Student Performance Manager");
        System.out.println("---------------------------");
        System.out.println("1. Student Menu");
        System.out.println("2. Module Menu");
        System.out.println("3. Mark Menu");
        System.out.println("4. Exit");
        System.out.println("---------------------------");
        System.out.print("Input Menu Choice (1,2,3): ");
        String menuChoice = userInput.nextLine().trim();
        if (menuChoice.equals("1")) {studentMenu();}
        else if (menuChoice.equals("2")) {moduleMenu();}
        else if (menuChoice.equals("3")) {markMenu();}
        else if (menuChoice.equals("4")) {
            active = false;
            System.out.println(" Thanks for using the Student Performance Manager.");
        }
        else {System.out.println("Invalid input. Choose an integer from the range (1, 2, 3, 4).");}
    }
}
// studentMenu Method
public void studentMenu() {
    boolean active = true;
    while (active == true) {
         System.out.println();
        System.out.println("Student Menu");
        System.out.println("---------------------------");
        System.out.println("1. Add Student");
        System.out.println("2. Remove Student");
        System.out.println("3. Edit Student");
        System.out.println("4. Display Students");
        System.out.println("5. Return");
        System.out.println("---------------------------");
        System.out.print("Input Menu Choice (1,2,3): ");
        String menuChoice = userInput.nextLine().trim();
        if (menuChoice.equals("1")) {studentManager.addStudent(userInput);}
        else if (menuChoice.equals("2")) {studentManager.removeStudent(userInput);}
        else if (menuChoice.equals("3")) {studentManager.editStudent(userInput);}
        else if (menuChoice.equals("4")) {studentManager.displayStudent();}
        else if (menuChoice.equals("5")) {
            active = false;
        System.out.println("Returning... "); }
        else {System.out.println("Invalid input. Choose an integer from the range (1, 2, 3, 4, 5).");}
    }
}
// moduleMenu Method
public void moduleMenu() {
    boolean active = true;
    while (active == true) {
         System.out.println();
        System.out.println("Module Menu");
        System.out.println("---------------------------");
        System.out.println("1. Add Module");
        System.out.println("2. Remove Module");
        System.out.println("3. Edit Module");
        System.out.println("4. Display Modules");
        System.out.println("5. Return");
        System.out.println("---------------------------");
        System.out.print("Input Menu Choice (1,2,3): ");
        String menuChoice = userInput.nextLine().trim();
        if (menuChoice.equals("1")) {moduleManager.addModule(userInput);}
        else if (menuChoice.equals("2")) {moduleManager.removeModule(userInput);}
        else if (menuChoice.equals("3")) {moduleManager.editModule(userInput);}
        else if (menuChoice.equals("4")) {moduleManager.displayModule();}
        else if (menuChoice.equals("5")) {
            active = false;
        System.out.println("Returning... "); }
        else {System.out.println("Invalid input. Choose an integer from the range (1, 2, 3, 4, 5).");}
    }
}
// studentMenu Method
public void markMenu() {
    boolean active = true;
    while (active == true) {
         System.out.println();
        System.out.println("Mark Menu");
        System.out.println("---------------------------");
        System.out.println("1. Add Mark");
        System.out.println("2. Remove Mark");
        System.out.println("3. Edit Mark");
        System.out.println("4. Display Students");
        System.out.println("5. View Module Mean Mark");
        System.out.println("6. View Module Min Mark");
        System.out.println("7. View Module Max Mark");
        System.out.println("8. View Module Grade Profile");
        System.out.println("9. Return");
        System.out.println("---------------------------");
        System.out.print("Input Menu Choice (1,2,3): ");
        String menuChoice = userInput.nextLine().trim();
        if (menuChoice.equals("1")) {markManager.addMark(userInput);}
        else if (menuChoice.equals("2")) {markManager.removeMark(userInput);}
        else if (menuChoice.equals("3")) {markManager.editMark(userInput);}
        else if (menuChoice.equals("4")) {markManager.displayMark();}
        else if (menuChoice.equals("5")) {markManager.getMean(userInput);}
        else if (menuChoice.equals("6")) {markManager.getMin(userInput);}
        else if (menuChoice.equals("7")) {markManager.getMax(userInput);}
        else if (menuChoice.equals("8")) {markManager.gradeProfile(userInput);}
        else if (menuChoice.equals("9")) {
            active = false;
        System.out.println("Returning... "); }
        else {System.out.println("Invalid input. Choose an integer from the range (1, 2, 3, 4, 5, 6, 7, 8, 9).");
        }
    }
}
}

class Main {
    public static void main(String[] args) {
        Menu menu = new Menu();
        menu.run();
    }
}
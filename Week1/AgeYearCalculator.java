import java.util.Scanner;
public class AgeYearCalculator {
    public static void main(String[] args){
    // Scanner to recieve current year
    Scanner currentyear = new Scanner(System.in);
    System.out.print("Input current year: ");
    int CurrentYear = Integer.parseInt(currentyear.nextLine());
    // Scanner to recieve user's age
    Scanner userage = new Scanner(System.in);
    System.out.print("Input Age: ");
    int UserAge = Integer.parseInt(userage.nextLine());
    // Scanner to recieve if user had birthday this year
    Scanner birthdaycheck = new Scanner(System.in);
    System.out.print("Input 0 if it hasn't been your birthday. Input 1 if it has been your birthday.");
    int BirthdayCheck = Integer.parseInt(birthdaycheck.nextLine());
    // If statement handling maths depending on BirthdayCheck
    if (BirthdayCheck == 1) {
        System.out.print("The year you were born in was " + (CurrentYear - UserAge)); }
    else if (BirthdayCheck == 0) {
        System.out.print("The year you were born in was " + ((CurrentYear - 1) - UserAge));
    }
    else {
        System.out.print("Invalid Input. Please input either 0 or 1 for if it has been your birthday.");
    }
    // Closing Scanners
    currentyear.close();
    userage.close();
    birthdaycheck.close();
}
}

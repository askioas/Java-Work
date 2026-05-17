import java.util.Scanner;
public class DoBAgeCalculator {
    public static void main(String[] args){
        // Variables containing hardcoded date in 3 variables
        int currentDay = 18;
        int currentMonth = 5;
        int currentYear = 2026;

        // Scanner to obtain User's Day of Birth
        Scanner userInput = new Scanner(System.in);
        System.out.print("Input the day you were born (1-31): ");
        int UserDay = Integer.parseInt(userInput.nextLine());
        // Scanner to obtain User's Month of Birth
       System.out.print("Input the year you were born (1-12): ");
       int UserMonth = Integer.parseInt(userInput.nextLine());
        // Scanner to obtain User's Year of Birth
        System.out.print("Input the year you were born (0000-9999): ");
        int UserYear = Integer.parseInt(userInput.nextLine());

        // Age Calculation
        int age = currentYear - UserYear;
        if (UserMonth > currentMonth) {age--;}
        else if (UserMonth == currentMonth) {
            if (UserDay > currentDay) {age--;}
        }
        System.out.print("From 18/05/2026, you are: " + age + " years old.");

        // Closing Scanner
        userInput.close();
;
    }
}

package Week2;
import java.util.Scanner;
public class PercentageToUndergraduate {
    public static void main(String[] args){
        // Scanner to obtain user input
        Scanner userpercentage = new Scanner(System.in);
        System.out.print("Input your exam percentage (0-100): ");
        int UserPercentage = Integer.parseInt(userpercentage.nextLine());
        // If statement
        if (UserPercentage >= 70){System.out.println(UserPercentage + " = A/1st.");}
        else if (UserPercentage >= 60){System.out.println(UserPercentage + " = B/2:1.");}
        else if (UserPercentage >= 50){System.out.println(UserPercentage + " = B/2:2.");}
        else if (UserPercentage >= 40){System.out.println(UserPercentage + " = C/3rd.");}
        else if (UserPercentage < 40){System.out.println(UserPercentage + " = F/Fail.");}
        else {System.out.print("Invalid Input. Please insert an input from this range: (0-100)");}
    }   
}

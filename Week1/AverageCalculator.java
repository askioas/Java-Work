import java.util.Scanner;
public class AverageCalculator {
    public static void main(String[] args){
        // Scanner to recieve user input for 1st variable
        Scanner firstnumber = new Scanner(System.in);
        System.out.print("Input first number: ");
        float FirstNumber = Float.parseFloat(firstnumber.nextLine());
        // Scanner to recieve user input for 2nd variable
        Scanner secondnumber = new Scanner(System.in);
        System.out.print("Input second number: ");
        float SecondNumber = Float.parseFloat(secondnumber.nextLine());
        // Outputs the two variables and the results of the variables' average
        System.out.println("The average of "+FirstNumber+" and "+SecondNumber+" is "+((FirstNumber+SecondNumber)/2));
        // Closing scanners to prevent resource leaks
        firstnumber.close();
        secondnumber.close();
    }
}
import java.util.Scanner;
public class FeetToMilesCalculator {
    public static void main(String[] args){
        // Scanner recieves user input
        Scanner feetnumber = new Scanner(System.in);
        System.out.print("Input a number in feet (ft): ");
        float FeetNumber = Float.parseFloat(feetnumber.nextLine());
        // Conversion by dividing user input by 5280
        System.out.println(FeetNumber + "ft in miles is: " + (FeetNumber / 5280) + "mi");
        // Closing Scanner
        feetnumber.close();
    }
}

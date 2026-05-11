package Week2;
import java.util.Scanner;
public class MultiplyTable {
    public static void main(String[] args){
        // Creating variables
        boolean active = true;
        int Multiplicand = 1;
        Scanner multiplier = new Scanner(System.in);
        Scanner useractive = new Scanner(System.in);
        // Main while loop 
        while (active == true) {
            System.out.print("Input Multiplier: ");
            int Multiplier = Integer.parseInt(multiplier.nextLine());
            // Secondary while loop to display multiplication table
            while (Multiplicand != 13){
                System.out.println(Multiplicand + " * " + Multiplier + " = " + (Multiplicand * Multiplier));
                Multiplicand = Multiplicand + 1;
            }
            System.out.print("Do you wish to do another multiplication table (Y/N): ");
            String UserActive = useractive.nextLine();
            // If statement to contine while loop or not
            if (UserActive.equals("Y")){
                Multiplicand = 1;
            }
            else if (UserActive.equals("N")){
                System.out.print("Goodbye.");
                active = false;
            }
            else {System.out.println("Invalid Input. Restarting...");}
            Multiplicand = 1;
        }
        // Closing Scanners
        multiplier.close();
        useractive.close();
        }
    }

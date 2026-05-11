import java.util.Scanner;
public class InterestCalculator {
    public static void main(String[] args){
        // Scanner to obtain user's deposit amount
        Scanner userdeposit = new Scanner(System.in);
        System.out.print("Input deposit amount: ");
        int UserDeposit = Integer.parseInt(userdeposit.nextLine());
        // Doing 1% interest rate
        System.out.print("The deposit after 1% interest is: " + (UserDeposit + (UserDeposit / 100)));
        // Closing scanner
        userdeposit.close();
    }
}

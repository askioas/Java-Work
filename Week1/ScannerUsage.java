import java.util.Scanner;
public class ScannerUsage {
    public static void main(String[] args){
        // Scanner to obtain the user's name
        Scanner username = new Scanner(System.in);
        System.out.print("Input Name: ");
        String UserName = username.nextLine();
        // Outputs combining hardcoded string and the variable
        System.out.println("Hello "+ UserName +".");
        username.close();
    }
}


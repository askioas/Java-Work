import java.util.Scanner;
public class ScannerUsage {
    public static void main(String[] args){
        Scanner username = new Scanner(System.in);
        System.out.print("Input Name: ");
        String UserName = username.nextLine();
        System.out.println("Hello "+ UserName +".");
        username.close();
    }
}
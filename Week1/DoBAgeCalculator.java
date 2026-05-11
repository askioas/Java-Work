import java.util.Scanner;
public class DoBAgeCalculator {
    public static void main(String[] args){
        // Scanner to obtain User's Day of Birth
        Scanner userday = new Scanner(System.in);
        System.out.print("Input the day you were born (0-30): ");
        int UserDay = Integer.parseInt(userday.nextLine());
        // Scanner to obtain User's Month of Birth
       Scanner usermonth = new Scanner(System.in);
       System.out.print("Input the year you were born (0-12): ");
       int UserMonth = Integer.parseInt(usermonth.nextLine());
        // Scanner to obtain User's Year of Birth
        Scanner useryear = new Scanner(System.in);
        System.out.print("Input the year you were born (0000-9999): ");
        int UserYear = Integer.parseInt(useryear.nextLine());
        // 
        
        // Closing Scanners
        userday.close();
        usermonth.close();
        useryear.close();
    }
}

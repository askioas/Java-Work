import java.util.Scanner;
public class IntegerReverser {
    public static void main(String[] args){
     // Scanner to recieve first integer
     Scanner firstinteger = new Scanner(System.in);   
     System.out.print("Input first Integer: ");
     int FirstInteger = Integer.parseInt(firstinteger.nextLine());
     // Scanner to recieve second integer
     Scanner secondinteger = new Scanner(System.in);
     System.out.print("Input second Integer: ");
     int SecondInteger = Integer.parseInt(secondinteger.nextLine());
     // Outputs the Integer Normally then in reversed order
    System.out.println(FirstInteger + " and " + SecondInteger + " in reverse order is: " + SecondInteger + " " + FirstInteger);
    }
}
import java.util.Scanner;
public class IntegerReverser {
    public static void main(String[] args){
     // Scanner to recieve First integer
     Scanner firstinteger = new Scanner(System.in);   
     System.out.print("Input first Integer: ");
     int FirstInteger = Integer.parseInt(firstinteger.nextLine());
     // Scanner to recieve Second integer
     Scanner secondinteger = new Scanner(System.in);
     System.out.print("Input second Integer: ");
     int SecondInteger = Integer.parseInt(secondinteger.nextLine());
     // Outputs the Integer Normally then Reversed
    System.out.println(FirstInteger+" and "+SecondInteger+" reversed are "+IntegerReverser(FirstInteger))
    }
}

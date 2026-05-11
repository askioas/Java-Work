package Week2;
import java.util.Scanner;
public class LetterGradeToUnderGrad {
    public static void main(String[] args){
        // Obtaining user's input
        Scanner userletter = new Scanner(System.in);
        System.out.print("Input letter grade: ");
        String UserLetter = userletter.nextLine();
        // Converting via if statement
    if (UserLetter.equals("A")) {
        System.out.print("Grade A = 1st."); }
    else if (UserLetter.equals("B")) {
        System.out.print("Grade B = 2:1."); }
    else if (UserLetter.equals("C")) {
        System.out.print("Grade C = 2:2."); }
    else if (UserLetter.equals("D")) {
        System.out.print("Grade D = 3rd."); }
    else if (UserLetter.equals("E")) {
        System.out.print("Grade E = Ordinary."); }
    else if (UserLetter.equals("F")) {
        System.out.print("Grade F = Fail."); }
    else {System.out.print("Invalid Input. Insert an item from this list: (A, B, C, D, E, F)");}
    // Closing Scanner
    userletter.close();
        }
    }


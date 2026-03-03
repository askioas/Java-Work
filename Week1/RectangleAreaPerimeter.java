import java.util.Scanner;
public class RectangleAreaPerimeter {
    public static void main(String[] args){
        // Scanner and Int parsing for the rectangle's length
        Scanner rectanglelength = new Scanner(System.in);
        System.out.print("Input the Rectangle's Length: ");
        int RectangleLength = Integer.parseInt(rectanglelength.nextLine());
        // Scanner and Int parsing for the rectangle's width
        Scanner rectanglewidth = new Scanner(System.in);
        System.out.print("Input the Rectangle's Width: ");
        int RectangleWidth = Integer.parseInt(rectanglewidth.nextLine());
        // Outputting the results by combining hardcoded strings with variables combined with arithmetics
        System.out.println("The Rectangle's Area is: "+ (RectangleWidth * RectangleLength) + ".");
        System.out.println("The Rectangle's Perimeter is: "+(2*(RectangleWidth + RectangleLength))+".");
        // Closing the scanners to stop resource leaks
        rectanglewidth.close();
        rectanglelength.close();
    }
}

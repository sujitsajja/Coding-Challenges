import java.util.Scanner;

public class Reachable {
    static String isitpossible(int a, int b, int c, int d) {
        if(a>c||b>d)            // If the point is already beyond the target then it cant be reached
            return "No";
        if(a==c){               // If both the x co-ordinates match, then the diff btwn
            if((d-b)%a==0)      // y co-ordinates must be divisible by x
                return "Yes";
            else
                return "No";
        }
        if(b==d){               // If both the y co-ordinates match, then the diff btwn
            if((c-a)%b==0)      // x co-ordinates must be divisible by y
                return "Yes";
            else
                return "No";
        }
        if(isitpossible(a+b, b, c, d).equals("Yes")||isitpossible(a, b+a, c, d).equals("Yes")) // Recursive call
            return "Yes";
        else
            return "No";
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the value of a : ");
        int a = in.nextInt();
        System.out.print("Enter the value of b : ");
        int b = in.nextInt();
        System.out.print("Enter the value of c : ");
        int c = in.nextInt();
        System.out.print("Enter the value of d : ");
        int d = in.nextInt();
        // (a,b) is the first co-ordinate
        // (c,d) is the target co-ordinate
        System.out.println(isitpossible(a,b,c,d));
    }
}
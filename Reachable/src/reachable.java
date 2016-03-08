import java.util.Scanner;

/**
 * Find if you can reach destination from source by
 * only going from (x,y) to either (x,x+y) or (x+y,y)
 * 
 * @author SujitS
 * 
 * @version 1.2
 * @since 2016-03-07
 */

public class Reachable {
    /**
     * Function to find if we can reach the destination from source
     * by only going from (x,y) to either (x,x+y) or (x+y,y)
     * 
     * @param a x Co-ordinate of current position
     * @param b y Co-ordinate of current position
     * @param c x Co-ordinate of target
     * @param d y Co-ordinate of target
     * 
     * @return "Yes" if it is possible
     *         "No"  if it is not possible
     */
    private static String isitpossible(int a, int b, int c, int d) {
        // If the point is already beyond the target then it cant be reached
        if(a>c||b>d)
            return "No";
        // If both the x co-ordinates match, then the diff between
        // y co-ordinates must be divisible by x
        if(a==c){
            if((d-b)%a==0)
                return "Yes";
            else
                return "No";
        }
        // If both the y co-ordinates match, then the diff between
        // x co-ordinates must be divisible by y
        if(b==d){
            if((c-a)%b==0)
                return "Yes";
            else
                return "No";
        }
        // Recursive call
        if(isitpossible(a+b, b, c, d).equals("Yes")||isitpossible(a, b+a, c, d).equals("Yes"))
            return "Yes";
        else
            return "No";
    }

    /**
     * @param args Command line argument
     */
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
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Given the number of rows, Generate the Pascal triangle
 * 
 * @author SujitS
 * 
 * @version 1.2
 * @since 2016-03-07
 */

public class Pascal1 {
    /**
     * @param args Command line argument
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the number of rows in pascal triangle : ");
        int n = in.nextInt();
        System.out.println();
        System.out.println("The pascal triangle is as follows : ");
        System.out.println(generate(n));
    }

    /**
     * Function to generate a Pascal triangle given number of rows
     * 
     * @param a Number of rows
     * 
     * @return Pascal triangle with each row in an array
     */
    private static ArrayList<ArrayList<Integer>> generate(int a) {
        ArrayList<ArrayList<Integer>> Result = new ArrayList<>();
        for(int i=0;i<a;i++) {
            ArrayList<Integer> temp = new ArrayList<>();
            for(int j=0;j<=i;j++) {
                if(j==0 || j==i)
                    temp.add(1);
                else
                    temp.add(Result.get(i-1).get(j)+Result.get(i-1).get(j-1));
            }
            Result.add(temp);
        }
        return Result;
    }

}

/**
 * Sample input:
 * 5
 * 
 * Sample output:
 * [[1], [1, 1], [1, 2, 1], [1, 3, 3, 1], [1, 4, 6, 4, 1]]
 */
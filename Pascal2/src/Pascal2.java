import java.util.ArrayList;
import java.util.Scanner;

/**
 * Find the Kth row in the Pascal Triangle
 * 
 * @author SujitS
 * 
 * @version 1.2
 * @since 2016-03-07
 */

public class Pascal2 {
    /**
     * @param args Command line argument
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the row number in pascal triangle : ");
        int n = in.nextInt();
        System.out.println();
        System.out.println("The "+n+" row in pascal triangle is as follows : ");
        System.out.println(getRow(n));
    }

    /**
     * Function to find the Kth row of Pascal triangle
     * 
     * @param a Row k
     * 
     * @return Kth row of Pascal triangle
     */
    private static ArrayList<Integer> getRow(int a) {
        ArrayList<Integer> Result = new ArrayList<>();
        for(int i=0;i<a+1;i++) {
            ArrayList<Integer> temp = new ArrayList<>();
            for(int j=0;j<=i;j++) {
                if(j==0 || j==i)
                    temp.add(1);
                else
                    temp.add(Result.get(j)+Result.get(j-1));
            }
			// Clear the previous row entries
            Result.clear();
            Result.addAll(temp);
        }
        return Result;
    }

}

/**
 * Sample input:
 * 5
 * 
 * Sample output:
 * [1, 5, 10, 10, 5, 1]
 */
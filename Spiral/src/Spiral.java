import java.util.ArrayList;
import java.util.Scanner;

/**
 * Generate a square matrix filled with elements from 1 to n^2 in spiral order
 * 
 * @author SujitS
 * 
 * @version 1.2
 * @since 2016-03-07
 */

public class Spiral {
    /**
     * @param args Command line argument
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the number of rows : ");
        int n = in.nextInt();
        System.out.println();
        System.out.println("The spiral matrix is as follows : ");
        System.out.println(generateMatrix(n));
    }

    /**
     * Function to Generate a square matrix filled
     * with elements from 1 to n^2 in spiral order
     * 
     * @param a Integer n
     * 
     * @return Square matrix with elements from 1 to n^2 in spiral order
     */
    private static ArrayList<ArrayList<Integer>> generateMatrix(int a) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        // Initialize the array
        for(int i=0;i<a;i++){
            ArrayList<Integer> temp = new ArrayList<>();
            for(int j=0;j<a;j++)
                temp.add(0);
            result.add(temp);
        }
        int top=0,bottom=a-1,left=0,right=a-1,dir=0;
        int num=1;
        // continue till we reach the middle of the array
        while(top<=bottom&&left<=right)
        {
            switch(dir){
                // From left to right
                case 0:
                    for(int i=left;i<=right;i++,num++)
                        result.get(top).set(i,num);
                    top++;
                    break;
                // From top to bottom
                case 1:
                    for(int i=top;i<=bottom;i++,num++)
                        result.get(i).set(right,num);
                    right--;
                    break;
                // From right to left
                case 2:
                    for(int i=right;i>=left;i--,num++)
                        result.get(bottom).set(i,num);
                    bottom--;
                    break;
                // From bottom to top
                case 3:
                    for(int i=bottom;i>=top;i--,num++)
                        result.get(i).set(left,num);
                    left++;
                    break;
            }
            dir++;
            // Change the direction
            dir = dir%4;
        }
        return result;
    }

}

/**
 * Sample input:
 * 3
 * 
 * Sample output:
 * [[1, 2, 3], [8, 9, 4], [7, 6, 5]]
 */
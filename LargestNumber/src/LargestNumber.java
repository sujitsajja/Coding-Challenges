import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * Given an array of elements find the largest number that can be formed by appending them
 * 
 * @author SujitS
 * 
 * @version 1.0
 * @since 2016-10-16
 */

public class LargestNumber {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of elements in the array : ");
        int n = sc.nextInt();
        ArrayList<Integer> input = new ArrayList<>(n);
        System.out.println("Enter the elements of the array seperated by Space/Enter :");
        for(int i=0;i<n;i++)
            input.add(sc.nextInt());
        final String largestNumber = getLargestNumber(input);
        System.out.println("The largest number that can be formed is : " + largestNumber);
    }
    
    /**
     * Function to find the largest number possible from the given numbers
     * @param input
     * @return String representation of the largest number possible
     */
    private static String getLargestNumber(ArrayList<Integer> input) {
        StringBuilder sb = new StringBuilder();
        // Sorting the integers based on the desired order
        Collections.sort(input, (Integer a, Integer b) -> {
            String first = String.valueOf(a) + String.valueOf(b);
            String second = String.valueOf(b) + String.valueOf(a);
            return second.compareTo(first);
        });
        input.stream().forEach((i) -> {
            sb.append(i);
        });
        return sb.toString();
    }
    
}

/**
 * Sample Input:
 * [3, 30, 34, 5, 9]
 * 
 * Sample Output:
 * 9534330
 */
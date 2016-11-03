import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Find the number of non unique numbers present in the given array of integers
 * 
 * @author SujitS
 * 
 * @version 1.0
 * @since 2016-10-31
 */

public class NonUnique {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of elements : ");
        int n = sc.nextInt();
        int[] input = new int[n];
        System.out.println("Enter the integers seperated by space/enter");
        for(int i=0;i<n;i++) {
            input[i] = sc.nextInt();
        }
        int nonUnique = numberOfNonUniqueTimeComplexity(input);
        System.out.println("The number of non unique integers in the given array are : " + nonUnique);
        nonUnique = numberOfNonUniqueSpaceComplexity(input);
        System.out.println("The number of non unique integers in the given array are : " + nonUnique);
    }
    
    /**
     * Function to find the number of non unique elements in the given array
     * Note: Uses O(n) space complexity and O(n) time complexity
     * @param input
     * @return
     */
    private static int numberOfNonUniqueTimeComplexity(int[] input) {
        int count = 0;
        HashMap<Integer, Integer> frequency = new HashMap<>();
        for(int i = 0; i < input.length; i++) {
            int number = input[i];
            if(frequency.containsKey(number)) {
                frequency.put(number, frequency.get(number)+1);
            } else {
                frequency.put(number, 1);
            }
        }
        for(Integer key : frequency.keySet()) {
            if(frequency.get(key)!=1) {
                count++;
            }
        }
        return count;
    }
    
    /**
     * Function to find the number of non unique elements in the given array
     * Note: Uses O(log(n)) space complexity and O(nlog(n)) time complexity
     * The log(n) space is used for stack during sorting
     * @param input
     * @return 
     */
    private static int numberOfNonUniqueSpaceComplexity(int[] input) {
        int count = 0;
        Arrays.sort(input);
        int prevElement = input[0];
        for(int i=1;i<input.length;i++) {
            int currentElement = input[i];
            if(prevElement == currentElement) {
                count++;
                while(i < input.length && input[i] == prevElement) {
                    i++;
                }
            }
            if(i != input.length) {
                prevElement = input[i];
            }
        }
        if(prevElement != input[input.length-1]) {
            count++;
        }
        return count;
    }
    
}

/**
 * Sample Input :
 * 5 3 4 5 4 3 6 1 6 8
 * 
 * Sample output:
 * 4
 */
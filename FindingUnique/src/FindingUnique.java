import java.util.HashSet;
import java.util.Scanner;

/**
 * Place all the unique elements of an array at the beginning
 * 
 * @author SujitS
 * 
 * @version 1.0
 * @since 2016-03-09
 */

public class FindingUnique {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the number of elements in the array : ");
        int n = in.nextInt();
        Integer[] input = new Integer[n];
        System.out.println("Enter the elements of the array seperated by space/enter :");
        for(int i=0;i<n;i++)
            input[i] = in.nextInt();
        int k = findDistinct(input);
        System.out.println("The distinct elements of given input are :");
        for(int i=0;i<k;i++)
            System.out.print(input[i]+" ");
    }

    /**
     * Function to move distinct elements to the front of the array
     * 
     * @param <T> Generic type
     * @param input Array of elements
     * 
     * @return integer k which indicates there are k
     *         distinct elements in the given input array
     */
    private static<T> int findDistinct(T[] input) {
        // Store the processed distinct elements in a set for future comparisions
        HashSet<T> distinct = new HashSet<>();
        int j = input.length-1;
        int i=0;
        int setSize = 0;
        // distinct elements will be placed at the begining till index i-1
        // Unprocessed elements will be between i and j inclusive
        // duplicates elements will be placed from index j+1 to the last
        while(i<=j) {
            distinct.add(input[i]);
            // If the current element is not a duplicate
            // then the size of the set will be increased
            if(setSize!=distinct.size()){
                setSize++;
                i++;
            }
            // If the current element is a duplicate
            // the size of set will not be changed as the
            // duplicate element overwrites the previous one
            else{
                // Place the duplicate element at the last of the array
                swap(input,i,j);
                j--;
            }
        }
        return i;
    }

    /**
     * Helper function to swap two elements in an array given their index positions
     * 
     * @param <T> Generic type
     * @param input Array of elements
     * @param i index of element to be swapped
     * @param j index of element to be swapped with
     */
    private static <T> void swap(T[] input, int i, int j) {
        T temp = input[i];
        input[i] = input[j];
        input[j] = temp;
    }
    
}

/**
 * Sample Input :
 * 20
 * 1 2 3 2 5 2 3 1 4 2 4 2 6 7 3 8 7 1 9 5
 * 
 * Output :
 * The distinct elements of given input are :
 * 1 2 3 5 9 7 8 6 4
 * 
 */
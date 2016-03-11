import java.util.Scanner;

/**
 * Given an array of n+1 integers between 1 to n
 * find any number that repeats more than once
 * 
 * @author SujitS
 * 
 * @version 1.0
 * @since 2016-03-10
 */

public class FindingDuplicate {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the number of elements in the array : ");
        int n = in.nextInt();
        int[] input = new int[n];
        System.out.println("Enter the elements of the array seperated by space/enter :");
        for(int i=0;i<n;i++)
            input[i] = in.nextInt();
        int k = findRepeated(input);
        System.out.println("A repeated element of given input is :"+k);
    }

    /**
     * Function to find duplicate element in the given array
     * 
     * @param input integer array
     * 
     * @return duplicate element
     */
    private static int findRepeated(int[] a) {
        int size = a.length;
        for(int i=0;i<size;i++){
            int index = a[i];
            if(index<0)
                index = -index;
            // If the element at that index is already set to negative
            // then it means that the number is repeated
            if(a[index]<0)
                return index;
            else
                a[index] = -a[index];
        }
        return -1;
    }

}

/**
 * Sample input:
 * 10 
 * 1 2 4 3 5 6 5 8 9 7
 * 
 * Sample output:
 * 5
 */
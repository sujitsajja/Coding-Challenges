import java.util.Scanner;

/**
 * Find the index of element in the given sorted array
 * If it is not present return the position where it needs to be inserted
 * 
 * @author SujitS
 * 
 * @version 1.0
 * @since 2016-03-11
 */

public class SortedInsertPosition {

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
        System.out.print("Enter the element you want to search for : ");
        int x = in.nextInt();
        int k = findPositionSortedArray(input,x,0,input.length-1);
        System.out.println("The position of element in the given input is :"+k);
    }

    /**
     * Function to find the position of the element in the given array
     * 
     * @param input Sorted array
     * @param x Element whose position needs to be found
     * @param low Start index of the array
     * @param high End index of the array
     * 
     * @return Position of the element in the array
     */
    private static int findPositionSortedArray(int[] input, int x, int low, int high) {
        if(low==high){
            if(input[low]<x)
                return low+1;
            else
                return low;
        }
        else if(low+1==high){
            if(input[high]<x)
                return high+1;
            else if(input[low]<x)
                return high;
            else
                return low;
        }
        int middle = (low+high)/2;
        if(input[middle]>x)
            return findPositionSortedArray(input, x, low, middle-1);
        else if(input[middle]<x)
            return findPositionSortedArray(input, x, middle+1, high);
        else
            return middle;
    }

}

/**
 * Sample input1:
 * 4
 * 1 3 5 6
 * 5
 * Sample output1:
 * 2
 * 
 * Sample input2:
 * 4
 * 1 3 5 6
 * 7
 * Sample output2:
 * 4
 */
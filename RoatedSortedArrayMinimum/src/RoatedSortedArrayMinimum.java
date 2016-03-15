import java.util.Scanner;

/**
 * Find the minimum element in the rotated sorted array
 * 
 * @author SujitS
 * 
 * @version 1.0
 * @since 2016-03-15
 */

public class RoatedSortedArrayMinimum {

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
        int k = findMinimum(input,0,n-1);
        System.out.println("The minimum element in the given input is : "+k);
    }

    /**
     * Function  to find the minimum element in the given array
     * 
     * @param input Array
     * @param low Start index of the array
     * @param high End index of the array
     * 
     * @return Minimum element in the array
     */
    private static int findMinimum(int[] input,int low,int high) {
        if(low==high)
            return input[low];
        if(low+1==high){
            if(input[low]<input[high])
                return input[low];
            else
                return input[high];
        }
        int middle = (low+high)/2;
        if((input[middle]>input[low])&&(input[high]<=input[middle]))
            return findMinimum(input, middle+1, high);
        else if((input[middle]<input[low])&&(input[middle]<=input[high]))
            return findMinimum(input, low, middle);
        else
            return input[low];
    }

}

/**
 * Sample input:
 * 10
 * 5 6 7 8 9 0 1 2 3 4
 * 
 * Sample output:
 * 0
 */
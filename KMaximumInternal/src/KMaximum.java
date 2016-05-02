import java.util.Scanner;

/**
 * To find the K maximum elements in the given dataset
 * 
 * @author SujitS
 * 
 * @version 1.0
 * @since 2016-05-01
 */

public class KMaximum {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of elements : ");
        int n = sc.nextInt();
        int[] input = new int[n];
        System.out.println("Enter the integers seperated by Space/Enter :");
        for(int i=0;i<n;i++)
            input[i] = sc.nextInt();
        System.out.print("Enter the value of K : ");
        int k = sc.nextInt();
        findKMax(input,k);
        System.out.println("The "+k+" maximum elements in the given input are as follows :");
        for(int i=n-k;i<n;i++)
            System.out.print(input[i]+" ");
        System.out.println();
    }

    /**
     * Function to find the k maximum elements in the given dataset
     * 
     * @param input Dataset
     * @param k number of maximum elements to be found
     */
    private static void findKMax(int[] input, int k) {
        if(k<input.length)
            findKMax(input,0,input.length-1,k);
    }

    /**
     * Recursive function to find k maximum elements in the given dataset
     * 
     * @param input Dataset
     * @param low Start index of dataset
     * @param high End index of dataset
     * @param k number of maximum elements to be found
     */
    private static void findKMax(int[] input, int low, int high, int k) {
        int randomPivot = low+(int)(Math.random()*((high-low)+1));
        swap(input,randomPivot,high);
        int j = high-1;
        for(int i=low;i<=j;){
            if(input[i]>input[high]){
                swap(input, i, j);
                j--;
            }
            else
                i++;
        }
        swap(input,j+1,high);
        if(high-j-1>=k)
            findKMax(input, j+2, high, k);
        else if(high-j != k)
            findKMax(input, low, j, k-high+j);
    }

    /**
     * Helper function to swap two elements in an array
     * 
     * @param input Array
     * @param randomPivot Index1
     * @param high Index2
     */
    private static void swap(int[] input, int randomPivot, int high) {
        int temp = input[randomPivot];
        input[randomPivot] = input[high];
        input[high] = temp;
    }

}

/**
 * Sample input:
 * 20
 * 10 15 9 3 8 20 5 19 1 2 17 18 11 16 4 7 6 12 14 13
 * 5
 * 
 * Sample output:
 * 16 18 17 19 20
 */
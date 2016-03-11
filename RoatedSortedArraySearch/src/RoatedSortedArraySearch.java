import java.util.Scanner;

/**
 * Search for an element in sorted array which is rotated at some pivot
 * 
 * @author SujitS
 * 
 * @version 1.0
 * @since 2016-03-10
 */

public class RoatedSortedArraySearch {

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
        int k = findRoatedSortedArray(input,x,0,input.length-1);
        if(k!=-1)
            System.out.println("The index of element in the given input is :"+k);
        else
            System.out.println("The element is not present in the given input");
    }

    private static int findRoatedSortedArray(int[] input, int x, int low, int high) {
        if(high<low)
            return -1;
        else if(high == low){
            if(input[low] == x)
                return low;
            else
                return -1;
        }
        int middle = (low + high)/2;
        if(input[middle]>=input[low] && input[high]>= input[middle]){
            if(input[middle]<x)
                return findRoatedSortedArray(input, x, middle+1, high);
            else if(input[middle]>x)
                return findRoatedSortedArray(input, x, low, middle-1);
            else
                return middle;
        }
        else if(input[middle]<=input[high]){
            if(input[middle]>=x && input[high]<=x)
                return findRoatedSortedArray(input, x, middle, high);
            else
                return findRoatedSortedArray(input, x, low, middle-1);
        }
        else{
            if(input[middle]>=x && input[low]<=x)
                return findRoatedSortedArray(input, x, low, middle);
            else
                return findRoatedSortedArray(input, x, middle+1, high);
        }
    }

}

/**
 * Sample input:
 * 10
 * 5 6 7 8 9 0 1 2 3 4
 * 6
 * 
 * Sample output:
 * 1
 */
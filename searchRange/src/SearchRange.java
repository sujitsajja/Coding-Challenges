import java.util.ArrayList;
import java.util.Scanner;

/**
 * Search for start and end positions of an element in the given sorted array.
 * 
 * @author SujitS
 * 
 * @version 1.0
 * @since 2016-03-11
 */

public class SearchRange {

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
        ArrayList<Integer> k = findRangeSortedArray(input,x,0,input.length-1);
        if(k.get(0)!=-1)
            System.out.println("The start and end index of element in the given input is :"+k.get(0)+" , "+k.get(1)+" respectively");
        else
            System.out.println("The element is not present in the given input");
    }

    /**
     * Function to perform binary search for the element in the given array
     * 
     * @param input Sorted array
     * @param x Element to be found
     * @param low Start index of the array
     * @param high End index of the array
     * 
     * @return Start and end index of the element in the array
     */
    private static ArrayList<Integer> findRangeSortedArray(int[] input, int x, int low, int high) {
        ArrayList<Integer> result = new ArrayList<>();
        // If the element is not present we return (-1,-1)
        if(high<low){
            result.add(-1);
            result.add(-1);
            return result;
        }
        int middle = (low+high)/2;
        // If the element is present in left half we recursively call the left half
        if(input[middle]>x)
            return findRangeSortedArray(input, x, low, middle-1);
        // If the element is present in the right half we recursively call the right half
        else if(input[middle]<x)
            return findRangeSortedArray(input, x, middle+1, high);
        // If the middle element is the element we are looking for
        // then the start index will be in the left half
        // and the end index will be in the right half
        else{
            result.add(findStart(input,x,low,middle));
            result.add(findEnd(input,x,middle,high));
            return result;
        }
    }

    /**
     * Function to find start index of the element in the given array
     * 
     * @param input Sorted Array
     * @param x Element to be found
     * @param low Start index of the array
     * @param high End index of the array
     * 
     * @return Start index of the element in the array
     */
    private static Integer findStart(int[] input, int x, int low, int high) {
        // If there is only one element in the array then it is the start index
        if(low == high)
            return low;
        // If there are exactly two elements then finding the middle will always
        // result in lowest element and may lead to infinite recursion
        else if(low+1==high){
            if(input[low]==x)
                return low;
             else
                return high;
        }
        else if(high<low)
            return high+1;
        int middle = (low+high)/2;
        // If the middle element is the element we are looking for
        // then the start index will be in the left half
        if(input[middle]==x)
            return findStart(input,x,low,middle);
        // Otherwise it will be in the right half
        else
            return findStart(input,x,middle+1,high);
    }

    /**
     * Function to find end index of the element in the given array
     * 
     * @param input Sorted array
     * @param x Element to be found
     * @param low Start index of the array
     * @param high End index of the array
     * 
     * @return End index of the element in the array
     */
    private static Integer findEnd(int[] input, int x, int low, int high) {
        // If there is only one element in the array then it is the start index
        if(low == high)
            return low;
        // If there are exactly two elements then finding the middle will always
        // result in lowest element and may lead to infinite recursion
        else if(low+1==high){
            if(input[high]==x)
                return high;
             else
                return low;
        }
        else if(high<low)
            return low-1;
        int middle = (low+high)/2;
        // If the middle element is not the element we are looking
        // for then the end index will be in the left half
        if(input[middle]!=x)
            return findEnd(input,x,low,middle-1);
        // Otherwise it will be in the right half
        else
            return findEnd(input,x,middle,high);
    }

}

/**
 * Sample input:
 * 6
 * 5 7 7 8 8 10
 * 8
 * 
 * Sample output:
 * 3 4
 */
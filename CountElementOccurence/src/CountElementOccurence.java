import java.util.Scanner;

/**
 * Given a sorted array of integers and a target
 * find the number of times it is repeated in the array
 * 
 * @author SujitS
 * 
 * @version 1.0
 * @since 2016-03-18
 */

public class CountElementOccurence {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of elements in the input : ");
        int n = sc.nextInt();
        int[] input = new int[n];
        System.out.println("Enter the elements of the array seperated by Space/Integer :");
        for(int i=0;i<n;i++)
            input[i] = sc.nextInt();
        System.out.print("Enter the target value : ");
        int target = sc.nextInt();
        int k = countOccurence(input,target,0,input.length-1);
        System.out.println("The number of times given target appears in the array is "+k);
    }

    /**
     * Function to find the frequency of given target in the sorted array
     * 
     * @param input Sorted array of integers
     * @param target Element to be searched for
     * @param low Start index of the array
     * @param high End index of the array
     * 
     * @return Frequency of the given target in input array
     */
    private static int countOccurence(int[] input, int target, int low, int high) {
        if(high<=low && input[low]!=target)
            return 0;
        int middle = (low+high)/2;
        if(input[middle]<target)
            return countOccurence(input, target, middle+1, high);
        else if(input[middle]>target)
            return countOccurence(input, target, low, middle-1);
        else{
            int lowerBound = findLowerBound(input,target,low,middle);
            int upperBound = findUpperBound(input,target,middle,high);
            return upperBound-lowerBound+1;
        }
    }

    /**
     * Function to find the lower bound of the given target in the array
     * 
     * @param input Sorted integer array
     * @param target Target whose lower bound needs to found
     * @param low Start index of the array
     * @param high End index of the array
     * 
     * @return Lower bound of the target in the array
     */
    private static int findLowerBound(int[] input, int target, int low, int high) {
        if(low==high)
            return low;
        if(low+1==high){
            if(input[low]==target)
                return low;
            else
                return high;
        }
        int middle = (low+high)/2;
        if(input[middle]<target)
            return findLowerBound(input, target, middle+1, high);
        else
            return findLowerBound(input, target, low, middle);
    }

    /**
     * Function to find the upper bound of the given target in the array
     * 
     * @param input Sorted integer array
     * @param target Target whose upper bound needs to found
     * @param low Start index of the array
     * @param high End index of the array
     * 
     * @return upper bound of the target in the array
     */
    private static int findUpperBound(int[] input, int target, int low, int high) {
        if(low==high)
            return low;
        if(low+1==high){
            if(input[high]==target)
                return high;
            else
                return low;
        }
        int middle = (low+high)/2;
        if(input[middle]>target)
            return findUpperBound(input, target, low, middle-1);
        else
            return findUpperBound(input, target, middle, high);
    }

}

/**
 * Sample  input:
 * 6
 * 5 7 7 8 8 10
 * 8
 * 
 * Sample output:
 * 2
 */
import java.util.Scanner;

/**
 * Find the point of inflection in the bitonic array
 * 
 * @author SujitS
 * 
 * @version 1.0
 * @since 2016-03-15
 */

public class BitonicArray {

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
        int k = findInflection(input,0,n-1);
        System.out.println("The inflection point in the given input is : "+k);
    }

    /**
     * Function to find the inflection point in the given input
     * 
     * @param input Bitonic Array
     * @param low Start index of the array
     * @param high End index of the array
     * 
     * @return Inflection point of the bitonic array
     */
    private static int findInflection(int[] input,int low,int high) {
        if(low==high)
			return low;
		if(low+1==high){
			if(input[low]<=input[high])
				return high;
			else
				return low;
		}
		int middle = (low+high)/2;
		if(input[middle] > input[middle-1] && input[middle] > input[middle+1])
			return middle;
		if(input[middle] > input[high] && input[middle] > input[low] && input[middle] < input[middle-1])
			return findInflection(input, low, middle-1);
		return findInflection(input, middle+1, high);
    }

}

/**
 * Sample input:
 * 10
 * 2 4 6 8 10 9 7 5 3 1
 * 
 * Sample output:
 * 4
 */
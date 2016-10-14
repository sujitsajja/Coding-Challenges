import java.util.Scanner;

/**
 * Given an array find if you can form a subset with given sum
 * 
 * @author SujitS
 * 
 * @version 1.0
 * @since 2016-04-14
 */

public class SubsetSum2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of elements : ");
        int n = sc.nextInt();
        int[] input = new int[n];
        System.out.println("Enter the numbers seperated by Space/Enter :");
        for(int i=0;i<n;i++)
            input[i] = sc.nextInt();
        System.out.print("Enter the target sum : ");
        int k = sc.nextInt();
        int sets = findSubsets(input,k);
        if(sets == 0)
            System.out.println("There is no subset that sums upto the given target");
        else
            System.out.println("There are "+sets+" subsets that sums upto the given target");
    }

    /**
     * Function to find the number of subsets if
     * there exists that sums upto the given target sum
     * 
     * @param input Input array
     * @param k Target Sum
     * 
     * @return Number of subsets that sum upto the given target
     */
    private static int findSubsets(int[] input, int k) {
        int[] sum = new int[k+1];
        sum[0] = 1;
        for(int i=0;i<input.length;i++){
            if(input[i]<=k){
                for(int j=k;j>=input[i];j--)
                    sum[j] = sum[j]+sum[j-input[i]];
            }
        }
        return sum[k];
    }

}

/**
 * Sample Input:
 * 5
 * 1 2 3 4 5
 * 11
 * 
 * Sample Output:
 * 2
 */
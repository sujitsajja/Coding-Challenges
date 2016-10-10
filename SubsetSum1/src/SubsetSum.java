import java.util.Scanner;

/**
 * Given an array find if you can form a subset with given sum
 * 
 * @author SujitS
 * 
 * @version 1.0
 * @since 2016-04-14
 */

public class SubsetSum {

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
        if(findSubset(input,k))
            System.out.println("There is a subset that sums upto the given target");
        else
            System.out.println("There is no subset that sums upto the given target");
    }

    /**
     * Function to find if there exists a subset
     * that sums upto the given target sum
     * 
     * @param input Input array
     * @param k Target Sum
     * 
     * @return True : There exists a subset whose sum is k
     *         False: There do not exist any subset whose sum is k
     */
    private static boolean findSubset(int[] input, int k) {
        boolean[] sum = new boolean[k+1];
        sum[0] = true;
        for(int i=0;i<input.length;i++) {
            if(input[i]>k) continue;
            for(int j=k;j>=input[i];j--)
                sum[j] = sum[j]||sum[j-input[i]];
            if(sum[k]) return true;
        }
        return false;
    }

}

/**
 * Sample Input:
 * 7
 * 1 3 5 7 9 11 13
 * 25
 * 
 * Sample Output:
 * There is a subset that sums upto the given target
 */
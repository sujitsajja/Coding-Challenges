import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.Scanner;

/**
 * Given a number, n, find the total number of 1 bits present in the numbers from 1 to n
 * 
 * @author SujitS
 * 
 * @version 1.0
 * @since 2016-10-23
 */

public class TotalSetBits {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number : ");
        int n = sc.nextInt();
        int[] oneBits = new int[n+1];
        countBits(oneBits);
        IntSummaryStatistics stat = Arrays.stream(oneBits).summaryStatistics();
        System.out.println("The number of one bits present is " + stat.getSum());
    }
    
    /**
     * Function to find the number of bits
     * @param oneBits
     */
    private static void countBits(int[] oneBits) {
        oneBits[0] = 0;
        for(int i=1;i<oneBits.length;i++) {
            oneBits[i] = ((i%2==0)?0:1) + oneBits[i/2];
        }
    }
    
}

/**
 * Sample Input:
 * 4
 * 
 * Sample Output:
 * 5
 */
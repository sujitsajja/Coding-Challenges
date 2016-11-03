import java.util.Scanner;

/**
 * Given a set of coins, arrange the coins in such a way that row[i] has i coins
 * Find the number of rows that are filled upto their maximum capacity
 * 
 * @author SujitS
 * 
 * @version 1.0
 * @since 2016-10-31
 */

public class NumberOfCoinRows {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of coins : ");
        int n = sc.nextInt();
        System.out.println("The number of rows with max capacity : " + countNumberOfRows(n));
    }
    
    /**
     * Function to find the number of complete rows
     * @param coins
     * @return 
     */
    private static int countNumberOfRows(int coins) {
        int count = 0;
        int i = 0;
        while(i <= coins) {
            ++count;
            i+= count;
        }
        if(i > coins) count--;
        return count;
    }
    
}

/**
 * Sample Input:
 * 9
 * 
 * Sample Output:
 * 3
 */
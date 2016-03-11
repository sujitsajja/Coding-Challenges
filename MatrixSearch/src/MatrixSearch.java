import java.util.Scanner;

/**
 * Search for an element in a matrix in which integers in each row 
 * are sorted from left to right and also the first integer of each row
 * is greater than or equal to the last integer of the previous row
 * 
 * @author SujitS
 * 
 * @version 1.0
 * @since 2016-03-10
 */

public class MatrixSearch {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the number of rows in the array : ");
        int m = in.nextInt();
        System.out.print("Enter the number of cols in the array : ");
        int n = in.nextInt();
        int[][] input = new int[m][n];
        System.out.println("Enter the elements of the matrix seperated by space/enter :");
        for(int j=0;j<m;j++){
            for(int i=0;i<n;i++)
                input[j][i] = in.nextInt();
        }
        System.out.print("Enter the element you want to search for : ");
        int x = in.nextInt();
        if(findSortedMatrix(input,x,0,m-1))
            System.out.println("The element is present in the given matrix");
        else
            System.out.println("The element is not present in the given matrix");
    }

    /**
     * Function to find the element in the sorted matrix
     * 
     * @param input sorted matrix
     * @param x Element to find
     * @param low Start index of the row
     * @param high End index of the row
     * 
     * @return True if the element is found
     *         False if the element is not found
     */
    private static boolean findSortedMatrix(int[][] input, int x, int low, int high) {
        //If only one row is left to search we do normal binary search
        if(low==high)
            return binarySearch(input,x,0,input[0].length-1,low);
        // If two rows are left we pick one for normal binary search
        else if(low+1==high){
            if(input[high][0]<x)
                return binarySearch(input,x,0,input[0].length-1,high);
            else if(input[high][0]>x)
                return binarySearch(input,x,0,input[0].length-1,low);
            else
                return true;
        }
        int middle = (low+high)/2;
        if(input[middle][0]<x)
            return findSortedMatrix(input, x, middle, high);
        else if(input[middle][0]>x)
            return findSortedMatrix(input, x, low, middle);
        else
            return true;
    }

    /**
     * Function to do normal binary search
     * 
     * @param input sorted matrix
     * @param x Element to find
     * @param low Start index of the col
     * @param high End index of the col
     * @param row The row in which binary search needs to be performed
     * 
     * @return True if the element is found
     *         False if the element is not found
     */
    private static boolean binarySearch(int[][] input, int x, int low, int high, int row) {
        if(high<low)
            return false;
        int middle = (low+high)/2;
        if(input[row][middle]<x)
            return binarySearch(input, x, middle+1, high, row);
        else if(input[row][middle]>x)
            return binarySearch(input, x, low, middle-1, row);
        else
            return true;
    }

}

/**
 * Sample input:
 * 9
 * 1
 * 1 3 5 7 10 11 16 20 23 30 34 50
 * 3
 * 
 * Sample output:
 * True
 */
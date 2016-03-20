import java.util.Scanner;

/**
 * Given three sorted arrays find a window with minimum difference where the
 * window should contain at-least one elements from all the three arrays
 * 
 * @author SujitS
 * 
 * @version 1.0
 * @since 2016-03-20
 */

public class Array3Pointer {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of elements in the array 1 : ");
        int len1 = sc.nextInt();
        int[] array1 = new int[len1];
        System.out.println("Enter the elements of array 1 seperated by space/enter :");
        for(int i=0;i<len1;i++)
            array1[i] = sc.nextInt();
        System.out.print("Enter the number of elements in the array 2 : ");
        int len2 = sc.nextInt();
        int[] array2 = new int[len2];
        System.out.println("Enter the elements of array 2 seperated by space/enter :");
        for(int i=0;i<len2;i++)
            array2[i] = sc.nextInt();
        System.out.print("Enter the number of elements in the array 3 : ");
        int len3 = sc.nextInt();
        int[] array3 = new int[len3];
        System.out.println("Enter the elements of array 3 seperated by space/enter :");
        for(int i=0;i<len3;i++)
            array3[i] = sc.nextInt();
        int k = findMinimum(array1,array2,array3);
        System.out.println("The minimum window size of the given arrays is "+k);
    }

    /**
     * Function to find the range of smallest window possible
     * 
     * @param array1 Sorted array 1
     * @param array2 Sorted array 2
     * @param array3 Sorted array 3
     * 
     * @return Minimum window size possible
     */
    private static int findMinimum(int[] array1, int[] array2, int[] array3) {
        int len1 = array1.length;
        int len2 = array2.length;
        int len3 = array3.length;
        int finalMin = Integer.MAX_VALUE;
        for(int i=0,j=0,k=0;i<len1 && j<len2 && k<len3;){
            int one = array1[i];
            int two = array2[j];
            int three = array3[k];
            // Find the currect window range
            int tempMin = Math.max(Math.max(one,two),three) - Math.min(Math.min(one,two),three);
            // Compare it with minimum range found so far.
            if(tempMin < finalMin)
                finalMin = tempMin;
            // We move only the pointer which points to the minimum value
            // because moving pointer that points maximum value will
            // increase the range of window
            if(one<=two  && one<=three)
                i++;
            else if(two<=one  && two<=three)
                j++;
            else
                k++;
        }
        return finalMin;
    }

}

/**
 * Sample input:
 * 3
 * 1 4 10
 * 3
 * 2 15 20
 * 2
 * 10 12
 * 
 * Sample output:
 * 5
 */
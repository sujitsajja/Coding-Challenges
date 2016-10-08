import java.util.Scanner;

/**
 * Given a read only array of n+1 integers between 1 to n
 * find any number that repeats more than once
 * 
 * @author SujitS
 * 
 * @version 2.0
 * @since 2016-10-08
 */

public class FindingDuplicate {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the number of elements in the array : ");
        int n = in .nextInt();
        int[] input = new int[n];
        System.out.println("Enter the elements of the array seperated by space/enter :");
        for (int i = 0; i < n; i++)
            input[i] = in .nextInt();
        int k = findRepeated(input);
        System.out.println("A repeated element of given input is : " + k);
    }

    /**
     * Function to find duplicate element in the given array
     * 
     * @param input integer array
     * 
     * @return duplicate element
     */
    private static int findRepeated(int[] a) {
        int maximumNumber = a.length - 1;
        int numberOfBuckets = (int) Math.ceil(Math.sqrt(maximumNumber));
        // Each bucket range will be equal to numberOfBuckets
        int[] buckets = new int[numberOfBuckets];
        // For each element find the respective bucket number and increment the count in bucket at that position
        for (int i = 0; i <= maximumNumber; i++) {
            int bucketNumber = (int) Math.ceil(a[i] / numberOfBuckets);
            // If the bucket range is x, then x will be in the first bucket not second (inclusive)
            if (a[i] % numberOfBuckets == 0)
                --bucketNumber;
            buckets[bucketNumber]++;
        }
        // Each bucket is supposed to have a maximum count of bucket range
        // If any bucket crosses this, then we can be sure that there is atleast one duplicate in that range
        int targetBucketNumber = 0;
        for (int i = 0; i < numberOfBuckets; i++) {
            targetBucketNumber = i;
            if (buckets[i] > numberOfBuckets)
                break;
        }
        // Because of the rounding in numberOfBuckets, there might be cases where we have created an extra bucket in the last
        if (buckets[targetBucketNumber] == 0)
            targetBucketNumber--;
        HashSet < Integer > duplicateRangeElements = new HashSet < > ();
        int setCount = 0;
        for (int j = 0; j <= maximumNumber; j++) {
            int bucketNumber = (int) Math.ceil(a[j] / numberOfBuckets);
            if (a[j] % numberOfBuckets == 0)
                --bucketNumber;
            // Add the elements only in the range in which we are sure that there is atleast one duplicate
            if (bucketNumber == targetBucketNumber) {
                duplicateRangeElements.add(a[j]);
                // Check if the element has already been added
                if (setCount == duplicateRangeElements.size())
                    return a[j];
                setCount++;
            }
        }
        return 0;
    }

}

/**
 * Sample input:
 * 10 
 * 1 2 4 3 5 6 5 8 9 7
 * 
 * Sample output:
 * 5
 */
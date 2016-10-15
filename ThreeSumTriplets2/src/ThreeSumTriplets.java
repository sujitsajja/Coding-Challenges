import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * Given an array of unique elements find the number of
 * triplets whose sum is less than the given target.
 * 
 * @author SujitS
 * 
 * @version 1.0
 * @since 2016-10-14
 */

public class ThreeSumTriplets {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of elements in the array : ");
        int n = sc.nextInt();
        ArrayList<Integer> input = new ArrayList<>(n);
        System.out.println("Enter the elements of the array seperated by Space/Enter :");
        for(int i=0;i<n;i++)
            input.add(sc.nextInt());
        System.out.print("Enter the target sum : ");
        int target = sc.nextInt();
        int tripletsCount = findTriplets(input,target);
        System.out.println("The number of triplets that can be formed with sum less than the given target are : "+tripletsCount);
    }
    
    /**
     * Function to find the count of triplets whose sum is less than a given target
     * 
     * @param input Array of integers
     * @param target Target sum
     * 
     * @return number of triplets whose sum is less than target
     */
    private static int findTriplets(ArrayList<Integer> input, int target) {
        int count = 0;
        Collections.sort(input);
        int lastElementToBeConsidered = input.size()-1;
        while(input.get(lastElementToBeConsidered) > target && lastElementToBeConsidered >=0) lastElementToBeConsidered--;
        if(lastElementToBeConsidered < 0) return 0;
        for(int i=0;i<lastElementToBeConsidered-1;i++) {
            for(int j=i+1,k=input.size()-1;j<lastElementToBeConsidered && k>j;){
                if(input.get(i)+input.get(j)+input.get(k) < target) {
                    count += k-j;
                    j++;
                }
                // If the sum is greater than or equal to the target we move the third pointer to left
                while(input.get(i)+input.get(j)+input.get(k) >= target && k>j) k--;
            }
        }
        return count;
    }
    
}

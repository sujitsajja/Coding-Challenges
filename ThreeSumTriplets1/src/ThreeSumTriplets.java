import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * Given an array of unique elements find all the
 * triplets whose sum is equal to the given target.
 * 
 * @author SujitS
 * 
 * @version 1.0
 * @since 2016-03-19
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
        ArrayList<ArrayList<Integer>> triplets = findTriplets(input,target);
        if(!triplets.isEmpty())
            System.out.println("The triplets that form the given target sum are : "+triplets);
        else
            System.out.println("There are no triplets that form the given target sum");
    }

    /**
     * Function to find all the triplets that sum upto the given target
     * 
     * @param input Array of integers
     * @param target Target sum
     * 
     * @return Triplets that sum upto target
     */
    private static ArrayList<ArrayList<Integer>> findTriplets(ArrayList<Integer> input, int target) {
        ArrayList<ArrayList<Integer>> triplets = new ArrayList<>();
        // Sorting the input
        Collections.sort(input);
        int lastElementToBeConsidered = input.size()-1;
        while(input.get(lastElementToBeConsidered) > target && lastElementToBeConsidered >=0 ) lastElementToBeConsidered--;
        for(int i=0;i<lastElementToBeConsidered-1;i++) {
            for(int j=i+1,k=input.size()-1;j<k && j<lastElementToBeConsidered;) {
                int sum = input.get(i) + input.get(j) + input.get(k);
                // If the sum is equal to target we found a triplet
                if(sum==target){
                    ArrayList<Integer> triplet = new ArrayList<>();
                    triplet.add(input.get(i));
                    triplet.add(input.get(j));
                    triplet.add(input.get(k));
                    triplets.add(triplet);
                    j++;
                    k--;
                }
                // If the sum is less than target we move the second pointer to right
                else if(sum<target) {
                    while(input.get(i) + input.get(j) + input.get(k) < target && k>j) j++;
                }
                // If the sum is more than target we move the third pointer to left
                else {
                    while(input.get(i) + input.get(j) + input.get(k) > target && k>j) k--;
                }
            }
        }
        return triplets;
    }

}

/**
 * Sample input:
 * 12
 * 3 7 6 9 1 4 0 5 8 2 11 10
 * 5
 * 
 * Sample output:
 * [[0, 1, 4], [0, 2, 3]]
 */
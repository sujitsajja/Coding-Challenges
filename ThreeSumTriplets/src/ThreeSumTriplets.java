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
        System.out.println("Enter the elements of the array seperated by SPace/Enter :");
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

    private static ArrayList<ArrayList<Integer>> findTriplets(ArrayList<Integer> input, int target) {
        ArrayList<ArrayList<Integer>> triplets = new ArrayList<>();
        // Sorting the input
        Collections.sort(input);
        int size = input.size();
        for(int i=0;i<size-2;i++){
            for(int j=i+1,k=size-1;j<k;){
                int sum = input.get(i) + input.get(j) + input.get(k);
                if(sum==target){
                    ArrayList<Integer> triplet = new ArrayList<>();
                    triplet.add(input.get(i));
                    triplet.add(input.get(j));
                    triplet.add(input.get(k));
                    triplets.add(triplet);
                    j++;
                    k--;
                }
                else if(sum<target)
                    j++;
                else
                    k--;
            }
        }
        return triplets;
    }

}

/**
 * 
 */
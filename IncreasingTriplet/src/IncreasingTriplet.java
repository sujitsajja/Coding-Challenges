import java.util.ArrayList;
import java.util.Scanner;

/**
 * Given an array find any triplet that is in increasing order
 * 
 * @author SujitS
 * 
 * @version 1.0
 * @since 2016-10-14
 */

public class IncreasingTriplet {

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
        ArrayList<Integer> triplet = findIncreasingOrderTriplet(input);
        if(triplet.isEmpty()) {
            System.out.println("There is no such triplet");
        } else {
            System.out.print("Triplet : ");
            triplet.stream().forEach((item) -> {
                System.out.println(item + " ");
            });
        }
    }
    
    /**
     * Function to find the increasing order triplet
     * 
     * @param input Input array
     * 
     * @return Triplet
     */
    private static ArrayList<Integer> findIncreasingOrderTriplet(int[] input) {
        ArrayList<Integer> triplet = new ArrayList<>();
        // Find the indexes of the elements to the left that are lesser than the current element
        int[] lesser = new int[input.length];
        int minIndex = 0;
        lesser[0] = -1;
        for(int i=1;i<lesser.length;i++) {
            if(input[i]<=input[minIndex]) {
                lesser[i] = -1;
                minIndex = i;
            } else {
                lesser[i] = minIndex;
            }
        }
        // Find the indexes of the elements to the right that are greater than the current element
        int[] greater = new int[input.length];
        int maxIndex = input.length-1;
        greater[input.length-1] = -1;
        for(int i=input.length-2;i>=0;i--) {
            if(input[i]>=input[maxIndex]) {
                greater[i] = -1;
                maxIndex = i;
            } else {
                greater[i] = maxIndex;
            }
        }
        // Find an integer which has an integer lesser than that to its left
        // and also has another integer greater than that to its right
        for(int i=0;i<input.length;i++){
            if(lesser[i] != -1 && greater[i] != -1) {
                triplet.add(input[lesser[i]]);
                triplet.add(input[i]);
                triplet.add(input[greater[i]]);
                break;
            }
        }
        return triplet;
    }
    
}

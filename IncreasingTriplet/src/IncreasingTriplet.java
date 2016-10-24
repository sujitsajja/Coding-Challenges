import java.util.ArrayList;
import java.util.Scanner;

/**
 * Given an array find any triplet that is in increasing order
 * 
 * @author SujitS
 * 
 * @version 2.0
 * @since 2016-10-23
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
                System.out.print(item + " ");
            });
            System.out.println();
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
        int currentMinimum = input[0];
        int currentMaximum = input[input.length-1];
        int[] min = new int[input.length];
        int[] max = new int[input.length];
        for(int i=0;i<input.length;i++) {
            if(currentMinimum >= input[i]) {
                min[i] = -1;
                currentMinimum = input[i];
            } else {
                min[i] = currentMinimum;
            }
        }
        for(int i=input.length-1;i>=0;i--) {
            if(currentMaximum <= input[i]) {
                max[i] = -1;
                currentMaximum = input[i];
            } else {
                max[i] = currentMaximum;
            }
        }
        for(int i=0;i<input.length;i++) {
            if(min[i] != -1 && max[i] != -1) {
                triplet.add(min[i]);
                triplet.add(input[i]);
                triplet.add(max[i]);
                break;
            }
        }
        return triplet;
    }
    
}

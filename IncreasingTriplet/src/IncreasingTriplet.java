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
        int firstElement = Integer.MAX_VALUE;
        int secondElement = Integer.MAX_VALUE;
        for(int i=0;i<input.length;i++) {
            if(firstElement > input[i]) {
                firstElement = input[i];
            } else if (secondElement > input[i]) {
                secondElement = input[i];
            } else {
                triplet.add(firstElement);
                triplet.add(secondElement);
                triplet.add(input[i]);
                break;
            }
        }
        return triplet;
    }
    
}

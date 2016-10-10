import java.util.*;

/**
 * To find the maximum number in the window of
 * given size which slides from start till end
 * 
 * @author SujitS
 * 
 * @version 1.0
 * @since 2016-04-15
 */

/**
 * Class to represent each element in the input
 */
class Item{
    int number;         // Used to store the value
    int index;          // Used to store its index position
    Item(int number, int index){
        this.number = number;
        this.index = index;
    }
}

public class SlidingWindowMaximum {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of elements : ");
        int n = sc.nextInt();
        int[] input = new int[n];
        System.out.println("Enter the numbers seperated by space/Enter :");
        for(int i=0;i<n;i++)
            input[i] = sc.nextInt();
        System.out.print("Enter the window size : ");
        int w = sc.nextInt();
        int[] output = findWindowMax(input,w);
        System.out.println("The maximum numbers in the respective "
                + "windows are as follows :");
        for(int i=0;i<output.length;i++)
            System.out.print(output[i]+" ");
        System.out.println();
    }

    /**
     * Function to find the maximum number in the window
     * of given size which slides from left to right
     * 
     * @param input Input Array
     * @param w Window Size
     * 
     * @return Array of maximum numbers in their respective windows
     */
    private static int[] findWindowMax(int[] input, int w) {
        int n = input.length;
        // If the window size is more than the input size
        // then we just return the maximum value
        if(w>=input.length){
            IntSummaryStatistics stat = Arrays.stream(input).summaryStatistics();
            int[] output = {stat.getMax()};
            return output;
        }
        int[] output = new int[n-w+1];
        // We add the elements into priority queue based on
        // their values. We need to store their index as well.
        // So we create a new object for each number
        PriorityQueue<Item> pq = new PriorityQueue<>((Item a1, Item a2) -> a2.number - a1.number);
        // For the first window we keep on adding w elements
        for(int i=0;i<w;i++)
            pq.add(new Item(input[i],i));
        int j=0;
        output[j] = pq.peek().number;
        // From the second window, We add the new element into
        // the priority queue and take the maximum element
        // from the queue which is still in the window
        for(int i=w;i<n;i++){
            j++;
            pq.add(new Item(input[i],i));
            while(pq.peek().index<=i-w)
                pq.poll();
            output[j] = pq.peek().number;
        }
        return output;
    }

}

/**
 * Sample Input:
 * 5
 * 1 2 3 4 5
 * 3
 * 
 * Sample Output:
 * 3 4 5
 */
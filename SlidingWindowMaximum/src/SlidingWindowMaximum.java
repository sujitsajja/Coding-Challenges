import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * To find the maximum number in the window of
 * given size which slides from start till end
 * 
 * @author SujitS
 * 
 * @version 1.0
 * @since 2016-04-15
 */

class Item{
    int number;
    int index;
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

    private static int[] findWindowMax(int[] input, int w) {
        if(w>=input.length)
            return input;
        int n = input.length;
        int[] output = new int[n-w+1];
        PriorityQueue<Item> pq = new PriorityQueue<>((Item a1, Item a2) -> a2.number - a1.number);
        for(int i=0;i<w;i++)
            pq.add(new Item(input[i],i));
        int j=0;
        output[j] = pq.peek().number;
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
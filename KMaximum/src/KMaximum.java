import java.util.Scanner;

/**
 * To find the K maximum elements in large dataset
 * 
 * @author SujitS
 * 
 * @version 1.0
 * @since 2016-03-24
 */

class priorityQueue{
    int[] queue;
    int size;

    /**
     * Constructor for Priority Queue
     * 
     * @param n Size of the priority queue
     */
    public priorityQueue(int n) {
        queue = new int[n+1];
        size = 0;
    }

    /**
     * Function to add elements into the priority queue
     * 
     * @param x Element to be added
     */
    public void add(int x){
        queue[size+1] = x;
        size++;
        perculateUp(size);
    }

    /**
     * Function to re-arrange the heap order due to change in child element
     * 
     * @param index Element that violates the heap order
     */
    public void perculateUp(int index) {
        queue[0] = queue[index];
        while(queue[index/2]>queue[index]){
            swap(index/2,index);
            index = index/2;
        }
    }

    /**
     * Helper function to swap two elements in the queue
     * 
     * @param i Index position of element1
     * @param j Index position of element2
     */
    private void swap(int i, int j) {
        int temp = queue[i];
        queue[i] = queue[j];
        queue[j] = temp;
    }

    /**
     * Function to re-arrange the heap order due to change in parent
     * 
     * @param index Element that violates the heap order
     */
    public void perculateDown(int index){
        while(2*index <= size){
            if(queue[index]>queue[2*index]){
                if(2*index+1 <= size && queue[2*index]<queue[2*index+1]){
                    swap(index, 2*index);
                    index = 2*index;
                }
                else{
                    swap(index, 2*index+1);
                    index = 2*index+1;
                }
            }
            else if(2*index+1 <= size && queue[index]>queue[2*index+1]){
                swap(index, 2*index+1);
                index = 2*index+1;
            }
            else
                break;
        }
    }
}

public class KMaximum {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of elements : ");
        int n = sc.nextInt();
        int[] input = new int[n];
        System.out.println("Enter the integers seperated by Space/Enter :");
        for(int i=0;i<n;i++)
            input[i] = sc.nextInt();
        System.out.print("Enter the value of K : ");
        int k = sc.nextInt();
        int[] kMax = findKMax(input,k);
        System.out.println("The "+k+" maximum elements in the given input are as follows :");
        for(int i=1;i<k+1;i++)
            System.out.print(kMax[i]+" ");
        System.out.println();
    }

    /**
     * Function to find the K maximum elements in the given dataset
     * 
     * @param input Dataset
     * @param k Number of maximum values to be found
     * 
     * @return K maximum values in the given input
     */
    private static int[] findKMax(int[] input, int k) {
        int n = input.length;
        priorityQueue pq = new priorityQueue(k);
        for(int i=0;i<n;i++){
            // If there are less than k elements in our queue
            // then we directly add them into our queue
            if(pq.size<k)
                pq.add(input[i]);
            // Top most element of queue will always contain
            // minimum of the queue. If the current element is
            // greater than the minumum element of our queue
            // then we replace the minimum element with the current
            else if(pq.queue[1]<input[i]){
                pq.queue[1]=input[i];
                pq.perculateDown(1);
            }
        }
        return pq.queue;
    }

}

/**
 * Sample input:
 * 20
 * 10 15 9 3 8 20 5 19 1 2 17 18 11 16 4 7 6 12 14 13
 * 5
 * 
 * Sample output:
 * 16 18 17 19 20
 */
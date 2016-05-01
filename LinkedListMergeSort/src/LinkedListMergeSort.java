import java.util.Scanner;

/**
 * To implement Mergesort algorithm for linked list
 * 
 * @author SujitS
 * 
 * @version 1.0
 * @since 2016-05-01
 */

public class LinkedListMergeSort {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of elements : ");
        int n = sc.nextInt();
        System.out.println("Enter the elements seperated by space / enter");
        LinkedList<Integer> input = new LinkedList<>();
        for(int i=0;i<n;i++)
            input.add((Integer)sc.nextInt());
        input.mergeSort();
        System.out.println("The order of elements after sorting are");
        input.printList();
        System.out.println();
    }

}
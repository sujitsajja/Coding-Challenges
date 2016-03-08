/**
 * recursive functions for reversing the order of elements of the SinglyLinkedList class
 * and printing the elements of the SinglyLinkedList class in reverse order
 * 
 * @author SujitS
 * 
 * @version 1.0
 * @since 2016-08-03
 */

public class ReverseLinkedListRecursive<T> {

    /**
     * Node Structure
     * @param <T>
     */
    public class Entry<T> {
        T element;
        Entry<T> next;
        Entry(T x, Entry<T> nxt) {
            element = x;
            next = nxt;
        }
    }

    Entry<T> header, tail;
    int size;

    /**
     * Constructor
     */
    ReverseLinkedListRecursive() {
        header = new Entry<>(null, null);
        tail = null;
        size = 0;
    }

    /**
     * Function to add elements to the list
     * 
     * @param x Element to be added
     */
    private void add(T x) {
        if (tail == null) {
            header.next = new Entry<>(x, header.next);
            tail = header.next;
        } else {
            tail.next = new Entry<>(x, null);
            tail = tail.next;
        }
        size++;
    }

    /**
     * Function to print elements in the list
     */
    private void printList() {
        Entry<T> x = header.next;
        while (x != null) {
            System.out.print(x.element + " ");
            x = x.next;
        }
        System.out.println();
    }

    /**
     * helper function for reversing recursively
     */
    private void reverse() {
        Entry<T> x = header.next;
        if (x != null) {
            Entry<T> y = x.next;
            reverseRecursive(x, y);
        }
    }

    /**
     * Function to reverse the elements of linked list
     * 
     * @param prev previous node
     * @param curr current node
     */
    private void reverseRecursive(Entry<T> prev, Entry<T> curr) {
        if (curr == null) {
            header.next = prev;
            return;
        }
        //call for next set of pointers
        reverseRecursive(curr, curr.next);
        //reverse the pointer
        curr.next = prev;
        prev.next = null;
    }

    /**
     * helper function for printing list recursively
     */
    private void printListReverse() {
        Entry<T> x = header.next;
        printReverseRecursive(x);
    }

    /**
     * Function to print the elements of linked list in reverse order
     * 
     * @param x Current node
     */
    private void printReverseRecursive(Entry<T> x) {
        if (x == null)
            return;
        //first call for next element then print current element
        printReverseRecursive(x.next);
        System.out.print(x.element + " ");
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ReverseLinkedListRecursive<Integer> lst = new ReverseLinkedListRecursive<>();
        for (int i = 1; i <= 10; i++)
            lst.add(i);
        System.out.print("Original List : ");
        lst.printList();
        System.out.println();
        lst.reverse();
        System.out.print("Reverse List using recursion : ");
        lst.printList();
        System.out.println();
        lst.reverse();
        System.out.print("Print the list in reverse order using recursion : ");
        lst.printListReverse();
    }

}

/**
 * Sample Input:
 * lst: 1 2 3 4 5 6 7 8 9 10
 * 
 * Sample Output:
 * Reverse lst  : 10 9 8 7 6 5 4 3 2 1
 * Print reverse: 10 9 8 7 6 5 4 3 2 1
 */
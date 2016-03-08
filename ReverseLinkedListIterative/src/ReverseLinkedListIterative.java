import java.util.Stack;

/**
 * recursive functions for reversing the order of elements of the SinglyLinkedList class
 * and printing the elements of the SinglyLinkedList class in reverse order
 * 
 * @author SujitS
 * 
 * @version 1.0
 * @since 2016-08-03
 */

public class ReverseLinkedListIterative<T> {

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
    ReverseLinkedListIterative() {
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
     * Function to reverse the elements of linked list
     */
    void reverseList() {
        Entry<T> curr = header.next;
        if (curr != null) {
            Entry<T> prev = curr, next = curr.next;
            curr.next = null;
            //loop till end is reached
            while (next != null) {
                curr = next;
                next = curr.next;
                curr.next = prev; //reversing the pointer
                prev = curr;      //incrementing the pointer
                header.next = curr;
            }
        }
    }

    /**
     * Function to print the elements of linked list in reverse order
     */
    void printReverse() {
        //add elements to stack and then pop till stack is empty and print the popped element
        Entry<T> x = header.next;
        if (x != null) {
            Stack<T> stack = new Stack<>();
            while (x != null) {
                stack.add(x.element);
                x = x.next;
            }
            while (!stack.isEmpty())
                System.out.print(stack.pop() + " ");
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ReverseLinkedListIterative<Integer> lst = new ReverseLinkedListIterative<>();
        for (int i = 1; i <= 10; i++)
            lst.add(i);
        System.out.print("Original List : ");
        lst.printList();
        lst.reverseList();
        System.out.print("Reverse List without recursion : ");
        lst.printList();
        System.out.println();
        lst.reverseList();
        System.out.print("Print the list in reverse order without recursion : ");
        lst.printReverse();
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
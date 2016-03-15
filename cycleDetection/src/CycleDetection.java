/**
 * To detect the start node of a cycle in single linked list
 * 
 * @author SujitS
 * 
 * @version 1.0
 * @since 2016-03-15
 */

public class CycleDetection <T>{

    /**
     * Node Structure
     * @param <T>
     */
    public static class Entry<T> {
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
    CycleDetection() {
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
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        CycleDetection<Integer> list = new CycleDetection<>();
        for(int i=0;i<5;i++)
            list.add(i);
        Entry<Integer> startPoint = list.tail;
        for(int i=5;i<10;i++)
            list.add(i);
        list.tail.next = startPoint;    // To create a cycle
        System.out.print("The start node of cycle is : ");
        startPoint = findCycleHead(list);
        System.out.println(startPoint.element);
    }

    /**
     * Function to find the start node of cycle in linked list
     * 
     * @param list linked list that has a cycle
     * 
     * @return Start node of cycle in linked list
     */
    private static Entry<Integer> findCycleHead(CycleDetection<Integer> list) {
        // We have two pointers where one pointer
        // moves twice the speed of the other
        Entry<Integer> tortoise = list.header;
        Entry<Integer> hare = list.header;
        // Except for the first time if both the pointers meet
        // at same node then the node is part of a cycle
        boolean firstTime = true;
        while(tortoise!=hare || firstTime){
            firstTime = false;
            tortoise = tortoise.next;
            hare = hare.next.next;
        }
        tortoise = list.header;
        while(tortoise!=hare){
            tortoise = tortoise.next;
            hare = hare.next;
        }
        return tortoise;
    }

}

/**
 * Sample input:
 *        __________
 *       |          |
 * 1-2-3-4-5-6-7-8-9
 * 
 * Sample output:
 * 4
 */
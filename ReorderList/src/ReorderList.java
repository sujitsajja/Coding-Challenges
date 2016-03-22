/**
 * Re arrange the given linked list
 * 
 * @author SujitS
 * 
 * @version 1.0
 * @since 2016-03-21
 */

class LinkedList<T>{

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
    LinkedList() {
        header = new Entry<>(null, null);
        tail = null;
        size = 0;
    }

    /**
     * Function to add elements to the list
     * 
     * @param x Element to be added
     */
    public void add(T x) {
        if (tail == null) {
            header.next = new Entry<>(x, header.next);
            tail = header.next;
        } else {
            tail.next = new Entry<>(x, null);
            tail = tail.next;
        }
        size++;
    }

    public void printList(){
        Entry<T> temp = header.next;
        while(temp!=null){
            System.out.print(temp.element+" ");
            temp = temp.next;
        }
    }

    public void reorder(){
        int middle = size/2;
        Entry<T> list2Head = header.next;
        while(middle>0){
            list2Head = list2Head.next;
            middle--;
        }
        
    }

}

public class ReorderList {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        for(int i=1;i<11;i++)
            list.add(i);
        list.reorder();
        System.out.println("Elements of the list after re ordering are :");
        list.printList();
    }
    
}

/**
 * Sample input:
 * 1-2-3-4-5-6-7-8-9-10
 * 
 * Sample output:
 * 1-10-2-9-3-8-4-7-5-6
 */
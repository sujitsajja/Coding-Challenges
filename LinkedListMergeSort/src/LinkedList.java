/**
 * Class to represent a linked list
 * 
 * @author SujitS
 * @param <T> Generic type
 */

class LinkedList <T extends Comparable<? super T>>{

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

    void mergeSort() {
        int n = size;
        Entry<T> head = header.next;
        header = mergeSort(head,size);
    }

    /**
     * Recursive function to split the input list
     * 
     * @param head Start node of current list
     * @param n size of current list
     * 
     * @return Head of the new list
     */
    private Entry<T> mergeSort(Entry<T> head,int n){
        if(n<2){
            head.next = null;
            return head;
        }
        Entry<T> mid = head;
        for(int i=0;i<n/2;i++)
            mid = mid.next;
        head = mergeSort(head, n/2);
        mid = mergeSort(mid, n - n/2);
        return merge(head,mid);
    }

    private Entry<T> merge(Entry<T> list1, Entry<T> list2) {
        Entry<T> start;
        if (list1.element.compareTo(list2.element) <= 0) {
            start = list1;
            list1 = list1.next;
        } else {
            start = list2;
            list2 = list2.next;
        }
        Entry<T> temp = start;
        while(list1!=null && list2!=null){
            //add smaller element from two list every time
            if (list1.element.compareTo(list2.element) <= 0) {
                temp.next = list1;
                temp = temp.next;
                list1 = list1.next;
            } else {
                temp.next = list2;
                temp = temp.next;
                list2 = list2.next;
            }
        }
        //check if any more elements are left, then add them
        if (list1 != null)
            temp.next = list1;
        else
            temp.next = list2;
        return start;
    }

    /**
     * Helper function to print all the elements in the list
     */
    void printList() {
        Entry<T> node = header;
        while(node!=null){
            System.out.print(node.element+" ");
            node = node.next;
        }
    }

}
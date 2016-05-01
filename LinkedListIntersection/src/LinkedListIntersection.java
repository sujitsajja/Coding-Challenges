/**
 * Find the intersection point of given two linked lists
 * 
 * @author SujitS
 * 
 * @version 1.0
 * @since 2016-03-20
 */

public class LinkedListIntersection {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        LinkedList<Integer> list1 = new LinkedList<>();
        LinkedList<Integer> list2 = new LinkedList<>();
        for(int i=1;i<9;i++)
            list1.add(i);
        LinkedList.Entry intersectionPoint = list1.tail;
        for(int i=9;i<13;i++)
            list1.add(i);
        for(int i=2;i<8;i+=2)
            list2.add(i);
        list2.tail.next = intersectionPoint;   // To create an intersection point
        intersectionPoint = findIntersection(list1,list2);
        if(intersectionPoint!=null)
            System.out.println("The intersection point of two lists is : "+intersectionPoint.element);
        else
            System.out.println("There is no intersection point");
    }

    /**
     * Function to find the intersection point of two linked lists
     * 
     * @param list1 List 1
     * @param list2 List 2
     * 
     * @return Intersection point of given linked lists
     */
    private static LinkedList.Entry findIntersection(LinkedList<Integer> list1, LinkedList<Integer> list2) {
        LinkedList.Entry head1 = list1.header.next;
        LinkedList.Entry head2 = list2.header.next;
        int count1=0,count2=0;
        // Counting the elements of list 1
        while(head1!=null){
            count1++;
            head1 = head1.next;
        }
        // Counting the elements of list 2
        while(head2!=null){
            count2++;
            head2 = head2.next;
        }
        head1 = list1.header.next;
        head2 = list2.header.next;
        // Position both the pointers at equal distance from the tail
        while(count1>count2){
            head1 = head1.next;
            count1--;
        }
        while(count2>count1){
            head2 = head2.next;
            count2--;
        }
        // Start comparing both the nodes of list till you find the
        // intersection point or till you reach end of the list
        while(!(head1==null || head1==head2)){
            head1 = head1.next;
            head2 = head2.next;
        }
        return head1;
    }

}

/**
 * Sample input:
 * 1-2-3-4-5-6-7-\
 *                8-9-10-11-12
 *         2-4-6-/
 * 
 * Sample output:
 * 8
 */
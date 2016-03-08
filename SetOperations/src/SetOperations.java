import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

/**
 * Implement union, intersection, and set difference functions
 * of the sets for two sorted linked lists
 * 
 * @author SujitS
 * 
 * @version 1.0
 * @since 2016-03-08
 */
public class SetOperations {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        LinkedList<Integer> ls1 = new LinkedList<>();
        LinkedList<Integer> ls2 = new LinkedList<>();
        //list of numbers from 0 to 24
        for (int i = 0; i < 25; i++)
            ls1.add(i);
        //list of odd numbers from 0 to 24
        for (int i = 1; i < 25; i += 2)
            ls2.add(i);
        LinkedList<Integer> intersection = new LinkedList<>();
        LinkedList<Integer> union = new LinkedList<>();
        LinkedList<Integer> setDifference = new LinkedList<>();
        findIntersection(ls1, ls2, intersection);
        findUnion(ls1, ls2, union);
        findSetDifference(ls1, ls2, setDifference);
        System.out.println("Set 1 : " + ls1);
        System.out.println("Set 2 : " + ls2);
        System.out.println("Intersection : " + intersection);
        System.out.println("Union : " + union);
        System.out.println("Set Difference : " + setDifference);
    }

    /**
     * Function to find intersection of two sets represented in two lists
     * 
     * @param <T> generic type
     * @param ls1 Set 1
     * @param ls2 Set 2
     * @param intersection Intersection of Set1 and Set2
     */
    public static <T extends Comparable<? super T>> void findIntersection(List<T> ls1, List<T> ls2, List<T> intersection) {
        ListIterator<T> lstIter1 = ls1.listIterator();
        ListIterator<T> lstIter2 = ls2.listIterator();
        T element1 = null;
        T element2 = null;
        Boolean advance1 = true, advance2 = true;
        //iterate both lists till either of them ends
        while (lstIter1.hasNext() && lstIter2.hasNext()) {
            if (advance1)
                element1 = lstIter1.next();
            if (advance2)
                element2 = lstIter2.next();
            //if element is common in both the lists, add it to the intersection list
            if (element1.compareTo(element2) == 0) {
                intersection.add(element1);
                advance1 = true;
                advance2 = true;
            } else if (element1.compareTo(element2) < 0) {
                advance2 = false;
                advance1 = true;
            } else {
                advance1 = false;
                advance2 = true;
            }
        }
        //comparing rest of the elements in the list
        if (lstIter1.hasNext() && advance1) {
            element1 = lstIter1.next();
            if (element1.compareTo(element2) == 0)
                intersection.add(element1);
        } else if (lstIter2.hasNext() && advance2) {
            element2 = lstIter2.next();
            if (element1.compareTo(element2) == 0)
                intersection.add(element1);
        }
    }

    /**
     * Function to find union of two sets represented in two lists
     * 
     * @param <T> generic type
     * @param ls1 Set 1
     * @param ls2 Set 2
     * @param union Union of Set1 and Set2
     */
    public static <T extends Comparable<? super T>> void findUnion(List<T> ls1, List<T> ls2, List<T> union) {
        ListIterator<T> lstIter1 = ls1.listIterator();
        ListIterator<T> lstIter2 = ls2.listIterator();
        T element1 = null, element2 = null;
        Boolean advance1 = true, advance2 = true;
        while (lstIter1.hasNext() && lstIter2.hasNext()) {
            if (advance1)
                element1 = lstIter1.next();
            if (advance2)
                element2 = lstIter2.next();
            //if both lists have the same element add any one to the union list
            if (element1.compareTo(element2) == 0) {
                union.add(element1);
                advance1 = true;
                advance2 = true;
            } else if (element1.compareTo(element2) < 0) {
                union.add(element1);
                advance1 = true;
                advance2 = false;
            } else {
                union.add(element2);
                advance2 = true;
                advance1 = false;
            }
        }
        while (lstIter1.hasNext())
            union.add(lstIter1.next());
        while (lstIter2.hasNext())
            union.add(lstIter2.next());
    }

    /**
     * Function to find set difference of two sets represented in two lists
     * 
     * @param <T> generic type
     * @param ls1 Set 1
     * @param ls2 Set 2
     * @param setDifference Set difference of Set1 and Set2 (Set1-Set2)
     */
    public static <T extends Comparable<? super T>> void findSetDifference(List<T> ls1, List<T> ls2, List<T> setDifference) {
        ListIterator<T> lstIter1 = ls1.listIterator();
        ListIterator<T> lstIter2 = ls2.listIterator();
        T element1 = null, element2 = null;
        Boolean advance1 = true, advance2 = true;
        while (lstIter1.hasNext() && lstIter2.hasNext()) {
            if (advance1)
                element1 = lstIter1.next();
            if (advance2)
                element2 = lstIter2.next();
            //add only those elements to the list that are in list1 and not in list2
            if (element1.compareTo(element2) < 0) {
                setDifference.add(element1);
                advance1 = true;
                advance2 = false;
            } else if (element1.compareTo(element2) > 0) {
                advance1 = false;
                advance2 = true;
            }
            //when an element is common to both the lists then leave that element
            else {
                advance1 = true;
                advance2 = true;
            }
        }
        while (lstIter1.hasNext()) {
            element1 = lstIter1.next();
            if (element1.compareTo(element2) != 0)
                setDifference.add(element1);
        }
    }

}

/**
 * Sample input:
 * ls1: 0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24
 * ls2: 1 3 5 7 9 11 13 15 17 19 21 23
 * 
 * Sample Output:
 * Intersection  : 1 3 5 7 9 11 13 15 17 19 21 23
 * Union         : 0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24
 * Set Difference: 0 2 4 6 8 10 12 14 16 18 20 22 24
 */
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

/**
 * Add and Subtract large numbers where each digit is stored
 * as a separate node of the list
 * 
 * @author SujitS
 * 
 * @version 1.0
 * @since 2016-08-03
 */
public class ListAdditionSubtraction {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        LinkedList<Integer> ls1 = new LinkedList<>();
        LinkedList<Integer> ls2 = new LinkedList<>();
        //sample inputs taken in String form
        String num1 = "9999";
        String num2 = "8888";
        //converting the strings to List with LSD in the head
        for (int i = num1.length() - 1; i >= 0; i--) {
            ls1.add(Integer.parseInt(String.valueOf(num1.charAt(i))));
        }
        for (int i = num2.length() - 1; i >= 0; i--) {
            ls2.add(Integer.parseInt(String.valueOf(num2.charAt(i))));
        }
        System.out.println("Num 1: "+ ls1);
        System.out.println("Num 2: "+ ls2);
        LinkedList<Integer> addition = new LinkedList<>();
        LinkedList<Integer> subtraction = new LinkedList<>();
        add(ls1, ls2, addition);
        subtract(ls1, ls2, subtraction);
        System.out.println("Addition : " + addition);
        System.out.println("Subtraction : " + subtraction);
    }

    /**
     * Function to add two numbers represented in two separate lists
     * 
     * @param ls1 num1 
     * @param ls2 num2
     * @param addition addtion of num1 and num2 (num1+num2)
     */
    public static void add(List<Integer> ls1, List<Integer> ls2, List<Integer> addition) {
        //Assuming base to be 10
        int base = 10;
        //default carry value is 0
        int carry = 0;
        ListIterator<Integer> l1 = ls1.listIterator();
        ListIterator<Integer> l2 = ls2.listIterator();
        while (l1.hasNext() && l2.hasNext()) {
            int x = l1.next();
            int y = l2.next();
            //the remainder goes as sum
            addition.add((carry + x + y) % base);
            // quotient becomes the new carry
            carry = (carry + x + y) / base;
        }
        //if list2 ends then just add carry to list1 element
        while (l1.hasNext()) {
            int x = l1.next();
            addition.add((carry + x) % base);
            carry = (carry + x) / base;
        }
        //if list1 ends then just add carry to list2 element
        while (l2.hasNext()) {
            int y = l2.next();
            addition.add((carry + y) % base);
            carry = (carry + y) / base;
        }
        //if carry exists after both the list end then add it as a new digit
        if (carry != 0)
            addition.add(carry);
    }

    /**
     * Function to subtract two numbers represented in two separate lists
     * 
     * @param ls1 num1
     * @param ls2 num2
     * @param subtraction Difference of num2 from num1 (num1-num2)
     * 
     * Assuming num1 will always be greater than num2
     */
    public static void subtract(List<Integer> ls1, List<Integer> ls2, List<Integer> subtraction) {
        // Assuming the base to be 10
        int base = 10;
        //default borrow value is 0
        int borrow = 0;
        ListIterator<Integer> l1 = ls1.listIterator();
        ListIterator<Integer> l2 = ls2.listIterator();
        while (l2.hasNext()) {
            int x = l1.next();
            int y = l2.next();
            if (x != 0) {
                //decrement the borrow value
                x = x - borrow;
                //take borrow if upper number is smaller
                if (x < y)
                    borrow = 1;
                else
                    borrow = 0;
                //add the borrow if needed from higher significant digit
                x = borrow * base + x;
            } else {
                if (borrow == 1)
                    x = base - 1;
                else {
                    if (y != 0) {
                        borrow = 1;
                        x = base;
                    }
                }
            }
            subtraction.add(x - y);
        }
        //if list1 has elements left then keep adding them after considering the borrow value
        while (l1.hasNext()) {
            int x = l1.next();
            if (x != 0) {
                x = x - borrow;
                borrow = 0;
            } else {
                if (borrow == 1)
                    x = base - 1;
            }
            if (!l1.hasNext() && x == 0)
                break;
            subtraction.add(x);
        }
    }

}

/**
 * Sample Input:
 * num1: 9999
 * num2: 8888
 * 
 * Sample Output:
 * Addition   : 18887
 * Subtraction: 1111
 */
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Add 1 to the non negative number represented in an array
 * 
 * @author SujitS
 * 
 * @version 1.2
 * @since 2016-03-07
 */

public class Plus1 {
    /**
     * @param args Command line argument
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of digits : ");
        int n = sc.nextInt();
        ArrayList<Integer> input = new ArrayList<>(n);
        System.out.println("Enter the digits starting from MSD seperated by space/new line");
        for(int i=0;i<n;i++)
            input.add(sc.nextInt());
        System.out.println("The result is : "+plusOne(input));
    }

    /**
     * Function to add 1 to the non negative number represented in an array
     * 
     * @param a non negative number represented in an array
     * 
     * @return result of input plus 1 represented in an array
     */
    private static ArrayList<Integer> plusOne(ArrayList<Integer> a) {
        int size = a.size();
        ArrayList<Integer> result = new ArrayList<>(size);
        boolean carryFlag = true;
        for(int i=size-1;i>=0;i--){
            int number = a.get(i);
            if (carryFlag){
                number++;
                carryFlag = false;
                if(number<10)
                    a.set(i,number);
                else{
                    // If the digit crosses 10, set the carry flag
                    carryFlag = true;
                    a.set(i,0);
                    // If it is the first position, then add an extra digit
                    if(i==0){
                        result.add(1);
                        for(int j=0;j<size;j++)
                            result.add(a.get(j));
                        return result;
                    }
                }
            }
        }
        // For removing leading zeros
        carryFlag = true;
        for(int i=0;i<size;i++){
            int number = a.get(i);
            if(number!=0)
                carryFlag = false;
            if(!carryFlag)
                result.add(number);
        }
        return result;
    }

}
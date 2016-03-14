import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

/**
 * Find most frequently repeated integer in an array
 * with and without using hashing
 * 
 * @author SujitS
 * 
 * @version 1.0
 * @since 2016-03-09
 */

public class MostFrequent {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the number of elements in the array : ");
        int n = in.nextInt();
        int[] input = new int[n];
        System.out.println("Enter the elements of the array seperated by space/enter :");
        for(int i=0;i<n;i++)
            input[i] = in.nextInt();
        System.out.println("The most frequently repeating number(using hashmap) is : "+findMostRepeating(input));
        System.out.println("The most frequently repeating number(without using hashmap) is : "+findMostRepeatingBySorting(input));
    }

    /**
     * Function to find the most repeated number using HashMap
     * 
     * @param input Array of integers
     * 
     * @return integer which is most frequently repeated in input
     */
    private static int findMostRepeating(int[] input) {
        HashMap<Integer,Integer> hmap = new HashMap<>();
        for(Integer in: input){
            // If it is not present previously we add it to the map
            if(!hmap.containsKey(in))
                hmap.put(in, 1);
            // If it is already present we just increment its frequency
            else
                hmap.put(in, hmap.get(in)+1);
        }
        Iterator it = hmap.keySet().iterator();
        int mostRepeatingNumber = 0;
        int maxFrequency = 0;
        while(it.hasNext()){
            int number = (int) it.next();
            int frequency = hmap.get(number);
            if(frequency>maxFrequency){
                mostRepeatingNumber = number;
                maxFrequency = frequency;
            }
        }
        return mostRepeatingNumber;
    }

    /**
     * Function to find the most repeated number using sorting
     * 
     * @param input Array of integers
     * 
     * @return integer which is most frequently repeated in input
     */
    private static int findMostRepeatingBySorting(int[] input) {
        // Sorting the input array
        Arrays.sort(input);
        int mostRepeatingNumber = 0;
        int maxFrequency = 0;
        int current = input[0];
        int tempFrequency = 0;
        for(int i=0;i<input.length;i++){
            if(current == input[i])
                tempFrequency++;
            else{
                if(tempFrequency>maxFrequency){
                    maxFrequency = tempFrequency;
                    mostRepeatingNumber = current;
                }
                current = input[i];
                tempFrequency = 1;
            }
        }
        if(tempFrequency>maxFrequency)
            return current;
        else
            return mostRepeatingNumber;
    }
    
}

/**
 * Sample Input:
 * 20
 * 1 2 3 2 5 2 3 1 4 2 4 2 6 7 3 8 7 1 9 5
 * 
 * Output:
 * The most frequently repeating number(using hashmap) is : 2
 * The most frequently repeating number(using sorting) is : 2
 * 
 * Running time analysis in ms:
 * InputSize    UsingHashMap    UsingSorting
 * 354175           72              70
 * 820500           84              100
 * 1440000          144             176
 * 5760000          420             527
 */
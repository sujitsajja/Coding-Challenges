import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

/**
 * Find the number of transformations possible for the animal with start DNA to become an animal with end DNA
 * 
 * @author SujitS
 * 
 * @version 1.0
 * @since 2016-11-11
 */

public class DNATranformation {
    
    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the start DNA of martian : ");
        final String start = sc.next();
        System.out.print("Enter the end DNA of martian : ");
        final String end = sc.next();
        Set<String> listOfPossibleDNA = new HashSet<>();
        String DNA;
        BufferedReader br = new BufferedReader(new FileReader("DNAHistoryBook.txt"));
        while ((DNA = br.readLine()) != null) {
            listOfPossibleDNA.add(DNA);
        }
        int numberOfTranformations = findNumberOfTransformations(start, end, listOfPossibleDNA);
        if(numberOfTranformations < 0) {
            System.out.println("The transformation is not possible");
        } else {
            System.out.println("Number of tranformations are "+numberOfTranformations);
        }
    }
    
    /**
     * Function to find the number of transformations from start DNA to end DNA
     * @param start
     * @param end
     * @param listOfPossibleDNA
     * @return Number of transformations
     */
    private static int findNumberOfTransformations(String start, String end, Set<String> listOfPossibleDNA) {
        // Maintaining a set to store all the DNA's processed
        HashSet<String> processed = new HashSet<>();
        processed.add(start);
        // Storing the DNA's to be processed in a queue
        ArrayDeque<String> queue = new ArrayDeque<>();
        queue.add(start);
        // Maintaining the number of trnaformations for the elements in the queue
        ArrayDeque<Integer> transQueue = new ArrayDeque<>();
        transQueue.add(0);
        // Using breadth first search
        while(!queue.isEmpty()) {
            final String currentDNA = queue.poll();
            int numberOfTransformations = transQueue.poll();
            if(currentDNA.equals(end)) {
                return numberOfTransformations;
            }
            ++numberOfTransformations;
            List<String> possibleTransformations = getPossibleTransformations(currentDNA, listOfPossibleDNA);
            for(String DNA : possibleTransformations) {
                if(!processed.contains(DNA)) {
                    processed.add(DNA);
                    queue.add(DNA);
                    transQueue.add(numberOfTransformations);
                }
            }
        }
        return -1;
    }
    
    /**
     * Function to find the possible transformations from the current DNA
     * @param currentDNA
     * @param bank
     * @return list of possible transformations
     */
    private static List<String> getPossibleTransformations(String currentDNA, Set<String> bank) {
        List<String> possibleTransformations = new ArrayList<>();
        // Replacing each and every character with one of the possible character and generating all the permutations
        // Also checking if the permutaion is a valid DNA
        for(int i=0;i<8;i++) {
            char c = currentDNA.charAt(i);
            if(c != 'A') {
                final String tempDNA = currentDNA.substring(0, i) + 'A' + currentDNA.substring(i+1);
                if(bank.contains(tempDNA)) {
                    possibleTransformations.add(tempDNA);
                }
            }
            if(c != 'C') {
                final String tempDNA = currentDNA.substring(0, i) + 'C' + currentDNA.substring(i+1);
                if(bank.contains(tempDNA)) {
                    possibleTransformations.add(tempDNA);
                }
            }
            if(c != 'T') {
                final String tempDNA = currentDNA.substring(0, i) + 'T' + currentDNA.substring(i+1);
                if(bank.contains(tempDNA)) {
                    possibleTransformations.add(tempDNA);
                }
            }
            if(c != 'G') {
                final String tempDNA = currentDNA.substring(0, i) + 'G' + currentDNA.substring(i+1);
                if(bank.contains(tempDNA)) {
                    possibleTransformations.add(tempDNA);
                }
            }
        }
        return possibleTransformations;
    }
    
}

/**
 * Sample Input:
 * AAAAAAAC
 * AAAAATTC
 * 
 * Sample Output:
 * 2
 */
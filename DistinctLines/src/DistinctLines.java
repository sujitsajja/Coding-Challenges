import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Find the lines of file which are distinct
 * 
 * @author SujitS
 * 
 * @version 1.0
 * @since 2016-04-18
 */

public class DistinctLines {

    /**
     * @param args the command line arguments
     * @throws java.io.FileNotFoundException
     */
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("sampleInput.txt"));
        FileOutputStream fout = new FileOutputStream("sampleOutput.txt");
        System.setOut(new PrintStream(fout));
        findUnique(sc);
    }

    /**
     * Method used to find unique lines in the given file
     * 
     * @param sc Scanner used to read from file
     */
    private static void findUnique(Scanner sc) {
        // Lines will be stored in hashmap with
        // sum of elements in the line as key
        // and list of previous lines as values
        HashMap<Integer,ArrayList<ArrayList<Integer>>> lines = new HashMap<>();
        while(sc.hasNext()){
            ArrayList<Integer> currentLine = new ArrayList<>();
            String line = sc.nextLine();
            String[] ints = line.split("\\s+");
            for(String temp : ints)
                currentLine.add(Integer.parseInt(temp));
            // Sort the input so that comparing with previous
            // lines would be possible in linear time
            Collections.sort(currentLine);
            // Finding the sum of current line
            int sum = 0;
            for(Integer temp : currentLine)
                sum += temp;
            ArrayList<ArrayList<Integer>> previousLines = lines.get(sum);
            boolean placed = false;
            // If we had encountered another line with the same
            // sum then we start comparing with those lines
            if(previousLines != null){
                for(ArrayList<Integer> previous : previousLines){
                    if(currentLine.equals(previous)){
                        placed = true;
                        break;
                    }
                }
            }
            // If we did not encounter a previous line with this sum
            // then we have encountered a new distinct line
            else{
                previousLines = new ArrayList<>();
                lines.put(sum, previousLines);
            }
            // If its not previously placed then we add it to our map
            // for future comparisions so that file I/O would be reduced
            if(!placed){
                previousLines.add(currentLine);
                System.out.println(line);
            }
        }
    }

}
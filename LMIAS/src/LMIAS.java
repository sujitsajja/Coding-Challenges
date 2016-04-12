import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;
import java.util.Stack;

/**
 * To find the longest monotonically increasing and
 * accelerating subsequence from the given sequence
 * 
 * @author SujitS
 * 
 * @version 1.0
 * @since 2016-04-12
 */

public class LMIAS {

    /**
     * @param args the command line argument
     * @throws IOException
     * @throws FileNotFoundException 
     */
    public static void main(String[] args) throws IOException,FileNotFoundException {
        // Read from file
        File file;
        if(args.length>0)
            file = new File(args[0]);
        else
            file = new File("sampleInput.txt");
        Scanner sc = new Scanner(file);
        // Set the output to file
        FileOutputStream fout = new FileOutputStream("sampleOutput.txt");
        System.setOut(new PrintStream(fout));
        int n = sc.nextInt();
        int[] seuqence = new int[n];
        for(int i=0;i<n;i++)
            seuqence[i]=sc.nextInt();
        sc.close();
        int[][] LMIAS = new int[n][n];
        int[][] previous = new int[n][n];
        computeLMIAS(LMIAS,previous,seuqence);
        printLMIAS(LMIAS,previous,seuqence);
    }

    /**
     * Function to compute all the possible monotonically
     * increasing accelerating subsequences
     * 
     * @param LMIAS Matrix consisting of current length of subsequence
     * @param previous Matrix consisting of previous element of the subsequence
     * @param seuqence Input sequence
     */
    private static void computeLMIAS(int[][] LMIAS, int[][] previous, int[] seuqence) {
        int n = LMIAS.length;
        for(int i=0;i<n-1;i++){
            for(int j=i+1;j<n;j++){
                // If the number is not increasing then
                // we do not consider it in the subsequence
                if(seuqence[j]<=seuqence[i]){
                    LMIAS[i][j]=-1;
                    continue;
                }
                // We assume two elements to be fixed in our
                // sequence and then we find the previous element
                int fixedDist = seuqence[j]-seuqence[i];
                int temp = 1;
                for(int k=0;k<i;k++){
                    int tempDist = seuqence[i]-seuqence[k];
                    // If the previous element is greater than our
                    // current element or if it was increased by a
                    // factor more than our current elements
                    // then we do not consider those
                    if(LMIAS[k][i]==-1 || tempDist>=fixedDist)
                        continue;
                    if(LMIAS[k][i]>temp){
                        previous[i][j] = k;
                        temp = LMIAS[k][i];
                    }
                }
                LMIAS[i][j]=temp+1;
            }
        }
    }

    /**
     * Function to find the largest of all monotonically
     * increasing and accelerating subsequences computed
     * 
     * @param LMIAS Matrix consisting of length of subsequence
     * @param previous Matrix consisting of previous element of the subsequence
     * @param seuqence Input sequence
     */
    private static void printLMIAS(int[][] LMIAS, int[][] previous, int[] seuqence) {
        int maxLMIAS = 1,x=0,y=0;
        int n = LMIAS.length;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(LMIAS[i][j]>maxLMIAS){
                    x=i;
                    y=j;
                    maxLMIAS = LMIAS[i][j];
                }
            }
        }
        System.out.println(maxLMIAS);
        if(maxLMIAS==1)
            System.out.println(seuqence[0]);
        else{
            // We will be back tracking the elements
            // so we use a stack to print the elemetns
            // in their natural order
            Stack st = new Stack();
            st.add(seuqence[y]);
            st.add(seuqence[x]);
            maxLMIAS--;
            while(maxLMIAS>1){
                int k = previous[x][y];
                y=x;
                x=k;
                st.add(seuqence[k]);
                maxLMIAS--;
            }
            // Display the elements in the stack
            while(!st.empty())
                System.out.print(st.pop()+" ");
            System.out.println();
        }
    }

}
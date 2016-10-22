import java.util.Scanner;

/**
 * Given a string, find the rank of the string amongst its permutations sorted lexicographically
 * Assume that no characters are repeated
 * 
 * @author SujitS
 * 
 * @version 1.0
 * @since 2016-10-22
 */

public class SortedPermutationRank {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the string : ");
        final String input = sc.next();
        System.out.println("Rank of the given string is " + findRank(input));
    }
    
    /**
     * Function to find the rank of the given string
     * @param a String
     * @return rank of the string
     */
    private static int findRank(final String a) {
        int length = a.length();
        char[] charArray = new char[length];
        for(int i=0;i<length;i++)
            charArray[i]=a.charAt(i);
        return (int)(findCharRank(charArray,0)%1000003);
    }
    
    /**
     * Recursive Helper function to find the rank of the sub string specified by the index
     * @param a String
     * @param i start index
     * @return rank of the sub string
     */
    private static long findCharRank(char[] a,int i){
        long temp = 0;
        if(a.length-i==1)
            return 1;
        int minimum = 0;
        int currentAscii = (int)a[i];
        for(int x=i+1;x<a.length;x++){
            if((int)a[x]<currentAscii)
                minimum++;
        }
        if(minimum!=0)
            temp = minimum * fact(a.length-i-1);
        return temp + findCharRank(a,i+1);
    }
    
    /**
     * Function to find the factorial of a given number
     * @param n input
     * @return factorial of input
     */
    private static long fact(int n) {
        long temp1 = n;
        long result = 1;
        if(n%2==0) {
            for(int i=n-2;i>=0;i-=2) {
                result = (result * temp1)%1000003;
                temp1 = temp1 + i;
            }
        } else {
            for(int i=n-2;i>=1;i-=2) {
                result = (result * temp1)%1000003;
                temp1 = temp1 + i;
            }
            float xyz =(float) n/(float)2.0;
            int temp =(int) Math.ceil(xyz);
            result = (result*temp)%1000003;
        }
        return result;
    }
    
}

import java.util.Scanner;

/**
 * Given two strings check if they are anagrams or not
 * 
 * @author SujitS
 * 
 * @version 1.0
 * @since 2016-03-17
 */

public class Anagrams {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the string 1: ");
        final String s1 = sc.next();
        System.out.print("Enter the string 2: ");
        final String s2 = sc.next();
        if(checkAnagrams(s1,s2))
            System.out.println("The given strings are anagrams");
        else
            System.out.println("The given strings are not anagrams");
    }

    /**
     * Function to check if the given strings are anagrams are not
     * 
     * @param s1 String 1
     * @param s2 String 2
     * 
     * @return True  : If the given strings are anagrams
     *         False : If the given strings are not anagrams
     */
    private static boolean checkAnagrams(String s1, String s2) {
        // Assuming the input to be in ascii characters
		// If its extended ascii then we create an array of size 256
		// If its a unicode then there will be more than a million characters
		// In that case, using a hashmap would be more efficient than an array
		// Also assuming that the strigs are case sensitive
		// If its case insensitive, then before we start processing we just use toLowerCase() on both the strings
        int[] asciiArray = new int[128];
        if(s1.length()!=s2.length())
            return false;
        for(int i=0;i<s1.length();i++){
            asciiArray[(int)s1.charAt(i)]++;
            asciiArray[(int)s2.charAt(i)]--;
        }
        for(int i=0;i<128;i++){
            if(asciiArray[i]!=0)
                return false;
        }
        return true;
    }

}

/**
 * Sample input1:
 * !@#asdqaz
 * zaqasd#@!
 * 
 * Sample output1:
 * True
 * 
 * Sample input2:
 * asdf1234asdf
 * 1234asdf1234
 * 
 * Sample output2:
 * False
 */
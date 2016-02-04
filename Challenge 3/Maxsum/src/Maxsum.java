import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

class Solution {
    public int maxSubArray(final List<Integer> a) {
        int maxSum = 0;
        int sum = 0;
        int size = a.size();
		// sum contains our temporary sum of the current sub array
		// maxsum compares all the temporary sums and stores the maimum of it
		// This is similar to kadanes algorithm
        for(int i=0;i<size;i++)
        {
            sum += a.get(i);
            if(sum<0)
                sum = 0;
            if(maxSum<sum)
                maxSum = sum;
        }
        if(maxSum==0)
            maxSum = Collections.max(a);
        return maxSum;
    }
}

public class Maxsum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of elements in list : ");
        int n = sc.nextInt();
        ArrayList<Integer> input = new ArrayList<>(n);
        System.out.println("Enter the numbers seperated by space/new line");
        for(int i=0;i<n;i++)
            input.add(sc.nextInt());
        Solution sol = new Solution();
        System.out.println("The maximum sum in the sub array is "+sol.maxSubArray(input));
    }
}

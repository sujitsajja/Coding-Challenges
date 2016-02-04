import java.util.ArrayList;
import java.util.Scanner;

class Solution {
    public ArrayList<Integer> plusOne(ArrayList<Integer> a) {
        int size = a.size();
        ArrayList<Integer> result = new ArrayList<>(size);
        boolean carryFlag = true;
        for(int i=size-1;i>=0;i--)
        {
            int number = a.get(i);
            if (carryFlag)
            {
                number++;
                carryFlag = false;
                if(number<10)
                    a.set(i,number);
                else
                {
                    carryFlag = true;		// If the digit crosses 10, set the carry flag
                    a.set(i,0);
                    if(i==0){				// If it is the first position, then add an extra digit
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
        for(int i=0;i<size;i++)
        {
            int number = a.get(i);
            if(number!=0)
                carryFlag = false;
            if(!carryFlag)
                result.add(number);
        }
        return result;
    }
}

public class Plus1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of digits : ");
        int n = sc.nextInt();
        ArrayList<Integer> input = new ArrayList<>(n);
        System.out.println("Enter the digits starting from MSD seperated by space/new line");
        for(int i=0;i<n;i++)
            input.add(sc.nextInt());
        Solution sol = new Solution();
        System.out.println("The result is : "+sol.plusOne(input));
    }
}

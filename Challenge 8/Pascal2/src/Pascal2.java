import java.util.ArrayList;
import java.util.Scanner;

public class Pascal2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the row number in pascal triangle : ");
        int n = in.nextInt();
        System.out.println();
        System.out.println("The "+n+" row in pascal triangle is as follows : ");
        System.out.println(getRow(n));
    }
    private static ArrayList<Integer> getRow(int a) {
        ArrayList<Integer> Result = new ArrayList<>();
        for(int i=0;i<a+1;i++)
        {
            ArrayList<Integer> temp = new ArrayList<>(); // Stores the current row values
            temp.add(1);
            if(i==0)
                Result.add(1);
            else{
                if(i>0){
                    for(int j=1;j<i;j++)
                        temp.add(Result.get(j)+Result.get(j-1));
                }
                temp.add(1);
                Result.clear();					// Clear the previous row entries
                Result.addAll(temp);			// Transfer the contents of temp to result
            }
        }
        return Result;
    }
}
import java.util.ArrayList;
import java.util.Scanner;

public class Pascal1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the number of rows in pascal triangle : ");
        int n = in.nextInt();
        System.out.println();
        System.out.println("The pascal triangle is as follows : ");
        System.out.println(generate(n));
    }
    private static ArrayList<ArrayList<Integer>> generate(int a) {
        ArrayList<ArrayList<Integer>> Result = new ArrayList<>();
        for(int i=0;i<a;i++)
        {
            ArrayList<Integer> temp = new ArrayList<>();
            temp.add(1);
            if(i==0)
                Result.add(temp);
            else{
                if(i>0){
                    for(int j=0;j<i-1;j++)
                        temp.add(Result.get(i-1).get(j)+Result.get(i-1).get(j+1));
                }
                temp.add(1);
                Result.add(temp);
            }
        }
        return Result;
    }
}

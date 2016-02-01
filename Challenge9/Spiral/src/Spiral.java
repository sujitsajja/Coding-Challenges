import java.util.ArrayList;
import java.util.Scanner;

public class Spiral {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the number of rows : ");
        int n = in.nextInt();
        System.out.println();
        System.out.println("The spiral matrix is as follows : ");
        System.out.println(generateMatrix(n));
    }
    private static ArrayList<ArrayList<Integer>> generateMatrix(int a) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        for(int i=0;i<a;i++){
            ArrayList<Integer> temp = new ArrayList<>();
            for(int j=0;j<a;j++)
                temp.add(0);
            result.add(temp);
        }
        int top=0,bottom=a-1,left=0,right=a-1,dir=0;
        int num=1;
        while(top<=bottom&&left<=right)
        {
            switch(dir){
                case 0:
                    for(int i=left;i<=right;i++,num++)
                        result.get(top).set(i,num);
                    top++;
                    break;
                case 1:
                    for(int i=top;i<=bottom;i++,num++)
                        result.get(i).set(right,num);
                    right--;
                    break;
                case 2:
                    for(int i=right;i>=left;i--,num++)
                        result.get(bottom).set(i,num);
                    bottom--;
                    break;
                case 3:
                    for(int i=bottom;i>=top;i--,num++)
                        result.get(i).set(left,num);
                    left++;
                    break;
            }
            dir++;
            dir = dir%4;
        }
        return result;
    }
}
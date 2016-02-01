import java.util.ArrayList;
import java.util.Scanner;

public class Diagnol {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Number of rows in the array : ");
        int n = in.nextInt();
        System.out.println("Enter the elements in the matrix : ");
        ArrayList<ArrayList<Integer>> input = new ArrayList<>();
        for(int i=0;i<n;i++){
            ArrayList<Integer> temp = new ArrayList<>();
            for(int j=0;j<n;j++)
                temp.add(in.nextInt());
            input.add(temp);
        }
        System.out.println("The array of anti diagonals is as follows : ");
        System.out.println(diagonal(input));
    }
    private static ArrayList<ArrayList<Integer>> diagonal(ArrayList<ArrayList<Integer>> A) {
        int N = A.size();
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        for(int i=0;i<N;i++){
            ArrayList<Integer> temp = new ArrayList<>();
            for(int j=0;j<i+1;j++)
                temp.add(0);
            result.add(temp);
        }
        for(int i=N-2;i>=0;i--){
            ArrayList<Integer> temp = new ArrayList<>();
            for(int j=0;j<i+1;j++)
                temp.add(0);
            result.add(temp);
        }
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(i+j<N)
                    result.get(i+j).set(i,A.get(i).get(j));
                else
                    result.get(i+j).set(N-1-j,A.get(i).get(j));
            }
        }
        return result;
    }
}

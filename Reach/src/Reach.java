import java.util.ArrayList;
import java.util.Scanner;

class Solution {
    public int coverPoints(ArrayList<Integer> X, ArrayList<Integer> Y) {
        int x1,x2,y1,y2,xdiff,ydiff;
        int size = X.size();
        int finalSteps=0;
        if(size==1)
            return 0;
        for(int i=0;i<size-1;i++)
        {
            x1=X.get(i);
            y1=Y.get(i);
            x2=X.get(i+1);
            y2=Y.get(i+1);
            xdiff=Math.abs(x2-x1);
            ydiff=Math.abs(y2-y1);
			// Going Diagonally covers two steps at a time
			// we go diagonally untill we reach one or both the co-ordinates
			// then we move to the side untill we reach the other co-ordinate
            if(xdiff==0 || ydiff==0)
                finalSteps += xdiff+ydiff;
            else
            {
                if(xdiff<ydiff)
                    finalSteps += ydiff;
                else
                    finalSteps += xdiff;
            }
        }
        return finalSteps;
    }
}

public class Reach {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of co-ordinates : ");
        int n = sc.nextInt();
        ArrayList<Integer> x = new ArrayList<>(n);
        ArrayList<Integer> y = new ArrayList<>(n);
        for(int i=0;i<n;i++){
            System.out.print("Enter the "+(i+1)+" x co-ordinate : ");
            x.add(sc.nextInt());
            System.out.print("Enter the "+(i+1)+" y co-ordinate : ");
            y.add(sc.nextInt());
        }
        Solution sol = new Solution();
        System.out.println();
        System.out.println("Minimum number of steps taken are "+sol.coverPoints(x, y));
    }
}
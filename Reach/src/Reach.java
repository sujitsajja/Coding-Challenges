import java.util.ArrayList;
import java.util.Scanner;

/**
 * Given a sequence of points in an infinite 2D grid,
 * find the minimum number of steps in which you can achieve it
 * 
 * @author SujitS
 * 
 * @version 1.2
 * @since 2016-03-07
 */

public class Reach {

    /**
     * @param args Command line argument
     */
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
        System.out.println();
        System.out.println("Minimum number of steps taken are "+coverPoints(x, y));
    }

    /**
     * Function to find the minimum number of steps given
     * a sequence of 2D Co-ordinates
     * 
     * @param X X Co-ordinates
     * @param Y Y Co-ordinates
     * 
     * @return Minimum number of steps to travel through all the points in sequence
     */
    private static int coverPoints(ArrayList<Integer> X, ArrayList<Integer> Y) {
        int x1,x2,y1,y2,xdiff,ydiff;
        int size = X.size();
        int finalSteps=0;
        if(size==1)
            return 0;
        for(int i=0;i<size-1;i++){
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
            else{
                if(xdiff<ydiff)
                    finalSteps += ydiff;
                else
                    finalSteps += xdiff;
            }
        }
        return finalSteps;
    }

}

/**
 * Sample input:
 * 5
 * (1,1) ,(2,2) ,(3,3) ,(4,4) ,(5,10)
 * 
 * Sample output:
 * 9
 */
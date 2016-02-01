import java.util.ArrayList;
import java.util.Scanner;

public class Maxset {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Number of elements in the array : ");
        int n = in.nextInt();
        ArrayList<Integer> input = new ArrayList<>(n);
        System.out.println();
        System.out.println("Enter the elements in the array : ");
        for(int i=0;i<n;i++)
            input.add(in.nextInt());
        ArrayList<Integer> maxSubArray = maxset(input);
        if(maxSubArray.isEmpty())
            System.out.println("There are no positive elements in the given array");
        else
            System.out.println("The maximum sub array is "+maxSubArray);
    }
    private static ArrayList<Integer> maxset(ArrayList<Integer> a) {
        ArrayList<Integer> result = new ArrayList<>();
        int length = a.size();
        long maxSum=0;
        long currentSum=0;
        int finalLeft=-1, finalRight=-1, tempLeft=-1, tempRight=-1;
        for(int x=0;x<length;x++){
            if(a.get(x)>=0){
                if(tempLeft==-1)
                    tempLeft=x;
                tempRight = x;
                currentSum += a.get(x);
                if(currentSum>maxSum){
                    finalLeft = tempLeft;
                    finalRight = tempRight;
                    maxSum = currentSum;
                }
                else if(currentSum==maxSum){
                    int finalDiff = finalRight-finalLeft;
                    int tempDiff = tempRight-tempLeft;
                    if(tempDiff>finalDiff){
                        finalLeft = tempLeft;
                        finalRight = tempRight;
                    }
                }
            }
            else{
                currentSum = 0;
                tempLeft=-1;
                tempRight=-1;
            }
        }
        if(finalLeft!=-1){
            for(int i=finalLeft;i<finalRight+1;i++)
                result.add(a.get(i));
        }
        return result;
    }
}

import java.util.Scanner;


/**
 * To rotate an image represented as NxN matrix by 90 degrees
 * 
 * @author SujitS
 * 
 * @version 1.0
 * @since 2016-03-29
 */

public class ImageRotation {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of image : ");
        int n = sc.nextInt();
        int[][] image = new int[n][n];
        System.out.println("Enter the elements of image seperated by space/enter :");
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++)
                image[i][j] = sc.nextInt();
        }
        System.out.println("The image before rotation :");
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++)
                System.out.print(image[i][j]+" ");
            System.out.println();
        }
        rotateImage(image);
        System.out.println("The image after rotation :");
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++)
                System.out.print(image[i][j]+" ");
            System.out.println();
        }
    }

    private static void rotateImage(int[][] image) {
        int n = image.length;
        for(int i=0;i<n-1;i++){
            for(int j=0;j<n-i;j++){
                int temp = image[i][j];
                image[i][j] = image[n-j-1][n-i-1];
                image[n-j-1][n-i-1] = temp;
            }
        }
        for(int i=0;i<n/2;i++){
            for(int j=0;j<n;j++){
                int temp = image[i][j];
                image[i][j] = image[n-i-1][j];
                image[n-i-1][j] = temp;
            }
        }
    }

}
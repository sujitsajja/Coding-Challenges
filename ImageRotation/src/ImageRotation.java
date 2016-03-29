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

    /**
     * Function to rotate an image represented as NxN matrix
     * 
     * @param image NxN matrix to be rotated
     */
    private static void rotateImage(int[][] image) {
        int n = image.length;
        // We first reverse the matrix
        for(int i=0;i<n-1;i++){
            for(int j=0;j<n-i;j++)
                swap(image,i,j,n-j-1,n-i-1);
        }
        // we then invert the matrix
        for(int i=0;i<n/2;i++){
            for(int j=0;j<n;j++)
                swap(image,i,j,n-i-1,j);
        }
    }

    /**
     * Helper function to swap two elements in a matrix
     * 
     * @param image Matrix
     * @param x1 x co-ordinate of element 1
     * @param y1 y co-ordinate of element 1
     * @param x2 x co-ordinate of element 2
     * @param y2 y co-ordinate of element 2
     */
    private static void swap(int[][] image,int x1,int y1,int x2,int y2){
        int temp = image[x1][y1];
        image[x1][y1] = image[x2][y2];
        image[x2][y2] = temp;
    }
}
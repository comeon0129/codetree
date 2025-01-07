import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	
        int[][]arr2d_1 = new int[3][3];
        int[][]arr2d_2 = new int[3][3];
        
      
        
        for(int i=0; i<3; i++) {
        	for(int j=0; j<3; j++) {
    		   arr2d_1[i][j] = sc.nextInt();
    	    }
        }
        for(int i=0; i<3; i++) {
        	for(int j=0; j<3; j++) {
    		   arr2d_2[i][j] = sc.nextInt();
    	    }
        }
        for(int i=0; i<3; i++) {
        	for(int j=0; j<3; j++) {
        		System.out.print((arr2d_1[i][j]*arr2d_2[i][j])+" ");
        	}
        	System.out.println();
        }
        
        
        
        sc.close();
    }
}

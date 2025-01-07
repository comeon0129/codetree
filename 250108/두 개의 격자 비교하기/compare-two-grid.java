import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	
    	int n = sc.nextInt();
    	int m = sc.nextInt();
    	
        int[][]arr2d_1 = new int[n][m];
        int[][]arr2d_2 = new int[n][m];
        
      
        
        for(int i=0; i<n; i++) {
        	for(int j=0; j<m; j++) {
    		   arr2d_1[i][j] = sc.nextInt();
    	    }
        }
        for(int i=0; i<n; i++) {
        	for(int j=0; j<m; j++) {
    		   arr2d_2[i][j] = sc.nextInt();
    	    }
        }
        for(int i=0; i<n; i++) {
        	for(int j=0; j<m; j++) {
        		if(arr2d_1[i][j] != arr2d_2[i][j]) {
        			System.out.print(1+" ");
        		}
        		else
        			System.out.print(0+" ");
        	}
        	System.out.println();
        }
        
        
        
        sc.close();
    }
}
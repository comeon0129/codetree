import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	int n = sc.nextInt();
    	int m = sc.nextInt();
    	int[][] arr2d = new int[n][m];
    	int cnt =0;
    	
    	for(int i=0; i<n; i++) {
    		for(int j=0; j<m; j++) {
    			if(j % 2 ==0) {
    				arr2d[i][j] = i+j*n;
    			}
    			else {
    				arr2d[i][j] = (j+1)*n -i - 1;
    			}
    		}
    	}
    	
    	for(int i=0; i<n; i++) {
    		for(int j=0; j<m; j++) {
    			System.out.print(arr2d[i][j]+" ");
    		}
    		System.out.println();
    	}
    	

        sc.close();
    }
}

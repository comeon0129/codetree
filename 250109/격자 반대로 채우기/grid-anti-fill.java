import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	
    	int n = sc.nextInt();
    	
    	int[][]arr2d = new int[n][n];
    	int cnt = 1;
    	
    	for(int i=n-1; i>=0; i--) {
    		for(int j=n-1; j>=0; j--) {
    			if(i % 2 !=0) {
    				arr2d[n-1-j][i] = cnt;
    				cnt++;			
    			}
    			else {
    				arr2d[j][i] =cnt;
    				cnt++;
    			}
    		}
    	}

    	
    	
    	for(int i=0; i<n; i++) {
    		for(int j=0; j<n; j++) {
    			System.out.print(arr2d[i][j]+" ");
    		}
    		System.out.println();
    	}
    		
        sc.close();
    }
}
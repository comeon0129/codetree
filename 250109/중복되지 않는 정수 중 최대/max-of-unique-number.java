import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	int n = sc.nextInt();
    	int[] arr = new int[n];
    	int max = -1;
    	for (int i = 0; i < n; i++) {
    		arr[i] = sc.nextInt();
		}
    	Arrays.sort(arr);
    	for(int i=0; i<n; i++) {
    		if(i== 0) {
    			if(arr[i] != arr[i+1]) {
    				max = arr[i];
    			}
    		}
    		else if(i == n-1) {
    			if(arr[i] != arr[i-1]) {
    				max = arr[i];
    			}
    		}
    		else {
    			if(arr[i] != arr[i-1] && arr[i] !=arr[i+1] ) {
        			max = arr[i];
        		}
    		}
    	}
    	
    	if(max == -1) {
    		System.out.println(-1);
    	}
    	else
    		System.out.println(max);
    		
    		
        sc.close();
    }
}
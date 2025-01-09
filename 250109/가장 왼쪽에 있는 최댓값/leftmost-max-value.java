import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	int n = sc.nextInt();
    	int[] arr = new int[n];
    	for(int i=0; i<n; i++) {
    		arr[i]= sc.nextInt();
    	}
    	int max= -1;
    	int idx = n;
    	while(true) {
    		if(idx == 0) {
    			break;
    		}
    		max = -1;	
    		for(int i=n-1; i>=0; i--) {
        		if(arr[i] >= max) {
        			idx = i;
        			max = arr[i];
        		}
        	}
    		System.out.print((idx+1)+" ");
    		n = idx;
    	}
    	
    	
    	
    	
    		
        sc.close();
    }
}
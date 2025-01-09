import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	int n1 = sc.nextInt();
    	int n2 = sc.nextInt();
    	int[] a = new int[n1];
    	int[] b = new int[n2];
    	boolean flag = false;
    	int cnt =0;
    	for(int i=0; i<n1; i++) {
    		a[i] = sc.nextInt();
    	}
    	for(int i=0; i<n2; i++) {
    		b[i] = sc.nextInt();
    	}
    	for(int i=0; i<n1; i++) {
    		cnt =0;
    		if(a[i] == b[0]) {
    			for(int j=1; j<n2; j++) {
    				if(i+j >= n1)
    					break;
    				if(a[i+j] == b[j]) {
    					cnt++;
    				}
    			}
    			if(cnt == n2-1) {
    				flag = true;
    			}
    		}
    	}
    	
    	if(flag) {
    		System.out.println("Yes");
    	}
    	else
    		System.out.println("No");
    	
    	

        sc.close();
    }
}
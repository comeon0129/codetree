import java.util.Scanner;

public class Main {
	public static final int MAX_N = 100;
	
	public static int[] arr = new int[MAX_N+1]; 
	
	public static int calc(int a1, int a2) {
		int returnVal = 0;
		for(int i=a1; i<=a2; i++) {
			returnVal+=arr[i];
		}
		return returnVal;
	}
	
	public static void main (String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        for(int i=1; i<=n; i++) {
        	arr[i] = sc.nextInt();
        }
        for(int i=0; i<m; i++) {
        	int a1 = sc.nextInt();
        	int a2 = sc.nextInt();
        	System.out.println(calc(a1,a2));
        }
        
        
        sc.close();
    }
}

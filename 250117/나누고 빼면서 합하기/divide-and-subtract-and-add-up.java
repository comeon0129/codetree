import java.util.Scanner;

public class Main {
	
	public static int m,n;
	
	public static int[] arr = new int[100];
	
	public static int calc(int m) {
		int sum = 0;
		while(true) {
			sum+=arr[m-1];
			if(m==1) {
				return sum;
			}
			if(m % 2 == 0) {
				m/=2;
			}
			else {
				m-=1;
			}
		}
	}
	
	
	public static void main (String args[]) {
        Scanner sc = new Scanner(System.in);
       int ans =0 ;
       n = sc.nextInt();
       m = sc.nextInt();
       for(int i=0; i<n; i++) {
    	   arr[i] = sc.nextInt();
       }
       ans = calc(m);
       System.out.println(ans);
        sc.close();
    }
}

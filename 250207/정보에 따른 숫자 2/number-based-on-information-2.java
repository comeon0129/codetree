import java.util.Scanner;

public class Main {
	public static int t,a,b;
	
	public static int[] arr = new int[1001]; 
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		t = sc.nextInt();
		a = sc.nextInt();
		b = sc.nextInt();
		int special = 0;
		
		for(int i=0; i<t; i++) {
			char c = sc.next().charAt(0);
			int idx = sc.nextInt();
			if(c=='S') {
				arr[idx] = 1;  // S가 놓이는 위치에는 1이 들어감.
			}
			else
				arr[idx] = 2; // N이 놓이는 위치에는 2가 들어감.
		}
		
		for(int i=a; i<=b; i++) {
			int k= i;
			int d1 = Integer.MAX_VALUE;
			for(int j=1; j<=1000; j++) {
				if(arr[j] == 1) {
					d1=Math.min(d1, Math.abs(k-j));
				}
			}
			int d2 = Integer.MAX_VALUE;
			for(int j=1; j<=1000; j++) {
				if(arr[j] == 2) {
					d2=Math.min(d2, Math.abs(k-j));
				}
			}
			if(d1<=d2) {
				special++;
			}
		}
		System.out.println(special);
		
		sc.close();
    }
}
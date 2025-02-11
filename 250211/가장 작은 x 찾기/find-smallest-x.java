import java.util.Scanner;

public class Main {
	
	public static int n;
	
	public static int[] a = new int[10];
	public static int[] b = new int[10];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		for(int i=0; i<n; i++) {
			a[i] = sc.nextInt();
			b[i] = sc.nextInt();
		}
		int minX = Integer.MAX_VALUE;
		for(int x=1; x<=5000; x++) {
			
			int cnt = 0;
			for(int i = 0; i<n; i++) {
				double temp = x * Math.pow(2, i+1);
				int num = (int) temp;
				if(num >= a[i] && num <=b[i]) {
					cnt++;
				}
			}
			if(cnt == n) {
				minX = x;
				break;
			}
		}
		System.out.println(minX);
		
		
		
		
		sc.close();
    }
}
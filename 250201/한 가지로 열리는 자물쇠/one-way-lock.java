import java.util.Scanner;


public class Main {
	public static int n;
	public static int a,b,c;
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		int maxSum = n*n*n;
		a = sc.nextInt();
		b = sc.nextInt();
		c = sc.nextInt();
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=n; j++) {
				for(int k=1; k<=n; k++) {
					if(Math.abs(i-a)>2 && Math.abs(j-b)>2 && Math.abs(k-c) >2) {
						maxSum--;
					}
				}
			}
		}
		System.out.println(maxSum);
		sc.close();
    }
}

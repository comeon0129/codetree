import java.util.Scanner;


public class Main {
	
	
	public static void main(String[]args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int sum = 0;
		int cnt = 0;
//		int b = sc.nextInt();
		for(int i=1; i<=n; i++) {
			int num = sc.nextInt();
			sum+=num;
			cnt++;
		}
		System.out.print(sum+" ");
		System.out.printf("%.1f",(double)sum/cnt);

		sc.close();
	}
		
}
import java.util.Scanner;


public class Main {
	
	
	public static void main(String[]args) {
		Scanner sc = new Scanner(System.in);
		int m = sc.nextInt();
		int cnt =0;
		for(int i=1; i<=m; i++) {
			int n = sc.nextInt();
			
			while(n != 1) {
				if(n % 2 == 0) {
					n /=2;
					cnt++;
				}
				else {
					n = 3*n+1;
					cnt++;
				}
			}
			
			System.out.println(cnt);
			cnt = 0;
		}
			
		sc.close();
	}
		
}

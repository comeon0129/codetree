import java.util.Scanner;


public class Main {
	
	
	public static void main(String[]args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int cnt = 0;
		while (true) {
			if(n / 2 != 1) {
				n/=2;
				cnt++;
			}
			cnt++;
			break;
		}
		System.out.println(cnt);
		
		
		
		
		
		
		
		sc.close();
	}
		
}

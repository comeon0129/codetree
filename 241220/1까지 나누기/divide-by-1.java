import java.util.Scanner;


public class Main {
	
	
	public static void main(String[]args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
//		int b = sc.nextInt();
		int share = n;
		int cnt = 0;
		
		for(int i=1; i<=n; i++) {
			share /= i;
			cnt++;
			if(share <= 1) {
				System.out.println(cnt);
				break;
			}
		}
//		System.out.print(cnt);
	
		sc.close();
	}
		
}


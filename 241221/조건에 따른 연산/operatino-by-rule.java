import java.util.Scanner;


public class Main {
	
	
	public static void main(String[]args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int cnt = 0;
		while (true) {
			if(n >= 1000)
				break;
			if(n % 2 == 0) {
				n= 3*n+1;
				cnt++;
			}
			else {
				n= 2*n + 2;
				cnt++;
			}
		}
		System.out.println(cnt);
		
		sc.close();
	}
		
}




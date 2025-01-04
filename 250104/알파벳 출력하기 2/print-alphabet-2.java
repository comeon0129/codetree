import java.util.Scanner;


public class Main {
	
	
	public static void main(String[]args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();	
		int cnt = 65;
		
		for(int i=1; i<=n; i++) {
			for(int j=1; j<i; j++) {
				System.out.print("  ");
			}
			for(int j=1; j<=n-i+1; j++) {
				System.out.print((char)cnt+" ");
				cnt++;
				if(cnt=='Z'+1)
					cnt='A';
			}
			System.out.println();
		}
			
		sc.close();
	}
		
}

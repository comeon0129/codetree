import java.util.Scanner;


public class Main {
	
	
	public static void main(String[]args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
//		int m = sc.nextInt();
		for(int i=0; i<n; i++) {
			int cnt =0;
			for(int j=0; j<(n-i)*(n-i); j++) {
				System.out.print("*");
				cnt++;
				if(cnt == (n-i)) {
					System.out.print(" ");
					cnt = 0;
				}
			}
			System.out.println("");
		}
	
		
		sc.close();
	}
		
}


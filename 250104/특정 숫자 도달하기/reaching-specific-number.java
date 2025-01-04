import java.util.Scanner;


public class Main {
	
	
	public static void main(String[]args) {
		Scanner sc = new Scanner(System.in);
		int sum = 0;
		int cnt = 0;
		for(int i=0; i<10; i++) {
			int n = sc.nextInt();
			if(n>=250)
				break;
			sum+=n;
			cnt++;
		}
		System.out.print(sum+" ");
		System.out.printf("%.1f",(double)sum/cnt);
		sc.close();
	}
		
}



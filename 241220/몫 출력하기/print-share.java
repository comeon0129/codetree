import java.util.Scanner;


public class Main {
	
	
	public static void main(String[]args) {
		Scanner sc = new Scanner(System.in);
		int cnt =0;
		
		while(true) {
			int num = sc.nextInt();
			if (num % 2 != 0)
				continue;
			else {
				System.out.println(num / 2);
				cnt++;
				if(cnt == 3)
					break;
			}
				
		}
	
		sc.close();
	}
		
}

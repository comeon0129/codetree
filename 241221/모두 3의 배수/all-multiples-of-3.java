import java.util.Scanner;


public class Main {
	
	
	public static void main(String[]args) {
		Scanner sc = new Scanner(System.in);
//		int b = sc.nextInt();
		boolean flag = true;
		for(int i=1; i<=5; i++) {
			int n = sc.nextInt();
			if(n % 3 != 0)
				flag=false;
		}
		if(flag)
			System.out.println("1");
		else
			System.out.println("0");
		sc.close();
	}
		
}
import java.util.Scanner;


public class Main {
	
	
	public static void main(String[]args) {
		Scanner sc = new Scanner(System.in);
		int prod = 1;
//		int count = 0;
		
		int a = sc.nextInt();
		int b = sc.nextInt();
		
		for(int i=0; i<b; i++) {
			prod *=a;
		}
		System.out.print(prod);
	
		sc.close();
	}
		
}



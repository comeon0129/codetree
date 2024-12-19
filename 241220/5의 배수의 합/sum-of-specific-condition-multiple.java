import java.util.Scanner;


public class Main {
	
	
	public static void main(String[]args) {
		Scanner sc = new Scanner(System.in);
		int sum = 0;
//		int count = 0;
		
		int a = sc.nextInt();
		int b = sc.nextInt();
		
		if(a>b) {
			int temp = a;
			a= b;
			b= temp;
		}
		for(int i=a; i<=b; i++) {
			if(i%5 ==0) {
				sum+=i;
				
			}
		}
		System.out.print(sum);
		
		sc.close();
	}
		
}
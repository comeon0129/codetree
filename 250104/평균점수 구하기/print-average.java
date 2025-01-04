import java.util.Scanner;


public class Main {
	
	
	public static void main(String[]args) {
		Scanner sc = new Scanner(System.in);
		double sum = 0;
		for(int i=0; i<8; i++) {
			sum+= sc.nextDouble();
		}
		double mid = sum/8;
		System.out.printf("%.1f",mid);

		
		
		
		sc.close();
	}
		
}

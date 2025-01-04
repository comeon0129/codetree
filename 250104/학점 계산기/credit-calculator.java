import java.util.Scanner;


public class Main {
	
	
	public static void main(String[]args) {
		Scanner sc = new Scanner(System.in);
		double sum = 0;
		int n = sc.nextInt();
		for(int i=0; i<n; i++) {
			double score = sc.nextDouble();
			sum+=score;
		}
		double mid = sum/n;
		System.out.printf("%.1f",mid);
		System.out.println();
		if(mid>=4.0)
			System.out.println("Perfect");
		else if(mid>=3.0)
			System.out.println("Good");
		else
			System.out.println("Poor");
		
		
		
		sc.close();
	}
		
}
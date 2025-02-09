import java.util.Scanner;

public class Main {
	
	public static int a,b,c;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		a = sc.nextInt();
		b = sc.nextInt();
		c = sc.nextInt();
		
		int maxVal = 0;
		
		for(int i=0; i<=1000; i++) {
			int aSum = a * i;
			for(int j=0; j<=1000; j++) {
				int bSum = b * j;
				if((aSum+bSum) <= c) {
					maxVal = Math.max(maxVal, aSum+bSum);
				}
			}
		}
		System.out.println(maxVal);
		
		
		sc.close();
    }
}
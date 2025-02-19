import java.util.Scanner;

public class Main {
	
	public static int x;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		x = sc.nextInt();
		
		int t = 0;
		int sum = 0;
		int n = 1;
		while(sum != x) {
			sum += n;
			if(sum+((n+1)*(n+2)/2) <= x ) {
				n++;
			}
			else if(sum+(n*(n+1)/2) > x ) {
				n--;
			}
			t++;
		}
		
		System.out.println(t);
		
		sc.close();
    }
}
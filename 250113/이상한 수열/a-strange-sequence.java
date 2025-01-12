import java.util.Scanner;

public class Main {
	
	public static int calc(int n) {
		if(n==1) {
			return 1;
		}
		if(n==2) {
			return 2;
		}
		return calc(n/3) + calc(n-1);
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int ans = calc(n);
		System.out.println(ans);
	
		sc.close();
    }
}

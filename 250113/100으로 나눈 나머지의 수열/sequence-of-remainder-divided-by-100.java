import java.util.Scanner;

public class Main {
	
	public static int calc(int n) {
		if(n==1) {
			return 2;
		}
		if(n==2) {
			return 4;
		}
		return (calc(n-1) * calc(n-2)) % 100;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int ans = calc(n);
		System.out.println(ans);
	
		sc.close();
    }
}
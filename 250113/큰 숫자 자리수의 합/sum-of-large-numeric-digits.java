import java.util.Scanner;

public class Main {
	
	public static int calc(int n) {
		if(n<10) {
			return n;
		}
		return calc(n/10)+n%10;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a=sc.nextInt();
		int b=sc.nextInt();
		int c=sc.nextInt();
		int n = a*b*c;
		int ans = calc(n);
		System.out.println(ans);
	
		sc.close();
    }
}
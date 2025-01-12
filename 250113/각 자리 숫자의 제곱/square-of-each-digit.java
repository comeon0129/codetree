import java.util.Scanner;

public class Main {
	
	public static int sum (int n) {
		if(n<10)
			return n*n;
		return sum(n/10)+(n%10)*(n%10);
		
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n =sc.nextInt();
		int ans = sum(n);
		System.out.println(ans);
	
		sc.close();
    }
}
import java.util.Scanner;

public class Main {
	
	public static int fibonachi (int n) {
		if(n==1 || n==2)
			return 1;
		return fibonachi(n-1)+fibonachi(n-2);
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n =sc.nextInt();
		int ans = fibonachi(n);
		System.out.println(ans);
	
		sc.close();
    }
}
import java.util.Scanner;

public class Main {
	
	public static int min(int a, int b, int c) {
		int min = (a <= b) ? a : b;
		min = (min <= c) ? min : c;
		return min;
	}
	
	
	public static void main(String[]args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		System.out.println(min(a,b,c));
	}
}



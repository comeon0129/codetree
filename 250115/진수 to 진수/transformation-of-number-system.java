import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		String n = sc.next();
		int n2 = Integer.parseInt(n,a);
		String s = Integer.toString(n2, b);
		System.out.println(s);
		sc.close();
    }
}

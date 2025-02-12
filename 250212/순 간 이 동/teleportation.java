import java.util.Scanner;

public class Main {

	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		int x = sc.nextInt();
		int y = sc.nextInt();
		
		int dist1 = Math.abs(y-a)+Math.abs(b-x);
		int dist2 = Math.abs(x-a)+Math.abs(b-y);
		int ans = Math.min(dist1, dist2);
		System.out.println(ans);
		
		sc.close();
    }
}
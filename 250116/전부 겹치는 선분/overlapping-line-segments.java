import java.util.Scanner;

public class Main {
	
	public static int n;
	public static final int MAX_N = 100;
	public static int[] line = new int[MAX_N+1];
	
	public static boolean test(int[] line) {
		for(int i=1; i<line.length; i++) {
			if(line[i] == n) {
				return true;
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		for(int i=0; i<n; i++) {
			int x1 =sc.nextInt();
			int x2 =sc.nextInt();
			for(int j=x1; j<=x2; j++) {
				line[j] ++;
			}
		}
		
		if(test(line)) {
			System.out.println("Yes");
		}
		else
			System.out.println("No");
		
		sc.close();
    }
}

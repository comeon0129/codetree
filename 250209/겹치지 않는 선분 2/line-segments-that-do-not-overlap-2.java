import java.util.Scanner;

public class Main {
	public static int MAX_N = 100;
	
	public static int n;
	
	public static int[] x1 = new int[MAX_N];
	public static int[] x2 = new int[MAX_N];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		for(int i=0; i<n; i++) {
			x1[i] = sc.nextInt();
			x2[i] = sc.nextInt();
		}
		int ans = 0;
		for(int i=0; i<n; i++) {
			boolean intersect = true;
			for(int j=0; j<n; j++) {
				if(i==j)
					continue;
				if((x1[j] < x1[i] && x2[j] >x2[i])||(x1[j] > x1[i] && x2[j] < x2[i])) {
					intersect = false;
					break;
				}
			}
			if(intersect)
				ans++;
		}
		System.out.println(ans);
		
		
		sc.close();
    }
}

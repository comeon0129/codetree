import java.util.Scanner;

public class Main {
	
	public static final int MAX_N = 100;
	public static int n,k;
	
	public static int[] bomb = new int[MAX_N];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		k = sc.nextInt();
		for(int i=0; i<n; i++) {
			bomb[i] = sc.nextInt();
		}
		int maxNum= -1;
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(i == j)
					continue;
				if(bomb[i] == bomb[j] && Math.abs(i-j)<=k) {
					maxNum = Math.max(maxNum, bomb[i]);
				}
			}
		}
		System.out.println(maxNum);
		
		
		
		sc.close();
    }
}
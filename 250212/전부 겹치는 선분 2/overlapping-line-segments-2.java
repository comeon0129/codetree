import java.util.Scanner;

public class Main {
	
	public static int n;
	public static int[] x1 = new int[100];
	public static int[] x2 = new int[100];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n= sc.nextInt();
		for(int i=0; i<n; i++) {
			x1[i] = sc.nextInt();
			x2[i] = sc.nextInt();
		}
		boolean intersecting = false;
		for(int i=0; i<n; i++) {
			int[] cnt = new int[101];
			
			for(int j=0; j<n; j++) {
				if(i==j)
					continue;
				
				for(int k=x1[j]; k<=x2[j]; k++) {
					cnt[k]++;
				}
			}
			for(int j=1; j<cnt.length; j++) {
				if(cnt[j] == n-1) {
					intersecting = true;
				}
			}
		}
		
		if(intersecting)
			System.out.println("Yes");
		else
			System.out.println("No");
		
		
		sc.close();
    }
}
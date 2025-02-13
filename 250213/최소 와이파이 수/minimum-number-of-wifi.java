import java.util.Scanner;

public class Main {
	
	public static int n,m;
	
	public static int[] village = new int[100];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		for(int i=0; i<n; i++) {
			village[i] = sc.nextInt();
		}
		
		int ans = 0;
		for(int i=0; i<n; i++) {
			if(village[i] == 1) {
				ans++;
				int lastIdx = i+2*m;
				if(lastIdx >=n) {
					lastIdx =  n-1;
				}
				for(int j=i; j<=lastIdx; j++) {
					village[j] = 0;
				}
			}
		}
		System.out.println(ans);
		
		
		sc.close();
    }
}
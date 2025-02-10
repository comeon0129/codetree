import java.util.Scanner;

public class Main {
	
	public static final int MAX_N = 20;
	public static int n;
	public static char[] seat = new char[MAX_N];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		String s = sc.next();
		seat = s.toCharArray();
		
		int ans = 1;
		for(int i=0; i<n; i++) {
			if(seat[i] == '1')
				continue;
			seat[i] = '1';
			int minInterval = Integer.MAX_VALUE;
			for(int j=0; j<n; j++) {
				int curInterval = 1;
				if(seat[j] == '1') {
					for(int k=j+1; k<n; k++) {
						if(seat[k] == '1') {
							minInterval = Math.min(minInterval, curInterval);
							break;
						}
						curInterval++;
					}
					
				}
			}
			ans = Math.max(ans, minInterval);
			seat[i] = '0';
		}
		System.out.println(ans);		
		
		
		sc.close();
    }
}
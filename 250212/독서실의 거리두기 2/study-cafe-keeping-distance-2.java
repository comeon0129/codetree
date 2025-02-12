import java.util.Scanner;

public class Main {
	public static int n;
		
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		String s = sc.next();
		char[] seats = s.toCharArray();
		
		
		int maxMinDist = 0;
		for(int i=0; i<n; i++) {
			if(seats[i] =='1') {
				continue;
			}
			seats[i] = '1';
			int minDist = Integer.MAX_VALUE;
			for(int j=0; j<n; j++) {
				for(int k=j+1; k<n; k++) {
					if(seats[j] == '1' && seats[k] == '1') {
						int dist = k-j;
						minDist = Math.min(minDist, dist);
						break;
					}
				}
			}
			maxMinDist = Math.max(maxMinDist, minDist);
			seats[i] = '0';
		}
		System.out.println(maxMinDist);
		sc.close();
    }
}
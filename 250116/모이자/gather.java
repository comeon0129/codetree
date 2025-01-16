import java.util.Scanner;

public class Main {
	
	public static final int INT_MAX = Integer.MAX_VALUE;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] house = new int[n];
		for(int i=0; i<n; i++) {
			house[i] = sc.nextInt();
		}
		
		int minSum = INT_MAX;
		for(int i=0; i<n; i++) {
			int cur = i;
			int curDistance = 0;
			for(int j=0; j<n; j++) {
				curDistance+= house[j]*Math.abs(j-cur);
			}
			if(curDistance < minSum ) {
				minSum = curDistance;
			}
		}
		System.out.println(minSum);
				
		sc.close();
    }
}
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	
	public static int n;
	public static int[] x1 = new  int[101];
	public static int[] x2 = new  int[101];
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		for(int i=0; i<n; i++) {
			x1[i] = sc.nextInt();
			x2[i] = sc.nextInt();
		}
		int minLength = Integer.MAX_VALUE;
		
		for(int i=0; i<n; i++) {
			int[] cur_x1 = new int[n];
			int[] cur_x2 = new int[n];
			for(int j=0; j<n; j++) {
				if(i==j)
					continue;
				cur_x1 [j] = x1[j];
				cur_x2 [j] = x2[j];
				
			}
			Arrays.sort(cur_x1);
			Arrays.sort(cur_x2);
			
			int left = cur_x1[1];  //0이 하나 있을것이기에 제외
			int right = cur_x2[n-1];
			minLength = Math.min(minLength, right-left);
		}
		
		System.out.println(minLength);
			
		sc.close();
    }
}
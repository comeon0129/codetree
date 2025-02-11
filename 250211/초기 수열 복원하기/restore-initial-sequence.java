import java.util.Scanner;
import java.util.Arrays;

public class Main {
	public static final int MAX_N = 1000;
	
	public static int n;
	public static int[] a = new int[MAX_N];
	
	public static int[] aSum = new int[MAX_N-1];
	
	public static boolean isEqualArray(int[] potential) {
		Arrays.sort(potential);
		for(int i=0; i<n; i++) {
			if(a[i] != potential[i])
				return false;
		}
		return true;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		for(int i=0; i<n; i++) {
			a[i] = i+1;
		}
		for(int i=0; i<n-1; i++) {
			aSum[i] = sc.nextInt();
		}
	
		for(int i=1; i<=n; i++) { //첫번째 원소 특정하기
			int[] potential = new int[n];
			potential[0] = i;
			for(int j=1; j<n; j++) {
				potential[j] = aSum[j-1]-potential[j-1];
			}
			if(isEqualArray(potential.clone())) {
				for(int j=0; j<n; j++) {
					System.out.print(potential[j]+" ");
				}
				break;
			}
		}
		
		sc.close();
    }
}
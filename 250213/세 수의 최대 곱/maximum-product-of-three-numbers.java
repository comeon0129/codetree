import java.util.Arrays;
import java.util.Scanner;

public class Main {
	
	public static final int MAX_N = 100000;
	public static int n;
	
	public static int[] numbers = new int[MAX_N];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		for(int i=0; i<n; i++) {
			numbers[i] =sc.nextInt();
		}
		Arrays.sort(numbers,0,n);
	
		int maxMult1 = numbers[n-1] * numbers[n-2] * numbers[n-3]; //정렬했을때 가장 큰거 3개 곱하는경우 -> 양수3개, 음수3개
		int maxMult2 = numbers[0] * numbers[1] * numbers[n-1]; //정렬했을때 가장 작은거 2개, 가장큰거 1개 곱하는경우
		
		int ans = Math.max(maxMult1, maxMult2);
		System.out.println(ans);
		sc.close();
    }
}
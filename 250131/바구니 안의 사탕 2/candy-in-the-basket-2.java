import java.util.Scanner;


public class Main {
	public static int n,k;
	
	public static int[] basket = new int[101];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		k = sc.nextInt();
		for (int i = 0; i < n; i++) {
			int candy = sc.nextInt();
			int pos = sc.nextInt();
			basket[pos] = candy;
		}
		int max = Integer.MIN_VALUE;
		for(int i=0; i<=100-2*k; i++) {
			int c = k+i;
			int candy_sum = 0;
			for(int j =c-k; j<=c+k; j++) {
				candy_sum += basket[j];
			}
			max = Math.max(max, candy_sum);
		}
		System.out.println(max);
		sc.close();
    }
}

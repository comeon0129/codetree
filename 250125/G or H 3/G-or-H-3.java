import java.util.Scanner;


public class Main {
	public static final int MAX_N = 10000;
	public static int n,k;
	public static int[] score = new int [MAX_N+1];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		k = sc.nextInt();
		for(int i=0; i<n; i++) {
			int pos = sc.nextInt();
			char c = sc.next().charAt(0);
			if(c == 'G') {
				score[pos] = 1;
			}
			else if(c== 'H') {
				score[pos] = 2;
			}
		}
		int max = Integer.MIN_VALUE;
		for(int i=1; i<=score.length-k-1; i++) {
			int curNum =0;
			for(int j=i; j<=i+k; j++) {
				curNum += score[j];
			}
			max = Math.max(max, curNum);
		}
		System.out.println(max);
		
		
		
		sc.close();
    }
}

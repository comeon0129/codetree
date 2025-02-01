import java.util.Scanner;


public class Main {
	public static int[] develop = new int[6];
	
	public static int getDiff(int i, int j, int k) {
		int sum1 =0;
		for(int l=0; l<6; l++) {
			sum1 += develop[l];
		}
		sum1 -= i+j+k;
		int sum2 = i+j+k;
		return Math.abs(sum1-sum2);
		
	}
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for(int i=0; i<6; i++) {
			develop[i] = sc.nextInt();
		}
		int min = Integer.MAX_VALUE;
		for(int i=0; i<6; i++) {
			for(int j=i+1; j<6; j++) {
				for(int k=j+1; k<6; k++) {
					int diff = getDiff(develop[i],develop[j],develop[k]);
					min = Math.min(min, diff);
				}
			}
		}
		System.out.println(min);
		
		sc.close();
    }
}

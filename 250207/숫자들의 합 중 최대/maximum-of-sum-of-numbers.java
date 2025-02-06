import java.util.Scanner;

public class Main {
	
	public static int x,y;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		x = sc.nextInt();
		y = sc.nextInt();
		
		int maxSum = Integer.MIN_VALUE;
		
		for(int i=x; i<=y; i++) {
			int curSum =0; // 현재 i 숫자 하나에 각자리 숫자 합
			if(i<10) {
				curSum = i;
			}
			else if(i>=10 && i<100) {
				curSum = (i/10) + (i%10);
			}
			else if(i>=100 && i<1000) {
				curSum = (i/100)+((i%100)/10)+(i%10); 
				
			}
			else if(i>=1000 && i<10000) {
				curSum = (i/1000)+((i%1000)/100)+((i%100)/10)+(i%10);
			}
			else
				curSum = 1;
			maxSum = Math.max(maxSum, curSum);
		}
		System.out.println(maxSum);
		sc.close();
    }
}
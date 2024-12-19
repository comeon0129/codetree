import java.util.Scanner;


public class Main {
	
	
	public static void main(String[]args) {
		Scanner sc = new Scanner(System.in);
		int cnt_three = 0;
		int cnt_five = 0;
		for(int i=0; i<10; i++) {
			int num = sc.nextInt();
			if(num % 3 ==0)
				cnt_three++;
			if(num % 5 ==0)
				cnt_five++;
		}
		System.out.println(cnt_three+" "+cnt_five);
		
		
	}
		
}

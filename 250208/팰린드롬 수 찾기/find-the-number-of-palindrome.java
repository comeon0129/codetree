import java.util.Scanner;

public class Main {

	public static int x,y;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		x= sc.nextInt();
		y = sc.nextInt();
		int ans = 0;
		for(int i=x; i<=y; i++) {
			String number = Integer.toString(i);
			int len = number.length();
			int pelin = len/2;
			int cnt = 0;
			for(int j=0; j<len/2; j++) {
				if(number.charAt(j) == number.charAt(len-1-j)) {
					cnt++;
				}
			}
			if(pelin == cnt) {
				ans++;
			}
		}
		System.out.println(ans);
		sc.close();
    }
}

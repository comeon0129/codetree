import java.util.Scanner;

public class Main {
	public static int x,y;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		x= sc.nextInt();
		y= sc.nextInt();
		int ans = 0;
		for(int i=x; i<=y; i++) {
			String number = Integer.toString(i);
			int cnt =0;
			for(int j=1; j<number.length(); j++) {
				if(number.charAt(0) != number.charAt(j)) {
					cnt++;
				}
			}
			//한자리만 다른 경우이거나 아니면 맨 앞자리혼자만 다른 경우인 경우
			if(cnt == 1) { 
				ans++;
			}
			else if(cnt == number.length()-1) {
				boolean flag = true;
				for(int j=2; j<number.length(); j++) {
					if(number.charAt(j)!=number.charAt(j-1)) {
						flag = false;
					}
				}
				if(flag) {
					ans++;
				}
			}
			
		}
		System.out.println(ans);
		sc.close();
    }
}

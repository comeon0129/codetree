import java.util.Scanner;

public class Main {
		
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		
		int cnt = 0;
		while(true) {
			if(b==a+1 && c==b+1) {
				break;
			}
			int term1 = b-a; //왼쪽 구간의 길이
			int term2 = c-b; //오른쪽 구간의 길이
			if(term1 >= term2) { // 왼쪽이 더 넓은 경우
				c=b;
				b--;
			}
			else { // 오른쪽이 더 넓은 경우
				a=b;
				b++;
			}
			cnt++;
		}
		System.out.println(cnt);
		
		sc.close();
    }
}
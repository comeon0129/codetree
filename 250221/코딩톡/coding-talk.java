import java.util.Scanner;

public class Main {
	public static int n,m,p;
	
	public static char[] c = new char[101];
	public static int[] u = new int[101];
	
	public static int[] readUser = new int[26];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		p = sc.nextInt();
		for(int i=1; i<=m; i++) {
			c[i] = sc.next().charAt(0); //문자 보낸 사람
			u[i] = sc.nextInt(); // 최종적으로 받지 않은 인원 수
		}
		for(int i=p; i<=m; i++) {  // p번째 포함 그 이후에 나온 사람들은 메시지를 확실하게 읽은 사람임.
			readUser[c[i]-'A'] = 1;
		}
		
		if(u[p-1] == u[p]) { // p 바로 이전 사람과 최종적으로 받지 않은 인원 수가 같으면 서로 메시지를 주고받은것이므로 확실하게 읽은 사람임.
			readUser[c[p-1]-'A'] = 1;
		}
		
		for(int i=0; i<n; i++) {
			if(readUser[i] == 0)
				System.out.print((char)(i+'A')+" ");
		}
		
		sc.close();
    }
}

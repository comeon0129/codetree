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
		if(u[p] == 0) {
			System.out.println("");
			System.exit(0);
		}
		
		for(int i=p; i<=m; i++) {  // p번째 포함 그 이후에 나온 사람들은 메시지를 확실하게 읽은 사람임.
			readUser[c[i]-'A'] = 1;
		}
		for(int i=p-1; i>=1; i--) { //p번째 사람과 읽은 명수가 같다는 것은 서로 메시지를 읽어줬다는 뜻이기에 확실하게 읽은 사람임.
			if(u[p] == u[i])
				readUser[c[i]-'A']=1;
		}
		
		for(int i=0; i<n; i++) {
			if(readUser[i] == 0)
				System.out.print((char)(i+'A')+" ");
		}
		
		sc.close();
    }
}
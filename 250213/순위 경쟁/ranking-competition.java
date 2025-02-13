import java.util.Scanner;

public class Main {
	public static final int MAX_N = 100;
	
	public static int n ;
	
	public static int[] a = new int[MAX_N+1];
	public static int[] b = new int[MAX_N+1];
	public static int[] c = new int[MAX_N+1];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		for(int i=1; i<=n; i++) {
			char t = sc.next().charAt(0);
			int s = sc.nextInt();
			
			if(t == 'A') {
				a[i] = a[i-1]+s;
				b[i] = b[i-1];
				c[i] = c[i-1];
			}
			else if(t == 'B') {
				a[i] = a[i-1];
				b[i] = b[i-1]+s;
				c[i] = c[i-1];
			}
			else {
				a[i] = a[i-1];
				b[i] = b[i-1];
				c[i] = c[i-1]+s;
			}
		}
		int cnt = 0;
		
		//명예의 전당 조합 
		//leader ==0 -> a,b,c 모두 명전
		//leader ==1 -> a
		//leader ==2 -> b
		//leader ==3 -> c
		//leader ==4 -> a,b
		//leader ==5 -> b,c
		//leader ==6 -> a,c
		
		int leader =0;
		for(int i=1; i<=n; i++) {
			if(leader != 0 && (a[i] == b[i])&& (b[i] == c[i])) {
				cnt++;
				leader = 0;
			}
			else if(leader != 1 && (a[i] > b[i]) && (a[i] > c[i]) ){
				cnt++;
				leader = 1;
			}
			else if(leader != 2 && (b[i] > a[i]) && (b[i] > c[i]) ){
				cnt++;
				leader = 2;
			}
			else if(leader != 3 && (c[i] > a[i]) && (c[i] > b[i]) ){
				cnt++;
				leader = 3;
			}
			else if(leader != 4 && (a[i] == b[i]) && (a[i] > c[i]) ){
				cnt++;
				leader = 4;
			}
			else if(leader != 5 && (b[i] == c[i]) && (b[i] > a[i]) ){
				cnt++;
				leader = 5;
			}
			else if(leader != 6 && (a[i] == c[i]) && (a[i] > b[i]) ){
				cnt++;
				leader = 6;
			}
		}
		System.out.println(cnt);
		sc.close();
    }
}
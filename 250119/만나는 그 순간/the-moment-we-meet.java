import java.util.Scanner;


public class Main {

	static final int MAX_N = 1000000;
	
	static int[] a = new int[MAX_N+1];
	static int[] b = new int[MAX_N+1];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int a_idx = 1;
		int b_idx = 1;
		for(int i=0; i<n; i++) {
			char c = sc.next().charAt(0);
			int dist = sc.nextInt();
			for(int j=0; j<dist; j++) {
				if(c == 'R') {
					a[a_idx] = a[a_idx-1]+1;
					a_idx++;
				}
				else if(c=='L') {
					a[a_idx] = a[a_idx-1]-1;
					a_idx++;
				}
			}
		}

		for(int i=0; i<m; i++) {
			char c = sc.next().charAt(0);
			int dist = sc.nextInt();
			for(int j=0; j<dist; j++) {
				if(c == 'R') {
					b[b_idx] = b[b_idx-1]+1;
					b_idx++;
				}
				else if(c=='L') {
					b[b_idx] = b[b_idx-1]-1;
					b_idx++;
				}
			}
		}
		
		for(int i=1; i<=MAX_N; i++) {
			if(a[i] == b[i]) {
				System.out.println(i);
				break;
			}
		}
		
		sc.close();
    }
}

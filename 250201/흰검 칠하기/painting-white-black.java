import java.util.Scanner;


public class Main {
	public static final int MAX_N = 200000;
	public static int[] arr = new int[MAX_N+1];
	public static int[] w_cnt = new int[MAX_N+1];
	public static int[] b_cnt = new int[MAX_N+1];
	
	public static int white = 0, black = 0, gray = 0;
	
	public static int n;
	//흰색이 1, 검은색이 2, 회색이 3
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		int start = 100000;
		int end;
		for(int i=0; i<n; i++) {
			int x = sc.nextInt();
			char c = sc.next().charAt(0);
			
			if(c == 'L') {
				end = start - x + 1;
				for(int j= start; j>=end; j--) {
					w_cnt[j] ++;
					if(w_cnt[j] >=2 && b_cnt[j] >=2) {
						arr[j] = 3;
					}
					else {
						arr[j] = 1;
					}
				}
				start = end;
			}
			
			else if(c == 'R') {
				end = start + x - 1 ;
				for(int j= start; j<=end; j++) {
					b_cnt[j] ++;
					if(w_cnt[j] >=2 && b_cnt[j] >=2) {
						arr[j] = 3;
					}
					else {
						arr[j] = 2;
					}
					
				}
				start = end;
			}
		}
		for(int i=0; i<arr.length; i++) {
			if(arr[i] == 1) {
				white++;
			}
			else if(arr[i] == 2) {
				black++;
			}
			else if(arr[i] == 3) {
				gray ++;
			}
		}
		
		System.out.println(white+" "+black+" "+gray);
		
		
		sc.close();
    }
}

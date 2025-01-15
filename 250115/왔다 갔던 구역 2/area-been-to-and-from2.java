import java.util.Scanner;

public class Main {
	
	public static int MAX_L = 2001;
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] line = new int[MAX_L];
		
		int start = 1000;
		int end = 0;
		for(int i=0; i<n; i++) {
			int x = sc.nextInt();
			char c = sc.next().charAt(0);
			if(c == 'L') {
				end = start - x;
				for(int j=end; j<start; j++) {
					line[j]++;
				}
				start = end;
			}
			else if(c == 'R') {
				end = start + x;
				for(int j=start; j<end; j++) {
					line[j]++;
				}
				start = end;
			}
		}
		
		int cnt =0;
		for(int i=0; i<line.length; i++) {
			if(line[i] >=2) {
				cnt++;
			}
		}
		
		
		System.out.println(cnt);
		
		sc.close();
    }
}
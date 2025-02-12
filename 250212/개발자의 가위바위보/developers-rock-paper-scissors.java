import java.util.Scanner;

public class Main {
	public static final int MAX_N =100;
	
	public static int n;
	
	public static int[] first = new int[MAX_N];
	public static int[] second = new int[MAX_N];
		
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for(int i=0; i<n; i++) {
			first[i] = sc.nextInt();
			second[i] = sc.nextInt();
		}
		int maxWin = 0;
		for(int i=1; i<=3; i++) {
			for(int j=1; j<=3; j++) {
				int win = 0;
				if(i ==j)
					continue;
				for(int k=0; k<n; k++) {
					if(first[k] == i && second[k] == j ) {
						win++;
					}
					else if(first[k] !=i && first[k] !=j && second[k] == i) {
						win++;
					}
					else if(first[k] == j && second[k] !=i &&second[k] !=j) {
						win++;
					}
				}
				maxWin = Math.max(maxWin, win);
			}
		}
		System.out.println(maxWin);
		
		sc.close();
    }
}
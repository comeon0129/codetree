import java.util.Scanner;

public class Main {
	
	public static int n;
	
	public static int[] pos = new int[101];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		for(int i=0; i<n; i++) {
			int x = sc.nextInt();
			char c = sc.next().charAt(0);
			if(c == 'G')
				pos[x] = 1;
			else
				pos[x] = 2;
		}
		int ans = 0;
		for(int i=0; i<=100; i++) {
			if(pos[i] == 1 || pos[i] == 2) {
				int pic1 = 0;
				int pic2 = 0;
				int cntG = 0;
				int cntH = 0;
				for(int j=i; j<=100; j++) {
					if(pos[j] != 1 && pos[j] != 2)
						continue;
					if(pos[j] == 1)
						cntG++;
					else if(pos[j] == 2)
						cntH++;
					if((cntG > 0 && cntH == 0) || (cntG ==0 && cntH >0)) {
						pic1 = j-i;
					}
					if(cntG == cntH) {
						pic2 = j-i;
					}
				}
				ans = Math.max(ans, Math.max(pic1, pic2));
			}
		}
		System.out.println(ans);
		
		sc.close();
    }
}
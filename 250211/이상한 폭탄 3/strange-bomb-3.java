import java.util.Scanner;

public class Main {
	
	public static int n,k;
	
	public static int[] bomb = new int[100]; // 폭탄에 주어진 초기 번호들 -> 0이 되면 터진것이다.
	
	public static int[] cnt = new int[1000001];
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		k = sc.nextInt();
		for(int i=0; i<n; i++) {
			bomb[i] = sc.nextInt();  
		}
		
		for(int i=0; i<n; i++) {
			boolean isExplode = false;
			for(int j=i+1; j<n; j++) {
				if(bomb[i] != -1 && bomb[i] == bomb[j] && j-i <=k) { // 한번도 터진적 없고 같은 번호를 가진 폭탄이 존재하며 그 거리가 k 이내인경우
					cnt[bomb[j]]++;
					bomb[j] = -1;
					isExplode = true;
				}
			}
			if(isExplode) {
				cnt[bomb[i]]++;
				bomb[i] = -1;
			}
		}
	
		int maxCnt =0;
		int ans = 0;
		for(int i=0; i<cnt.length; i++) {
			int temp = cnt[i];
			if(temp>=maxCnt && temp != 0) {
				maxCnt = temp;
				ans = i;
			}
		}
		System.out.println(ans);
		
		sc.close();
    }
}
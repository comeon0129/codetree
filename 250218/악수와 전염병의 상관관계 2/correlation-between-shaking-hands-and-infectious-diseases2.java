import java.util.Scanner;


public class Main {
	public static final int MAX_T = 250;
	public static final int MAX_N = 100;
	
	public static int n,k,p,t;
	
	public static int[] time = new int[MAX_T];
	
	public static int[] shaker1 = new int[MAX_T];
	public static int[] shaker2 = new int[MAX_T];
	
	public static int[] isZombie = new int[MAX_N+1];
	
	public static int[] infectCnt = new int[MAX_N+1];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt(); //개발자 명수
		k = sc.nextInt(); //감염된 개발자가 최대 감염을 옮길 수 있는 횟수
		p = sc.nextInt(); //최초 감염된 개발자 번호
		t = sc.nextInt(); //악수 횟수
		
		for(int i=0; i<t; i++) {
			time[i] = sc.nextInt();
			shaker1[i] = sc.nextInt();
			shaker2[i] = sc.nextInt();
		}
		
		for(int i=1; i<=n; i++) {
			infectCnt[i] = k;  //최대 감염시킬 수 있는 초기값 넣어주기
		}
		
		
		isZombie[p] = 1; //이미 감염된 좀비
		for(int i=1; i<=250; i++) {
			for(int j=0; j<t; j++) {
				if(time[j] == i) {
					
					//두 사람이 서로를 감염시키는 경우
					if(isZombie[shaker1[j]] == 1 && isZombie[shaker2[j]] == 1 && infectCnt[shaker1[j]] >0 && infectCnt[shaker2[j]] >0) {
						infectCnt[shaker1[j]]--;
						infectCnt[shaker2[j]]--;
					}
					else if(isZombie[shaker1[j]] == 1 && infectCnt[shaker1[j]] > 0) { //1번이 2번을 감염시키는 경우
						isZombie[shaker2[j]] = 1; //2번 악수자 감염시키기
						infectCnt[shaker1[j]]--; //앞으로 감염시킬 수 있는 횟수 줄이기
					}
					else if(isZombie[shaker2[j]] == 1 && infectCnt[shaker2[j]] > 0) { //2번이 1번을 감염시키는 경우
						isZombie[shaker1[j]] = 1;
						infectCnt[shaker2[j]]--;
					}
				}
			}
		}
		
		for(int i=1; i<=n; i++) {
			System.out.print(isZombie[i]);
		}
		
		sc.close();
    }
}
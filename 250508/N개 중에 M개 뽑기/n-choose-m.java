import java.util.Scanner;

public class Main {
	public static int n,m;
	
	public static int[] selected = new int [11];
	
	public static void printAnswer() {
		for(int i=1; i<=n; i++) {
			if(selected[i] ==1)
				System.out.print(i+" ");
		}
		System.out.println();
	}
	
	public static void choose(int curNum, int cnt) { //curNum : 재귀 단계의 깊이 cnt: 선택한 숫자의 개수
		if(cnt == m) {
			printAnswer();
			return;
		}
			
		if(curNum == n+1)
			return;
		
		
		selected[curNum] = 1; // 해당 숫자를 선택하는 경우 재귀 호출
		choose(curNum+1,cnt+1);
		
		selected[curNum] = 0; // 해당 숫자를 선택하지 않는 경우 재귀 호출
		choose(curNum+1,cnt);
			
	}
	
	public static void main (String args[]) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        
        choose(1,0);
        
       
        sc.close();
    }
}
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	
	public static int n,m,k; // n: 턴의 개수 m: 윷놀이 판 길이 k: 말의 수
	
	public static int maxScore = 0;
	
	public static ArrayList<Integer> nums = new ArrayList<>();
	
	public static ArrayList<Integer> seq = new ArrayList<>();

	public static int calcScore(int[] scoreBoard) {
		int score = 0;
		for(int i=1; i<=k; i++) {
			if(scoreBoard[i]>=m-1)
				score++;
		}
		return score;
	}
	
	public static void move() {
		int[] scoreBoard = new int[k+1];
		for(int i=0; i<seq.size(); i++) {
			int number = seq.get(i);
			scoreBoard[number]+=nums.get(i);
		}
		maxScore = Math.max(maxScore, calcScore(scoreBoard));
		
	}
	
	public static void choose(int curNum) {
		if(curNum == n) {
			move();
			return;
		}
		
		for(int i=1; i<=k; i++) {
			seq.add(i);
			choose(curNum+1);
			seq.remove(seq.size()-1);
		}
		return;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		k = sc.nextInt();
		
		
		for(int i=0; i<n; i++) {
			nums.add(sc.nextInt());
		}
		
		choose(0);
		
		System.out.println(maxScore);
		sc.close();
	}
}

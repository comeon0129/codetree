import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	public static int n; //수열의 길이
	
	public static ArrayList<Integer> answer = new ArrayList<>();
	
	public static void printAnswer() {
		for(int i=1; i<answer.size(); i++) {
			System.out.print(answer.get(i));
		}
		return;
	}
	
	public static boolean isPossible(int curNum) {
		
		for(int len= 1; len <= curNum/2; len++) {
			boolean curCheck = true;
			
			for(int i=curNum- len*2 + 1; i< curNum-len+1; i++) {
				if(answer.get(i) != answer.get(i+len)) {
					curCheck = false;
					break;
				}
			}
			
			if(curCheck) // 여전히 true인경우 즉 특정 길이에 대해 인접한 부분 수열이 동일한 경우
				return false;
		}
		return true;
	}
	
	
	//curNum번째 위치에 4또는 5또는 6을 뽑는 함수	
	public static void makeSequence(int curNum) {
		if(curNum == n+1) {
			printAnswer();
			System.exit(0);
		}
		
		for(int i=4; i<=6; i++) {
			answer.add(i);
			
			if(isPossible(curNum)) { //가능한 수열인지 검사
				makeSequence(curNum+1);
			}
			
			answer.remove(answer.size()-1);
			
		}
	}
	
	public static void main(String[] args)  {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		answer.add(-1); //헷갈리지 않게 하기 위해 answer를 인덱스 1부터 시작하게 하기 위함.
		makeSequence(1);
		
		
		sc.close();
	}
		
}

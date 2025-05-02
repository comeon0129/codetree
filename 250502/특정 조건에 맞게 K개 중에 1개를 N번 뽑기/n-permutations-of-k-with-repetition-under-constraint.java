import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	
	public static int k,n;
	
	public static ArrayList<Integer> answer = new ArrayList<>();
	
	public static void printAnswer() {
		for(int i=0; i<answer.size(); i++) {
			System.out.print(answer.get(i)+" ");
		}
		System.out.println();
	}
	
	public static void choose(int curNum) {
		if(curNum == n) {
			printAnswer();
			return;
		}
		
		for(int i=1; i<=k; i++) {
			if(curNum==0 || curNum==1 || !(answer.get(answer.size()-1) == i && answer.get(answer.size()-2) == i)) {
				answer.add(i);
				choose(curNum+1);
				answer.remove(answer.size()-1);
			}
		}
		
		
			
	}
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		k = sc.nextInt();
		n = sc.nextInt();
		choose(0);
		
		
		sc.close();
	}
}


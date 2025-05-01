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
		if(curNum == n+1) {
			printAnswer();
			return;
		}
		
		for(int i=1; i<=k; i++) {
			answer.add(i);
			choose(curNum+1);
			answer.remove(answer.size()-1);
		}
		
		return;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		k = sc.nextInt();
		n = sc.nextInt();
		
		choose(1);
		

		sc.close();
	}
}
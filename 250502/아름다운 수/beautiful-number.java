import java.util.ArrayList;
import java.util.Scanner;


public class Main {
	
	public static int n;
	
	public static ArrayList<Integer> answer = new ArrayList<>();
	
	public static int ans = 0;
	
	public static boolean isBeautiful() {
		int index =0;
		
		while(index < n) {
			
			if(index+answer.get(index)-1 >=n)
				return false;
			
			for(int i=index; i<index+answer.get(index); i++) {
				if(answer.get(i)!= answer.get(index))
					return false;
			}
			
			index+=answer.get(index);

		}
		return true;
		
		
		
	}
	
	public static void choose(int curNum) {
		if(curNum == n+1) {
			return;
		}
		
		for(int i=1; i<=4; i++) {
			answer.add(i);
			choose(curNum+1);
			if(answer.size()==n &&isBeautiful())
				ans++;
			answer.remove(answer.size()-1);
		}
		
		return;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		
		choose(1);
		
		System.out.println(ans);

		sc.close();
	}
}

import java.util.ArrayList;
import java.util.Scanner;

class Segment {
	public int start;
	public int end;
	
	public Segment(int start, int end) {
		this.start = start;
		this.end = end;
	}
}

public class Main {
	
	public static int n;
	
	public static Segment[] segments = new Segment[16];
	
	public static int maxSeg = 0;
	
	public static ArrayList<Integer> combination = new ArrayList<>();
	
	public static boolean isNotIntersect() {
		
		int[] line = new int[1001];
		
		for(int i=0; i<combination.size(); i++) {
			if(combination.get(i)==1) {
				int start = segments[i].start;
				int end = segments[i].end;
				for(int j= start; j<=end; j++) {
					line[j]++;
				}
			}
		}
		
		for(int i=0; i<line.length; i++) {
			if(line[i]>1)
				return false;
		}
		return true;
	}
	
	
	public static int calc() {
		int returnVal = 0;
		for(int i=0; i<combination.size(); i++) {
			if(combination.get(i)==1)
				returnVal++;
		}
		return returnVal;
	}
	
	public static void choose(int cnt) {
		if(cnt == n) {
			if(isNotIntersect()) {
				maxSeg = Math.max(maxSeg, calc());
			}
			return;
		}
		
		combination.add(0); // 해당 선분을 선택하지 않는 경우 재귀호출
		choose(cnt+1);
		combination.remove(combination.size()-1);
		
		combination.add(1); //해당 선분을 선택하는 경우 재귀호출
		choose(cnt+1);
		combination.remove(combination.size()-1);
		
				
	}
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		
		for(int i=0; i<n; i++) {
			int start = sc.nextInt();
			int end = sc.nextInt();
			segments[i] = new Segment(start, end);
		}
		
		choose(0);
		System.out.println(maxSeg);
		
		sc.close();
	}
}

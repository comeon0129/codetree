import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	public static int n; //방크기
	public static int m; //하나의 도둑이 연속하여 훔칠 수 있는 물건 갯수
	public static int c; //각 도둑이 들 수 있는 최대 무게
	
	public static int[][] room;
	
	public static int answer = Integer.MIN_VALUE;
	
	public static ArrayList<Integer> choose = new ArrayList<>();
		
	public static int val = 0;
	
	public static int calc(int[] items) {
		int sum = 0;
		int weight = 0;
		
		for(int i=0; i<choose.size(); i++) {
			if(choose.get(i) == 1) {
				sum+= items[i]*items[i];
				weight += items[i];
			}
		}
		
		if(weight > c) return 0;
		
		return sum;
	}
	
	public static void chooseItems(int cnt, int[] items) {
		if(cnt == m) {
			val = Math.max(val, calc(items));
			return;
		}
		
		choose.add(0);
		chooseItems(cnt+1, items);
		choose.remove(choose.size()-1);
		
		choose.add(1);
		chooseItems(cnt+1, items);
		choose.remove(choose.size()-1);
	}
	
	public static int getMaxValue(int[] items) {
		
		val = 0;
		int weight = 0;
		
		for(int i=0; i<m; i++){
			weight += items[i];
		}
		
		if(weight > c) {
//			아이템들을 골라야함
			chooseItems(0,items);
		}
		else {
			for(int i=0; i<m; i++){
				val+= items[i]*items[i];
			}
		}
		return val;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);		
		n = sc.nextInt();
		m = sc.nextInt();
		c = sc.nextInt();
		room = new int[n+1][n+1];
		
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=n; j++) {
				room[i][j] = sc.nextInt();
			}
		}
		
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=n-m+1; j++) {
				//첫번째 도둑의 물건들
				int[] items1 = new int[m];
				
				for(int k=0; k<m; k++) {
					items1[k]=room[i][j+k];
				}
				
				int val1 = getMaxValue(items1);
				
				for(int a=1; a<=n; a++) {
					for(int b=1; b<=n-m+1; b++) {
						//겹치는 경우는 제외
						if(i == a && !(b>j+m-1 || b+m-1 < j))
								continue;
						
						int[] items2 = new int[m];
						for(int k=0; k<m; k++) {
							items2[k]=room[a][b+k];
						}
						
						int val2 = getMaxValue(items2);
						
						answer = Math.max(answer, val1+val2);
					}		
				}
			}
		}
		System.out.println(answer);
		
		sc.close();
	}
}
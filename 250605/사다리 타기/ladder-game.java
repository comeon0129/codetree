import java.util.Arrays;
import java.util.Scanner;

class Row{
	int start; //해당 가로줄이 몇번 세로줄에서 그어지는지에 대한 정보
	int number; //해당 가로줄이 위에서부터 몇번째로 그어지는지에 대한 정보
	boolean used; //해당 가로줄이 사용되는지에 대한 여부
	
	public Row(int start, int number, boolean used) {
		this.start = start;
		this.number= number;
		this.used = used;
	}
}

public class Main {
	
	public static int n; // n:세로줄 개수
	public static int m; // m:가로줄 개수
	
	public static int[] lastResult;
	
	public static  Row[] rows; //가로줄에 대한 정보를 담은 배열
	
	public static int minRows = Integer.MAX_VALUE;
	
	public static int[] tempResult;
	
	public static void initalizeTemp() {
		tempResult = new int[n+1];
		for(int i=1; i<=n; i++) {
			tempResult[i] = i;
		}
		return;
	}
	
	public static int calcRows() {
		int cnt = 0;
		for(int i=0; i<rows.length; i++) {
			if(rows[i].used == true)
				cnt++;
		}
		return cnt;
	}
	
	public static boolean isEqual(int[] temp, int[] last) {
		
		for(int i=1; i<=n; i++) {
			if(temp[i] != last[i])
				return false;
		}
		return true;		
	}
	
	public static void chooseRows(int cnt) {
		if(cnt == m) {
			makeResult(tempResult);
			
			if(isEqual(tempResult,lastResult)) {
				minRows = Math.min(minRows, calcRows());
			}
			initalizeTemp();
			
			return;
		}
		
		rows[cnt].used = false;
		chooseRows(cnt+1);
		rows[cnt].used = true;
		chooseRows(cnt+1);
	}
	
	//사용이 되는 가로선들을 바탕으로 결과 바꾸기
	public static void makeResult(int[] result) {
		for(int i=0; i<m; i++) {
			if(rows[i].used) {
				int temp = result[rows[i].start];
				
				result[rows[i].start] = result[rows[i].start+1];
				result[rows[i].start+1] = temp;
			}
		}

	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		
		lastResult = new int[n+1];
		tempResult = new int[n+1];
		
		rows = new Row[m];
		
		for(int i=1; i<=n; i++) {
			lastResult[i]= i;
			tempResult[i] = i;
		}
		
		for(int i=0; i<m; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			rows[i] = new Row(a,b,true);
		}
		
		Arrays.sort(rows, (a,b)->a.number-b.number);
		
		makeResult(lastResult);
		
		chooseRows(0);
		
		System.out.println(minRows);
		
		sc.close();
	}
}

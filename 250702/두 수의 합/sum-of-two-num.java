import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
public class Main {
	public static int n,k;
	public static int[] arr;
	public static ArrayList<Integer> chosenNum = new ArrayList<>();
	public static HashMap<Integer, Integer> m = new HashMap<>();
//	curNum번째 위치에 숫자를 고를지 말지 결정하는 함수
	public static void chooseNum(int curNum, int cnt) {
		if(cnt == 2) {
			int sum = 0;
			for(int c : chosenNum) {
				sum+=c;
			}
			if(m.containsKey(sum))
				m.put(sum, m.get(sum)+1);
			else
				m.put(sum, 1);
			return;
		}
		
		if(curNum == n)
			return;
		
//		해당 숫자를 뽑지 않는 경우
		chooseNum(curNum+1, cnt);
//		해당 숫자를 뽑는 경우
		chosenNum.add(arr[curNum]);
		chooseNum(curNum+1,cnt+1);
		chosenNum.remove(chosenNum.size()-1);
		
	}
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();
        arr = new int[n];
        for(int i=0; i<n; i++)
        	arr[i] = sc.nextInt();
        chooseNum(0, 0);
        
        if(m.containsKey(k))
        	System.out.println(m.get(k));
        else
        	System.out.println(0);
        
        sc.close();
    }
}
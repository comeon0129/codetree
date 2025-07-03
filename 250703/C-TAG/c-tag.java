import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
public class Main {
	public static int n,m;
	public static ArrayList<Integer> choice = new ArrayList<>();
	public static int ans = 0;
	public static String[] groupA;
	public static String[] groupB;
	public static boolean possible() {
		HashSet<String> s = new HashSet<>();
		
//		A그룹에서 나올 수 있는 경우의 수들 전부 HASHSET에 넣기
		for(int i=0; i<n; i++) {
			String temp = "";
			for(int j=0; j<choice.size(); j++) {
				temp+=groupA[i].charAt(choice.get(j));
			}
			s.add(temp);
		}
		
//		B그룹에서 나올 수 있는 경우의 수가 이미 A그룹에서 존재했는지 확인하기
		for(int i=0; i<n; i++) {
			String temp = "";
			for(int j=0; j<choice.size(); j++) {
				temp+=groupB[i].charAt(choice.get(j));
			}
			if(s.contains(temp))
				return false;
		}
		return true;
	}
	
	// 지금까지 고른 숫자의 개수가 cnt일때 curNum 번째 자리에 숫자를 선택할지 말지를 정하는 함수
	public static void chooseNum(int curNum, int cnt) {
		if(cnt == 3) {
			if(possible()) {
				ans++;
			}
			return;
		}
		if(curNum == m)
			return;
		
//		해당 숫자를 선택하지 않는경우
		chooseNum(curNum+1,cnt);
		
//		해당 숫자를 선택하는 경우
		choice.add(curNum);
		chooseNum(curNum+1,cnt+1);
		choice.remove(choice.size()-1);
		
	}
	
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        groupA = new String[n];
        groupB = new String[n];
        for (int i = 0; i < n; i++) {
            groupA[i] = sc.next();
        }
        for (int i = 0; i < n; i++) {
            groupB[i] = sc.next();
        }
        
        chooseNum(0,0);
        System.out.println(ans);
        sc.close();
    }
}
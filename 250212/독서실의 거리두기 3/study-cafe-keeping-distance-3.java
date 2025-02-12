import java.util.Scanner;

public class Main {
	
	public static int n;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		String s = sc.next();
		
		int changeIdx = 0;
		int maxInterval = 0;
		
		for(int i=0; i<n; i++) {
			for(int j=i+1; j<n; j++) {
				if(s.charAt(i) == '1' && s.charAt(j) == '1') {
					if(j-i > maxInterval) {
						changeIdx = (i+j)/2;
						maxInterval = j-i;
					}
					break;
				}
			}
		}
		//우리는 이제 가장 간격이 넓은 곳에 시작 idx와 끝 idx를 알아냈다. 
		
		//Step 2. 그 idx 가운데의 값을 1로 변경하기
		s = s.substring(0,changeIdx)+"1"+s.substring(changeIdx+1);
		
		int minDist = Integer.MAX_VALUE;
		for(int i=0; i<n; i++) {
			for(int j=i+1; j<n; j++) {
				if(s.charAt(i) == '1' && s.charAt(j) == '1') {
					int dist = j-i;
					minDist = Math.min(minDist, dist);
					break;
				}
			}
		}
		System.out.println(minDist);
		sc.close();
    }
}
import java.util.Scanner;

public class Main {
	
	public static int n;
	public static char[] arr = new char[100];
	
	public static int calcMinDist() {
		int minDist = Integer.MAX_VALUE;
		for(int i=0; i<n; i++) {
			for(int j=i+1; j<n; j++) {
				if(arr[i]=='1' && arr[j]=='1') {
					int dist = j-i;
					minDist = Math.min(minDist, dist);
					break;
				}
			}
			
		}
		return minDist;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		String s = sc.next();
		arr = s.toCharArray();
		
		int maxMinDist = 0;
		for(int i=0; i<n; i++) {
			for(int j=i+1; j<n; j++) {
				if(arr[i] == '0' && arr[j] == '0') {
					arr[i] = '1';
					arr[j] = '1';
					maxMinDist = Math.max(maxMinDist,calcMinDist());
					arr[i] = '0';
					arr[j] = '0';
				}
			}
		}
		System.out.println(maxMinDist);
	
		sc.close();
    }
}
import java.util.Scanner;

public class Main {
	public static final int MAX_N = 100;
	
	public static int n;
	
	public static int[] a = new int[MAX_N+1];
	public static int[] b = new int[MAX_N+1];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		for(int i=1; i<=n; i++) {
			a[i] = sc.nextInt();
		}
		for(int i=1; i<=n; i++) {
			b[i] = sc.nextInt();
		}
		int cost = 0;
		for(int i=1; i<=n; i++) {
			for(int j=i+1; j<=n; j++) {
				if(a[i] > b[i] && a[j] < b[j]) {  //더 많은 쪽의 사람을 더 적은쪽에 집에 옮기기 위함
					cost+= (a[i] - b[i]) * (j-i); // 이동한 거리 계산
					a[j] += (a[i]- b[i]);         // 이동한 집에 인원수만큼 더해주고
					a[i] = b[i];                  // 기존 집은 이제 인원수가 딱 맞게됨.
				}
			}
		}
		System.out.println(cost);
		
		sc.close();
    }
}
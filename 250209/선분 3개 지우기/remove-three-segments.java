import java.util.Scanner;

public class Main {
	
	public static int n;
	
	public static int[] a = new int[10];
	public static int[] b = new int[10];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		for(int i=0; i<n; i++) {
			a[i] = sc.nextInt();
			b[i] = sc.nextInt();
		}
		int ans =0;
		for(int i=0; i<n; i++) { //1번 선분 선택
			for(int j=i+1; j<n; j++) { // 2번 선분 선택
				for(int k=j+1; k<n; k++) { //3번 선분 선택
					int[] counting = new int[101];
					boolean intersect = false;
					for(int l=0; l<n; l++) { // 이제 배열 돌면서 1,2,3번 선분 제거하기
						if(l==i || l==j || l==k)
							continue;
						for(int m = a[l]; m<=b[l]; m++) { //제거하고 남은 애들만 counting 증가시키기
							counting[m]++;
						}
						
					}
					for(int l=0; l<counting.length; l++) { //2개 이상 겹치는 선분이 있는지 확인
						System.out.println(counting[l]);
						if(counting[l] >=2) {
							intersect = true;
							break;
						}
					}
					if(!intersect) // 겹치는게 없는 경우
						ans++;
				}
			}
		}
		System.out.println(ans);
		
		sc.close();
    }
}
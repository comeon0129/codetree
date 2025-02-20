import java.util.Arrays;
import java.util.Scanner;

public class Main {
	
	public static int n;
	
	public static int[] arr = new int[101];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		for(int i=0; i<n; i++) {
			arr[i] = sc.nextInt();
		}
		
		int[] rightArr = arr.clone();
		Arrays.sort(rightArr,0,n);
		
		
		
		int cnt = 0;
		while(true) {
			int temp = 0;
			for(int i=0; i<n; i++) {
				if(arr[i] == rightArr[i])
					temp++;
			}
			if(temp == n)
				break;
			
			//여기까지는 오름차순이 되면 빠져나가기 위함.

			int target = arr[0];  //뒤로 보낼 맨 앞자리 값
			int destIdx = 1;	  //어디로 보낼지 지정되는 인덱스값
			for(int i=n-2; i>=1; i--) {
				for(int j=i+1; j<n; j++) {
					if(arr[i] > arr[j]) {
						destIdx= i+1;     //서순이 안맞는 원소중에 가장 뒤에 값을 위치로 선택 -> 일단은 그 뒷자리에 놓겠다.
						break;
					} 
				}
			}
			while(target > arr[destIdx] && destIdx < n) { // 그 뒷자리 중에서 자기가 들어갈 자리로 이동
				destIdx++;
			}
				
			arr[destIdx+1] = arr[destIdx];
			arr[destIdx] = target;
			for(int i=0; i<n; i++) {
				arr[i] = arr[i+1];
			}
			cnt++;
		}
		
		System.out.println(cnt);
		
		sc.close();
    }
}
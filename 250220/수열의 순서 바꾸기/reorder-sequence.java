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
			for(int i=n-1; i>1; i--) {
				if(arr[i-1] > arr[i]) {
					destIdx= i;     //서순이 안맞는 원소중에 가장 뒤에 값을 위치로 선택 -> 일단은 그 뒷자리에 놓겠다.
					break;
				} 
			}
			while(target > arr[destIdx] && destIdx < n) { // 그 뒷자리 중에서 자기가 들어갈 자리로 이동
				destIdx++;
			}
			
			for(int i=n; i>destIdx; i--) //뒤에꺼 한칸씩 미루기
				arr[i] = arr[i-1];
			arr[destIdx] = target; // target끼워넣기
			
			for(int i=0; i<n; i++) {  //전체적으로 한칸씩 다 땡기고
				arr[i] = arr[i+1];
			}
			arr[n] = 0; //마지막 자리 0으로 변경
			cnt++;
		
		}
		
		System.out.println(cnt);
		
		sc.close();
    }
}
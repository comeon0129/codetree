import java.util.HashMap;
import java.util.Scanner;
public class Main {
	public static int n,k;
	public static int[] arr;

	public static HashMap<Integer, Integer> m = new HashMap<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();
        arr = new int[n];
        int cnt = 0;
        for(int i=0; i<n; i++) {
        	arr[i] = sc.nextInt();
//        	k-a =b 일때 b가 이미 존재했다면 b가 존재했던 개수만큼 가짓수에 더하기
        	if(m.containsKey(k-arr[i]))
        		cnt+=m.get(k-arr[i]);
        	
        	if(m.containsKey(arr[i]))
        		m.put(arr[i], m.get(arr[i])+1);
        	else
        		m.put(arr[i], 1);
        }
        System.out.println(cnt);
        
        sc.close();
    }
}

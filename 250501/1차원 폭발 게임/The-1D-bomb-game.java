import java.util.Scanner;


public class Main {
	
	public static int endOfArray;
	
	public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);
	        int n = sc.nextInt();
	        int m = sc.nextInt();
	        int[] bombs = new int[n];
	        for (int i = 0; i < n; i++) {
	            bombs[i] = sc.nextInt();
	        }
	        
	        endOfArray = n;
	        
	        
	        while(true) {
	        	int sqCnt = 1;
	        	 boolean isBomb = false; // 한번이라도 터진적이 있는지 체크하기 위함
	        	
	        	for(int i=1; i<endOfArray; i++) {
	        		
	        		if(bombs[i] == bombs[i-1]) {
	        			sqCnt++;
	        		}
	        		else {
	        			if(sqCnt >=m) { // m개 이상 연속한 숫자를 갖는 폭탄들의 모임을 전부 0으로 만들기 위함
	        				for(int j=1; j<=sqCnt; j++) {
	        					bombs[i-j] = 0;
	        				}
	        				isBomb = true;
	        			}
	        			sqCnt = 1;
	        		}
	        	}
	        	// 근데 이렇게만 하면 그냥 같은 상태에서 배열이 끝나버리는 경우에는 이 폭탄을 터트릴 수가 없어서 한번더 잡아내는 코드
	        	if(sqCnt >=m) {
    				for(int j=1; j<=sqCnt; j++) {
    					bombs[endOfArray-j] = 0;
    				}
    				isBomb = true;
    			}
	        	
	        	//여기까지는 이제 터져야하는 블록들 전부 0값으로 만드는 작업이었고 이제부터는 그 0값들을 없애고 temp에 집어넣는 과정 수행
	        	
	        	int[] temp = new int[endOfArray];
	        	
	        	int tempIdx = 0;
	        	
	        	for(int i=0; i<endOfArray; i++) {
	        		if(bombs[i] != 0) {
	        			temp[tempIdx] = bombs[i];
	        			tempIdx++;
	        		}
	        	}
	        	
	        	bombs = temp;
	        	endOfArray = tempIdx;
	        	
	        	
	        	if(!isBomb)
	        		break;
	 
	        }
	       
	      
	        System.out.println(bombs.length);
	        for(int i=0; i<endOfArray; i++) {
	        	System.out.println(bombs[i]);
	        }
	        
	        sc.close();
	    }
}

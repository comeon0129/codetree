import java.util.HashMap;
import java.util.Scanner;

class Node{
	int data;
	Node prev,next;
	
	public Node(int data) {
		this.data = data;
		this.prev = this.next = null;
	}
}

public class Main {
	public static int n;
	
	public static void connect(Node s, Node e) {
		if(s != null)
			s.next = e;
		
		if(e != null)
			e.prev = s;
		
	}
	
	public static void swapRange(Node a, Node b, Node c, Node d) {
		Node aPrev = a.prev;
		Node bNext = b.next;
		Node cPrev = c.prev;
		Node dNext = d.next;
		
		
//		b뒤에 c가 바로 붙어있는 경우
		if(bNext == c) {
			connect(aPrev,c);
			connect(d,a);
			connect(b,dNext);
		}
		else if(dNext == a) {
			connect(cPrev, a);
			connect(b,c);
			connect(d,bNext);
		}
		else {
			connect(aPrev,c);
			connect(d,bNext);
			connect(cPrev,a);
			connect(b,dNext);		
		}
		
	
	}
	
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int q = sc.nextInt();
        
        HashMap<Integer, Node> nodes = new HashMap<>();
        
        for(int i=0; i<=n; i++) {
        	nodes.put(i, new Node(i));
        }
        
        for(int i=0; i<n; i++) {
        	connect(nodes.get(i), nodes.get(i+1));
        }
        
        while(q-->0) {
        	int a= sc.nextInt();
        	int b= sc.nextInt();
        	int c= sc.nextInt();
        	int d= sc.nextInt();
        	swapRange(nodes.get(a), nodes.get(b), nodes.get(c), nodes.get(d));
        
        }
        
        Node cur = nodes.get(0).next;
        
        while(cur != null) {
        	System.out.print(cur.data+" ");
        	cur = cur.next;
        }
        
        sc.close();
    }
}
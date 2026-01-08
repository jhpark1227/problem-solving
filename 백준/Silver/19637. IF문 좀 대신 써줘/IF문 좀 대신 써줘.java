import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
 
 
public class Main {
	
	public static int N,M;
	public static int[] arr;
	public static Node[] node;
	public static StringBuilder sb = new StringBuilder();
	
    public static void main(String[] args) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	N = Integer.parseInt(st.nextToken());
    	M = Integer.parseInt(st.nextToken());
    	node = new Node[N];
    	
    	for(int i=0;i<N;i++) {
    		st = new StringTokenizer(br.readLine());
    		String a = st.nextToken();
    		int b = Integer.parseInt(st.nextToken());
    		node[i] = new Node(a, b);
    	}
    	
    	arr = new int[M];
    	for(int i=0;i<M;i++) {
    		st = new StringTokenizer(br.readLine());
    		int a = Integer.parseInt(st.nextToken());
    		arr[i] = a;
    	}
    	
    	for(int i=0;i<M;i++) {
        	binarySearch(arr[i]); 
    	}
    	
    	System.out.println(sb);
 
    }
    
    public static void binarySearch(int target) {
    	int start = 0;
    	int end = N-1;    	
    	while(start<=end) {
    		int middle = (start + end) / 2;
    		if( node[middle].fightScore >= target) { 
    			end = middle - 1;
    		}else {
    			start = middle + 1;
    		}
    	}
        
    	sb.append(node[end+1].name).append('\n');
    }
}
 
 
class Node{
	String name;
	int fightScore;
	public Node(String name, int fightScore) {
		this.name = name;
		this.fightScore = fightScore;
	}
}
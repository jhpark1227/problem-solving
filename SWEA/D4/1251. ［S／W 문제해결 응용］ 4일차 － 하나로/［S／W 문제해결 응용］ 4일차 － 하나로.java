import java.util.*;
import java.io.FileInputStream;

class Solution
{
    private static int[] parents;
    
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)
		{
			int n = sc.nextInt();
            int[] x = new int[n];
            int[] y = new int[n];
            List<Edge> edges = new ArrayList<>();
            for(int i=0;i<n;i++){
            	x[i] = sc.nextInt();
            }
            for(int i=0;i<n;i++){
            	y[i] = sc.nextInt();
            }
            double e = sc.nextDouble();
            for(int i=0;i<n;i++) {
            	for(int j=i + 1;j<n;j++){
					edges.add(new Edge(i, j, Math.sqrt(Math.pow(y[i] - y[j], 2) + Math.pow(x[i] - x[j], 2))));
                }
            }
			edges.sort((e1, e2) -> Double.compare(e1.cost, e2.cost));
            parents = new int[n];
            for(int i=0;i<n;i++){
            	parents[i] = i;
            }
            double length = 0;
            for(Edge edge: edges) {
            	if (find(edge.start) == find(edge.end)) {
                	continue;
                }
                union(edge.start, edge.end);
                length += edge.cost * edge.cost;
            }
			System.out.println("#" + test_case + " " + (Math.round(length * e)));
		}
	}
    
    private static int find(int child) {
    	if (parents[child] != child) {
        	parents[child] = find(parents[child]);
        }
        return parents[child];
    }
    
    public static void union(int a, int b) {
    	int aParent = find(a);
        int bParent = find(b);
        if (aParent < bParent) {
        	parents[bParent] = aParent;
            return;
        }
        parents[aParent] = bParent;
    }
    
    private static class Edge {
    	int start;
        int end;
        double cost;
        
        Edge(int start, int end, double cost) {
            this.start = start;
            this.end = end;
            this.cost = cost;
        }
    }
}
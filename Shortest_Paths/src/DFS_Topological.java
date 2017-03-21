import java.util.LinkedList;
import java.util.List;
import java.util.*;

public class DFS_Topological {
	public DFS_Topological() {}
	private List<Integer>[] adj;
	public boolean DFSTopological(List<Integer> L, int[][] edges, int n) {
		// L is the empty list that will contain the sorted elements

		// adj array contains the adjacency list of each vertex
		adj = new LinkedList[n];
		for (int i = 0; i < n; ++i) {
			adj[i] = new LinkedList<>();
		}

		// complete the adjacency list
		for (int[] edge : edges) {
			adj[edge[0]].add(edge[1]);
		}
		
		Stack<Integer> S = new Stack<>();
		
		boolean[] visited = new boolean[n];
		for(int i = 0; i < n; ++i){
			if(visited[i] == false){
				visit(i, visited, S);
			}
		}
		
		if(S.isEmpty()) return false;
		
		while(!S.isEmpty()){
			L.add(S.pop());
		}
		return true;
	}

	public void visit(int v, boolean[] visited, Stack<Integer> S){
		visited[v] = true; //mark current node as visited
		
		Iterator<Integer> iter = adj[v].iterator();
		while(iter.hasNext()){
			int cur = iter.next();
			if(!visited[cur]){
				visit(cur, visited, S);
			}
		}
		
		//push current vertex to stack with stores result
		S.push(v);
	}
}

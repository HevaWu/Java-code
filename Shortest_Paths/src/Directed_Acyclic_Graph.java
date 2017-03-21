import java.util.*;

public class Directed_Acyclic_Graph {
	public Directed_Acyclic_Graph(){}
	public class DAG_Node{
		int val;
		int weight;
		public DAG_Node(int val, int weight){
			this.val = val;
			this.weight = weight;
		}
	}

	public boolean DAG(int[][] G, int[][] weight, int s) {
		// adj array contains the adjacency list of each vertex
		int n = G.length;
		List<DAG_Node>[] adj = new LinkedList[n];
		for (int i = 0; i < n; ++i) {
			adj[i] = new LinkedList<>();
		}

		// complete the adjacency list
		for (int[] edge : weight) {
			DAG_Node newNode = new DAG_Node(edge[1], edge[2]);
			adj[edge[0]].add(newNode);
		}
		
		// DFS_Topological Sort
		DFS_Topological dfs = new DFS_Topological();
		List<Integer> L = new ArrayList<>();

		if (dfs.DFSTopological(L, weight, n)) {
			System.out.println("The DFS_Topological sort of current graph is:");
			for (int i : L) {
				System.out.print(" " + i);
			}
			System.out.println();
		} else {
			System.out.println("There is a cycle in the graph.");
			return false;
		}
		
		//initialize single source
		initial_single_source(G, s);
		
		for(int node: L){
			for(DAG_Node vertex: adj[node]){
				//relax
				if(G[node][0] > G[vertex.val][0] + vertex.weight){
					G[node][0] = G[vertex.val][0] + vertex.weight;
					G[node][1] = vertex.val;
				}
			}
		}
		
		for(int[] G1 : G){
			System.out.println(G1[0] + " pre: " + G1[1]);
		}
		
		return true;
	}
	
	public void initial_single_source(int[][] G, int s){
		//G[i][0] is the graph store the distance from s to i node,
		//G should be empty now
		//G[i][1] is the prenode of current i node

		int n = G.length;  //the number of nodes in the graph
		for(int i = 0; i < n; ++i){
			G[i][0] = Integer.MAX_VALUE;
			G[i][1] = -1;
		}
		G[s][0] = 0;
	}
}

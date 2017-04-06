import java.util.*;

public class Dijkstra {
	public Dijkstra(){}
	public void Dij(int[][] G, int[][] edges, int s){
		initial_single_source(G, s);
		int n = G.length;
		boolean[] visited = new boolean[n];
		int[][] adj = new int[n][n];

		for(int[] edge: edges){
			adj[edge[0]][edge[1]] = edge[2];
			adj[edge[1]][edge[0]] = edge[2];
		}
		
		/*for(int i = 0 ; i < n; ++i){
			for(int j = 0; j < n; ++j){
				System.out.print(adj[i][j] + " ");
			}
			System.out.println();
		}*/
		
		visited[s] = true;
		
		int count = 0;
		int u = 0;
		while(count < n-1){
			for(int v = 0; v < n; ++v){
				//relax
				//update the dist only if it is not visited
				//there is an edge from u to v
				//and total weight of path from s to v through u is smaller than current value of G[v][0]
				if(visited[v]==false && 
						adj[u][v] != 0 &&
						G[v][0] > G[u][0] + adj[u][v]){
					G[v][0] = G[u][0] + adj[u][v];
					G[v][1] = u;
				}
			}
			
			u = extract_min(G, visited);
			//System.out.println(u);
			visited[u] = true;
			count ++;
		}
		
		for(int[] G1 : G){
			System.out.println(G1[0] + " pre: " + G1[1]);
		}
	}
	
	public int extract_min(int[][] G, boolean[] visited){
		int min = Integer.MAX_VALUE;
		int index = -1;
		for(int i = 0; i < G.length; ++i){
			if(visited[i]==false && G[i][0]<=min){
				min = G[i][0];
				index = i;
			}
		}
		return index;
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

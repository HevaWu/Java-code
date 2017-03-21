
public class Bellman_Ford {
	public Bellman_Ford(){}
	public boolean BellmanFord(int[][] G, int[][] weight, int s){
		initial_single_source(G, s);
		int n = G.length;
		for(int i = 0; i < n-1; ++i){
			for(int[] edge: weight){
				//relax the path
				if(G[edge[1]][0] > G[edge[0]][0] + edge[2]){
					G[edge[1]][0] = G[edge[0]][0] + edge[2];
					G[edge[1]][1] = edge[0];
				}
			}
		}
		for(int[] edge: weight){
			if(G[edge[1]][0] > G[edge[0]][0] + edge[2]){
				return false;
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

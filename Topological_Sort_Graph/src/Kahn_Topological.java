import java.util.*;

public class Kahn_Topological {
	public Kahn_Topological(){}
	public boolean KahnTopological(List<Integer> L, int[][] edges, int n){
		//L is the empty list that will contain the sorted elements
		
		//adj array contains the adjacency list of each vertex
		List<Integer> adj[] = new LinkedList[n];
		for(int i = 0; i < n; ++i){
			adj[i] = new LinkedList<>();
		}
		
		//complete the adjacency list
		for(int[] edge:edges){
			adj[edge[0]].add(edge[1]);
		}
		
		//output the adj[]
		/*for(int i = 0; i < adj.length; ++i){
			System.out.print(i + ": ");
			for(int temp: adj[i]){
				System.out.print(temp + " ");
			}
			System.out.println();
		}*/
		
		//create an array to store the indegrees of all vertices
		int[] indegree = new int[n]; 
		for(int[] edge: edges){
			indegree[edge[1]]++;
		}
		
		//S is a set of all nodes with no incoming edges, which means indegree==0
		Queue<Integer> S = new LinkedList<>();
		for(int i = 0; i < indegree.length; ++i){
			if(indegree[i]==0) {
				S.add(i);
				//System.out.print(i + " ");
			}
		}
		
		int count = 0; // init the count of visited vertices
		while(!S.isEmpty()){
			int cur = S.poll(); //remove a node cur from S
			L.add(cur);  //add cur to tail of L
			for(int m: adj[cur]){   //for each node m with an edge from n to m
				//System.out.println(cur + ": " + m);
				if(--indegree[m]==0){  //if m has no other incoming edges
					S.add(m);  //insert it into S
				}
			}
			count++;
		}
		
		//check if graph still has edges
		if(count != n) return false;
		
		//no cycle, list L is the topological sort of graph
		return true;
	}
}

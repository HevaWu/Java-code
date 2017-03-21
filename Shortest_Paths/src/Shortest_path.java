
public class Shortest_path {

	public static void main(String[] args) {
		
		int n = 9;
		int[][] G = new int[n][2];
		int[][] weight = new int[][]{
			{0,1,4},
			{0,7,8},
			{1,7,11},
			{1,2,8},
			{2,3,7},
			{2,8,2},
			{2,5,4},
			{3,4,9},
			{3,5,14},
			{4,5,10},
			{5,6,2},
			{6,8,6},
			{6,7,1},
			{7,8,7}
		}; 
		
		Bellman_Ford bf = new Bellman_Ford();
		System.out.println(bf.BellmanFord(G, weight, 0));
		
		//G has a circle
		//the distance has value of -2147483644
		Directed_Acyclic_Graph dag = new Directed_Acyclic_Graph();
		System.out.println(dag.DAG(G, weight, 0));
		
		System.out.println("Dijkstra: ");
		Dijkstra dj = new Dijkstra();
		dj.Dij(G, weight, 0);
	}

}

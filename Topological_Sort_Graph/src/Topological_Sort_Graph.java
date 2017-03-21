import java.util.*;

public class Topological_Sort_Graph {

	public static void main(String[] args) {
		List<Integer> L = new ArrayList<>();
		int[][] edges = new int[][]{
				{0,4},
				{0,3},
				{3,4},
				{1,4},
				{3,5},
				{6,5},
				{6,7},
				{5,8},
				{7,8}
		};
		int n = 9;
		
		//Kahn_Topological Sort
		Kahn_Topological kt = new Kahn_Topological();
		if(kt.KahnTopological(L, edges, n)){
			System.out.println("The Kahn_Topological sort of current graph is:");
			for(int i : L){
				System.out.print(" " + i);
			}
		} else {
			System.out.println("There is a cycle in the graph.");
		}
		System.out.println();
		
		//DFS_Topological Sort
		DFS_Topological dfs = new DFS_Topological();
		L = new ArrayList<>();
		if(dfs.DFSTopological(L, edges, n)){
			System.out.println("The DFS_Topological sort of current graph is:");
			for(int i : L){
				System.out.print(" " + i);
			}
		} else {
			System.out.println("There is a cycle in the graph.");
		}
	}

}

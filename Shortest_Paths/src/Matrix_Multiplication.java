import java.util.*;

public class Matrix_Multiplication {
	public Matrix_Multiplication(){}
	
	public void MatrixMultiplication(int[][] edges, int n){
		//for directed graph
		//n is the number of nodes
		//edges is the input edges
		
		int[][] W = new int[n][n];
		for(int i = 0; i < n; ++i){
			for(int j = 0; j < n; ++j){
				if(i==j) W[i][j] = 0;
				else W[i][j] = Integer.MAX_VALUE;
			}
			//init the array is null, means no paths between each node
		}
		
		int[][] pre = new int[n][n];
		for(int i = 0; i < n; ++i){
			Arrays.fill(pre[i], -1);
			pre[i][i] = i;
		}
		
		//input the edges to the matrix
		for(int[] edge: edges){
			W[edge[0]][edge[1]] = edge[2];
			//init predecessor graph
			pre[edge[0]][edge[1]] = edge[0];
		}
		
		//matrix multiply, at the first, L is the W
		int[][] L = W;
		
		//solution 1
		for(int m = 1; m < n; ++m){
			L = extend_shortest_path(L, W, pre);
			//solution 2, improve time complexity
			//could use L = extend_shortest_path(L, L, pre); m=2*m 
			//to help quickly get L, 
			//however, using this method will get the wrong pre[][]
		}
		
		/*System.out.println("pre: ");
		for(int i = 0; i < n; ++i){
			for(int j = 0; j < n; ++j){
				System.out.print(pre[i][j] + " ");
			}
			System.out.println();
		}*/
		
		for(int i = 0; i < n; ++i){
			for(int j = 0; j < n; ++j){
				System.out.print("The shortest path from " + i + " to " + j + " is " + L[i][j] + " : " );
				print_path(pre, i, j);
				System.out.println();
			}
		}
	}
	
	public int[][] extend_shortest_path(int[][] L, int[][] W, int[][] pre){
		int n = L.length;
		int[][] C = new int[n][n];
		/*System.out.println("L: ");
		for(int i = 0; i < n; ++i){
			for(int j = 0; j < n; ++j){
				System.out.print(L[i][j] + " ");
			}
			System.out.println();
		}*/
		/*
		System.out.println("W: ");
		for(int i = 0; i < n; ++i){
			for(int j = 0; j < n; ++j){
				System.out.print(W[i][j] + " ");
			}
			System.out.println();
		}*/
		/*System.out.println("pre: ");
		for(int i = 0; i < n; ++i){
			for(int j = 0; j < n; ++j){
				System.out.print(pre[i][j] + " ");
			}
			System.out.println();
		}*/
		
		for(int i = 0; i < n; ++i){
			for(int j = 0; j < n; ++j){
				C[i][j] = Integer.MAX_VALUE;
				for(int k = 0; k < n; ++k){
					if(L[i][k]!=Integer.MAX_VALUE && W[k][j]!=Integer.MAX_VALUE){
						if(L[i][k] + W[k][j] < C[i][j]){
							C[i][j] = L[i][k] + W[k][j];
							if(L[i][j] > C[i][j]){
								//System.out.println(i + " " + j + " " + L[i][j] + " " + C[i][j]);
								pre[i][j] = k;
							}
						}
					}
				}
			}
		}
		
		/*System.out.println("C: ");
		for(int i = 0; i < n; ++i){
			for(int j = 0; j < n; ++j){
				System.out.print(C[i][j] + " ");
			}
			System.out.println();
		}*/
		return C;
	}
	
	public void print_path(int[][] pre, int i, int j){
		if(i == j){
			System.out.print(i + " ");
		} else if(pre[i][j] == -1){
			System.out.println("No path from " + i + " to " + j + " exists.");
		} else {
			print_path(pre, i, pre[i][j]);
			System.out.print(j + " ");
		}
	}
}

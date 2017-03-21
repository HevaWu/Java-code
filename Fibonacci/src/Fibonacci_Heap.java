import java.util.*;

public class Fibonacci_Heap {
	public class FB_Node{
		int key;
		int degree = 0;
		FB_Node p = null; //parent
		List<FB_Node> child = new LinkedList<>(); //child
		FB_Node right = null;
		boolean mark = false;
		public FB_Node(int key){
			this.key = key;
		}
	}
	
	public class FB_Heap{
		int n = 0;  //number of node
		FB_Node min = null;
		List<FB_Node> rootlist = new LinkedList<>();
	}
	
	public FB_Heap FB_Make_heap(){
		return new FB_Heap();
	}
	
	public void FB_Insert(FB_Heap H, FB_Node node){
		if(H.min == null){
			H.rootlist.add(node);
			H.min = node;
		} else {
			H.rootlist.add(node);
			if(node.key < H.min.key){
				H.min = node;
			}
		}
		H.n++;
	}
	
	public FB_Node FB_Minimum(FB_Heap H){
		return H.min;
	}
	
	public FB_Heap FB_Union(FB_Heap H1, FB_Heap H2){
		FB_Heap H = new FB_Heap();
		H.min = H1.min;
		
		//concatenate the root list of H2 with the rootlist of H1
		H1.rootlist.addAll(H2.rootlist);
		H.rootlist = H1.rootlist;
		
		if(H1.min == null || (H2.min!=null && H2.min.key<H1.min.key)){
			H.min = H2.min;
		}
		
		H.n = H1.n + H2.n;
		return H;
	}
	
	public FB_Node FB_Extract_min(FB_Heap H){
		FB_Node z = H.min;
		if(z != null){
			for(FB_Node x : z.child){
				H.rootlist.add(x);
				x.p = null;
			}
			H.rootlist.remove(H.rootlist.indexOf(z));
			if(z == z.right){
				H.min = null;
			} else {
				H.min = z.right;
				FB_Consolidate(H);
			}
			H.n = H.n-1;
		}
		return z;
	}
	
	public void FB_Consolidate(FB_Heap H){
		//The magic 45 comes from log base phi of Integer.MAX_VALUE
		//which is the most elements we will ever hold
		//the log base phi represents the largest degree of any root list node
		FB_Node[] A = new FB_Node[45];
		
		for(FB_Node w : H.rootlist){
			FB_Node x = w;
			int d = x.degree;
			while(A[d] != null){
				//there is another node with the same degree as x
				FB_Node y = A[d];
				if(x.key > y.key){
					//exchange x with y
					//always keep x.key is minimum
					//then link y to x
					FB_Node temp = x;
					x = y;
					y = temp;
				}
				
				FB_Link(H, y, x);
				A[d] = null;
				d = d + 1;
			}
			A[d] = x;
		}
		
		H.min = null; //clear the min
		for(FB_Node i: A){
			if(i!=null){
				if(H.min==null){
					H.rootlist = new LinkedList<>();
					H.rootlist.add(i);
					H.min = i;
				} else {
					H.rootlist.add(i);
					if(i.key < H.min.key){
						H.min = i;
					}
				}
			}
		}
	}
	
	public void FB_Link(FB_Heap H, FB_Node y, FB_Node x){
		//remove y from the root list of H
		H.rootlist.remove(H.rootlist.indexOf(y));
		
		//make y a child of x, incrementing x.degree
		x.child.add(y);
		x.degree++;
		y.mark = false;
	}
	
	public void FB_Decrease_key(FB_Heap H, FB_Node x, int k){
		if(k > x.key){
			System.out.println("Error: New Key is greater than current key.");
		}
		
		x.key = k;
		FB_Node y = x.p;
		if(y!=null && x.key<y.key){
			//check if it is satisfy min-heap order
			FB_Cut(H, x, y);
			FB_Cascading_cut(H, y);
		}
		
		if(x.key < H.min.key){
			H.min = x;
		}
	}
	
	public void FB_Cut(FB_Heap H, FB_Node x, FB_Node y){
		//remove x from the child list of y, decrementing y.degree
		y.child.remove(y.child.indexOf(x));
		y.degree--;
		
		//add x to the root list of H
		H.rootlist.add(x);
		
		x.p = null;
		x.mark = false;
	}
	
	//recursively do this function, until it met the root/node which is not marked
	public void FB_Cascading_cut(FB_Heap H, FB_Node y){
		FB_Node z = y.p;
		if(z != null){
			if(y.mark == false){
				y.mark = true;
			} else {
				FB_Cut(H, y, z);
				FB_Cascading_cut(H,z);
			}
		}
	}
	
	public void FB_Delete(FB_Heap H, FB_Node x){
		FB_Decrease_key(H, x, Integer.MIN_VALUE);
		FB_Extract_min(H);
	}
}

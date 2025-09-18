package zoho1;
import java.util.*;
import java.util.LinkedList;
//Adjacency list
public class Bfs {

	public static void main(String[] args) {
		int[][] graph= {{0,1,0,0,1},{1,0,1,0,1},{0,1,0,1,0},{0,0,1,0,1},{1,1,0,1,0}};
		Graph g=new Graph(5);
		g.addEdge(0,1);
		g.addEdge(2,3);
		g.addEdge(4,0);
		g.addEdge(4,3);
		g.addEdge(4,1);
		g.addEdge(2,1);
		g.adjList();
		g.breadth(0);
		g.dfs(0);
	}
}
class Graph{
	ArrayList<ArrayList<Integer>> adjList=new ArrayList<>();
	Graph(int v){
		for(int i=0; i<v;i++) {
			adjList.add(new ArrayList<Integer>());
		}
	}
	public void addEdge(int u,int v ) {
		adjList.get(u).add(v);
		adjList.get(v).add(u);
	}
	
	public void adjList() {
		for(int i=0; i<adjList.size();i++) {
			System.out.print("Vertices "+i+"--> ");
			System.out.print("Edges ");
		for(int j=0; j<adjList.get(i).size();j++) {
			System.out.print(adjList.get(i).get(j)+" ");
		}
		System.out.println();
	}
}
	//bfs
	public void breadth(int v) {
		int s=adjList.size();
		boolean[] visit=new boolean[s];
		visit[v]=true;
		
		Queue<Integer> q=new LinkedList<>();
		q.add(v);
		System.out.print("BFS:");
		while(q.size()!=0) {
			int vertex=q.remove();
		System.out.print(vertex+" ");
		for(int i=-0; i<adjList.get(vertex).size();i++) {
			int av=adjList.get(vertex).get(i);
			if(!visit[av])
				q.add(av);
			visit[av]=true;
		}
		}
		System.out.println();
	}
	
	//dfs
	
	/*public void dfs(int start) {
		int s=adjList.size();
	    boolean[] visit = new boolean[s];
	    Stack<Integer> stack = new Stack<>();

	    stack.push(start);
	    System.out.print("DFS:");
	    while (!stack.isEmpty()) {
	        int v = stack.pop();

	        if (!visit[v]) {
	            visit[v] = true;
	            System.out.print(v + " ");
	            for (int i = adjList.get(v).size() - 1; i >= 0; i--) {
	                int av = adjList.get(v).get(i);
	                if (!visit[av]) {
	                    stack.push(av);
	                }
	            }
	        }
	    }
	}*/
	
	public void dfs(int v) {
		int s=adjList.size();
		boolean[] visit=new boolean[s];
		System.out.print("DFS:");
		dfs2(v,visit);
	}
	public void dfs2(int v, boolean[] visit) {//boolean visit change every time
		visit[v]=true;
		System.out.print(v+" ");
		for(int i=0; i<adjList.get(v).size();i++) {
			int av=adjList.get(v).get(i);
			if(!visit[av]) {
				dfs2(av,visit);
			}
		}
	}

}


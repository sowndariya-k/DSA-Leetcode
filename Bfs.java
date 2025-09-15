package zoho1;
import java.util.*;
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
}

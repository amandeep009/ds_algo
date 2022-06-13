package graph.traversal;

import java.util.ArrayList;

public class DFS {

    public static void main(String[] args) {
        Graph graph = new Graph(5);
        graph.addEdge(0,1);
        graph.addEdge(0,2);
        graph.addEdge(2,3);
        graph.addEdge(1,3);
        graph.addEdge(1,4);
        graph.addEdge(2,4);
        dfs(graph,0,new ArrayList<Integer>());
    }

    private static void dfs(Graph graph, int i, ArrayList<Integer> visited) {
        if(visited.contains(i)){
            return;
        }
        System.out.println(i);
        visited.add(i);

        for (int k = 0; k <graph.adjacencyList.get(i).size()  ; k++) {
            dfs(graph,graph.adjacencyList.get(i).get(k),visited);
        }
    }


}

class Graph{
    ArrayList<ArrayList<Integer>> adjacencyList;

    public Graph(int vertices){
        adjacencyList
                = new ArrayList<ArrayList<Integer> >(vertices);

        for (int i = 0; i < vertices; i++)
            adjacencyList.add(new ArrayList<Integer>());

    }
    public boolean addEdge(int u,int v){
        adjacencyList.get(u).add(v);
        adjacencyList.get(v).add(u);
        return true;
    }


}

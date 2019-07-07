import java.util.*;
import java.util.HashMap;


class Graph{
    ArrayList<List<Integer>> graph;

    public Graph(){
        this.graph = new ArrayList<List<Integer>>();
    }
    public void add_edge(int u, int v){
        try{
            this.graph.get(u).add(v);

        } catch(Exception e){
            graph.add(u, new ArrayList<Integer>(Arrays.asList(v)));

        }
    }
    public void remove_edge(int u, int v){
        int location_of_u = this.graph.indexOf(u);
        this.graph.get(u).remove(location_of_u);
        int location_of_v = this.graph.indexOf(v);
        this.graph.get(v).remove(location_of_v);
    }
    public List<Integer> get_adjacent_vertices(int u){
        return this.graph.get(u);
    }
    public int get_number_of_vertices(){
        return (this.graph).size();
    }
}

public class DFS{
    Graph graph;
    public DFS(Graph graph){
        this.graph = graph;
        int size_of_graph = this.graph.get_number_of_vertices();
        List<Boolean> visited_array=new ArrayList<Boolean>(Arrays.asList(new Boolean[size_of_graph]));

        Collections.fill(visited_array, Boolean.FALSE);

        this.dfs_util(visited_array, 0);
        this.check_if_disconnected(visited_array);
    }

      
    public void dfs_util(List<Boolean> visited, int v){
        visited.set(v, true);
        System.out.printf("Now visiting node: %d\n", v);
        for (int i: this.graph.get_adjacent_vertices(v)){
            if (visited.get(i) == false){
                this.dfs_util(visited, i);
            }
        }
    }
    public void check_if_disconnected(List<Boolean> visited){
        int length_of_visited = Collections.frequency(visited, true);

        while(this.graph.get_number_of_vertices() != length_of_visited){

            int unvisited_vertex = visited.indexOf(false);
            
            if(unvisited_vertex == -1){
                break;
            }
            this.dfs_util(visited, unvisited_vertex);
        }
    }
    public static void main(String[] args){
        Graph graph = new Graph();
        graph.add_edge(0,1);
        graph.add_edge(1,0);

        graph.add_edge(1,2);
        graph.add_edge(2,1);
        
        graph.add_edge(2,3);
        graph.add_edge(3,2);
        
        graph.add_edge(3,0);
        graph.add_edge(0,3);
        
        graph.add_edge(4,5);
        graph.add_edge(5,4);

        DFS df = new DFS(graph);
    }
}


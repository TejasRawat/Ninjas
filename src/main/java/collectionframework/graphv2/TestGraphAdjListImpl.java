package collectionframework.graphv2;

import java.util.List;

public class TestGraphAdjListImpl  {
    public static void main(String args[]){

        Graph<Integer> graph = new GraphAdjListImpl(4);
        graph.addEdge(new Integer(0),new Integer(1));
        graph.addEdge(new Integer(0),new Integer(2));
        graph.addEdge(new Integer(1),new Integer(2));
        graph.addEdge(new Integer(2),new Integer(0));
        graph.addEdge(new Integer(2),new Integer(3));
        graph.addEdge(new Integer(3),new Integer(3));


 //       List<Integer> bfs = graph.getBFS(new Integer(2));

        List<Integer> dfs = graph.getDFS(new Integer(2));

        System.out.println(dfs);

  //      System.out.print(bfs);
    }
}

package collectionframework.graphv2;

import java.util.*;

public interface Graph<E> {

    public boolean addEdge(E from, E to);

    public List<E> getBFS(E source);

    public List<E> getDFS(E source);

    public List<E> getFirstCycle(E source);

    public boolean isCycle();

    public List<Integer> topologicalSort();

    public Map<Integer,Integer> getAlllNodeShortestPath(int [][] graph, int source);

}


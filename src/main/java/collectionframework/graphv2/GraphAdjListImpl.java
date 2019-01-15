package collectionframework.graphv2;


import org.springframework.util.CollectionUtils;

import java.util.*;

public class GraphAdjListImpl implements Graph<Integer> {

    private Map<Integer, List<Integer>> map;
    private int size;
    private List<Integer> dfsView;
    private static int MARK_VISITED = 1;

    public GraphAdjListImpl(int size) {
        map = new HashMap<>();
        this.size = size;
    }

    @Override
    public boolean addEdge(Integer from, Integer to) {
        if (map.containsKey(from)) {
            map.get(from).add(to);
        } else {
            List<Integer> list = new LinkedList<>();
            list.add(to);
            map.put(from, list);
        }
        return true;
    }

    @Override
    public List<Integer> getBFS(Integer source) {
        Queue<Integer> queue = new LinkedList<>();
        List<Integer> bfsView = new LinkedList<>();
        int visited[] = new int[size];
        for (int i = 0; i < visited.length; i++) {
            visited[i] = 0;
        }

        queue.add(source);
        while (!queue.isEmpty()) {
            Integer last = queue.poll();
            if (visited[last] == 0) {
                bfsView.add(last);
                visited[last] = 1;
                List<Integer> integers = map.get(last);
                if (!CollectionUtils.isEmpty(integers)) {
                    queue.addAll(integers);
                }
            }
        }
        return bfsView;
    }


    @Override
    public List<Integer> getDFS(Integer source) {
        /* Use for iterative calls
           return  doIterativeDFS(source);
        */
        return getDFSOrderIterative(source);

       /* int visited[] = new int[size];
        for (int i = 0; i < visited.length; i++) {
            visited[i] = 0;
        }
        dfsView = new LinkedList<>();

        doDFS(source, visited);

        return dfsView;*/
    }

    private void doDFS(Integer source, int[] visited) {
        visited[source] = 1;

        dfsView.add(source);
        List<Integer> linkedNodes = map.get(source);
        Iterator<Integer> iterator = linkedNodes.iterator();

        while (iterator.hasNext()) {
            Integer next = iterator.next();
            if (visited[next] == 0) {
                doDFS(next, visited);
            }
        }
    }

    public List<Integer> getDFSOrderIterative(Integer source) {
        Stack<Integer> traversedVertices = new Stack<>();
        List<Integer> dfsOrderList = new ArrayList<>();

        int visitedVertices[] = initialiseVisitedVertices(size);
        traversedVertices.push(source);

        while (!traversedVertices.isEmpty()) {
            Integer topVertex = traversedVertices.pop();
            dfsOrderList.add(topVertex);
            visitedVertices[topVertex] = MARK_VISITED;

            final List<Integer> connectedVertices = map.get(topVertex);
            for (Integer vertex : connectedVertices) {
                if (visitedVertices[vertex] == 0) {
                    traversedVertices.push(vertex);
                }
            }
        }
        return dfsOrderList;
    }

    private int[] initialiseVisitedVertices(int size) {
        int[] visitedVertices = new int[size];
        for (int i = 0; i < size; i++) {
            visitedVertices[i] = 0;
        }
        return visitedVertices;
    }


    @Override
    public List<Integer> getFirstCycle(Integer source) {
        Stack<Integer> stack = new Stack<>();
        int visited[] = new int[size];
        for (int i = 0; i < visited.length; i++) {
            visited[i] = 0;
        }
        stack.push(source);
        while (!stack.isEmpty()) {
            Integer peek = stack.peek();
            Integer integer = anyVisitedNodeReachble(stack, visited);
            if (!integer.equals(Integer.MAX_VALUE)) {
                // loop exists
            } else {
                // Keep doing the DFS
            }
         /*   boolean isVisitedNodePresent = isVisitedNodePresent(stack,visited);
            if(isVisitedNodePresent){
                return new ArrayList<>(stack);
            }else{
                addToDFSAndMarkVisited(null, stack.peek(), visited);
             //   stack.push(unvisitedFirstNode);
            }*/
        }
        return null;
    }

    @Override
    public boolean isCycle() {
        boolean[] visited = new boolean[size];
        boolean[] recStack = new boolean[size];

        for (int i = 0; i < size; i++)
            if (isCyclicUtil(i, visited, recStack))
                return true;

        return false;
    }

    @Override
    public List<Integer> topologicalSort() {
        Stack stack = new Stack();

        boolean visited[] = new boolean[size];
        for (int i = 0; i < size; i++) {
            visited[i] = false;
        }

        for (int i = 0; i < size; i++) {
            if (visited[i] == false)
                topologicalSortUtil(i, visited, stack);
        }

        return stack;
    }

    @Override
    public Map<Integer, Integer> getAlllNodeShortestPath(int[][] graph, int source) {
        Map<Integer, Integer> disatanceMap = new HashMap<>();
        boolean visitedNodes[] = new boolean[graph.length];
        visitedNodes[source] = true;

        List<Integer> data = new ArrayList<>();
        for (int i = 0; i < graph.length; i++) {
            data.add(new Integer(graph[source][i]));
        }

        for (int i = 0; i < graph.length - 1; i++) {
            int shortestUnvisited = getShortestUnvisited(data, visitedNodes);
            disatanceMap.put(shortestUnvisited, data.get(shortestUnvisited));

            relaxNodes(data, shortestUnvisited);
        }

        return disatanceMap;
    }

    private void relaxNodes(List<Integer> data, int shortestUnvisited) {
    }

    private int getShortestUnvisited(List<Integer> data, boolean[] visitedNodes) {
        return 0;
    }

    private void topologicalSortUtil(int v, boolean[] visited, Stack stack) {
        visited[v] = true;
        Integer i;

        Iterator<Integer> it = map.get(v).iterator();
        while (it.hasNext()) {
            i = it.next();
            if (!visited[i])
                topologicalSortUtil(i, visited, stack);
        }
        stack.push(new Integer(v));
    }

    private boolean isCyclicUtil(int i, boolean[] visited, boolean[] recStack) {
        if (recStack[i])
            return true;

        if (visited[i])
            return false;

        visited[i] = true;

        recStack[i] = true;
        List<Integer> children = map.get(i);

        for (Integer c : children)
            if (isCyclicUtil(c, visited, recStack))
                return true;

        recStack[i] = false;

        return false;
    }

    private Integer anyVisitedNodeReachble(Stack<Integer> stack, int[] visited) {
        // TO DO
        return Integer.MAX_VALUE;
    }


    public Map<Integer, List<Integer>> getMap() {
        return map;
    }

    @Override
    public String toString() {
        return "GraphAdjListImpl{" +
                "map=" + map +
                ", size=" + size +
                '}';
    }
}

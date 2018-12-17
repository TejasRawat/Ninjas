package collectionframework.graphv2;


import org.springframework.util.CollectionUtils;

import java.util.*;

public class GraphAdjListImpl implements Graph<Integer> {

    private Map<Integer, List<Integer>> map;
    private int size;

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
        List<Integer> dfsList = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        int visited[] = new int[size];
        for (int i = 0; i < visited.length; i++) {
            visited[i] = 0;
        }
        stack.push(source);

        while (!stack.isEmpty()) {
            Integer unvisitedFirstNode = getUnvisitedFirstNode(stack.peek(), visited);

            if (unvisitedFirstNode.equals(Integer.MIN_VALUE)) {
                addToDFSAndMarkVisited(dfsList, stack.peek(), visited);
                stack.pop();
            } else {
                addToDFSAndMarkVisited(dfsList, stack.peek(), visited);
                stack.push(unvisitedFirstNode);
            }
        }
        return dfsList;
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
            if(!integer.equals(Integer.MAX_VALUE)){
                // loop exists
            }else {
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

    private Integer anyVisitedNodeReachble(Stack<Integer> stack, int[] visited) {
        // TO DO
        return Integer.MAX_VALUE;
    }

    private boolean isVisitedNodePresent(Stack<Integer> stack, int[] visited) {
        Integer peek = stack.peek();
        List<Integer> connectedNodes = map.get(peek);

        for (int i = 0; i < visited.length; i++) {
            if (visited[i] == 1 && connectedNodes.contains(i) && stack.contains(new Integer(i))) {
                return true;
            }
        }
        return false;
    }

    private void addToDFSAndMarkVisited(List<Integer> dfsList, Integer peek, int[] visited) {
        if (!CollectionUtils.isEmpty(dfsList) && !dfsList.contains(peek)) {
            dfsList.add(peek);
        }
        visited[peek] = 1;
    }

    private Integer getUnvisitedFirstNode(Integer source, int[] visited) {
        List<Integer> integers = map.get(source);
        for (Integer node : integers) {
            if (visited[node] == 0 && !source.equals(node)) {
                return node;
            }
        }
        return Integer.MIN_VALUE;
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

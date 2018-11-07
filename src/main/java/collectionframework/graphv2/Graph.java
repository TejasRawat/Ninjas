package collectionframework.graphv2;

import java.util.List;

public interface Graph<E> {

    public boolean addEdge(E from, E to);
    public List<E> getBFS(E source);
    public List<E> getDFS(E source);

}


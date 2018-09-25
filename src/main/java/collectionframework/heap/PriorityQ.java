package collectionframework.heap;


import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Stream;


public class PriorityQ<Integer> extends AbstractQueue<Integer>
        implements java.io.Serializable {

    private List<Integer> list;

    public PriorityQ() {
        list = new ArrayList<>();
    }

    public boolean add(Integer e) {
        return offer(e);
    }

    @Override
    public boolean offer(Integer integer) {
        list.add(integer);

        int a[] = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            Integer num = list.get(i);
            a[i] = java.lang.Integer.parseInt(num.toString());
        }
        int size = a.length;

        // Build heap (rearrange array)
        for (int i = size / 2 - 1; i >= 0; i--) {
            heapify(a, i);
        }
        List<java.lang.Integer> intList = new ArrayList<>();
        for (int i : a) {
            intList.add(i);
        }
        list = (List<Integer>) intList;
        return false;
    }

    /*To heapify a subtree rooted with node i which is
    an index in arr[]*/
    void heapify(int arr[], int i) {
        int n = arr.length;

        int largest = i; // Initialize largest as root
        int l = 2 * i + 1; // left = 2*i + 1
        int r = 2 * i + 2; // right = 2*i + 2

        // If left child is larger than root
        if (l < n && arr[l] > arr[largest])
            largest = l;

        // If right child is larger than largest so far
        if (r < n && arr[r] > arr[largest])
            largest = r;

        // If largest is not root
        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            // Recursively heapify the affected sub-tree
            heapify(arr, largest);
        }
    }

    public List<Integer> getList() {
        return list;
    }

    public void setList(List<Integer> list) {
        this.list = list;
    }

    @Override
    public Integer peek() {
        return null;
    }

    @Override
    public Iterator<Integer> iterator() {
        return null;
    }

    @Override
    public void forEach(Consumer<? super Integer> action) {

    }

    @Override
    public Spliterator<Integer> spliterator() {
        return null;
    }

    @Override
    public Stream<Integer> stream() {
        return null;
    }

    @Override
    public Stream<Integer> parallelStream() {
        return null;
    }

    @Override
    public boolean removeIf(Predicate<? super Integer> filter) {
        return false;
    }

    @Override
    public int size() {
        return list.size();
    }


    @Override
    public Integer poll() {
        return null;
    }


}

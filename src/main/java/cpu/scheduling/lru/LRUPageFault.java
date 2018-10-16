package cpu.scheduling.lru;

public class LRUPageFault extends Exception {

    private final int pageNumber;

    public LRUPageFault(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public int getPageNumber() {
        return pageNumber;
    }
}

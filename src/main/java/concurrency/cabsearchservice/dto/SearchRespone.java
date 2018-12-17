package concurrency.cabsearchservice.dto;

public class SearchRespone {

    private Solution solution;

    public SearchRespone (){

    }

    public SearchRespone(Solution solution) {
        this.solution = solution;
    }

    public Solution getSolution() {
        return solution;
    }

    public void setSolution(Solution solution) {
        this.solution = solution;
    }
}

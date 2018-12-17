package concurrency.cabsearchservice.dto;

import concurrency.cabsearchservice.constants.SearchEngineConstants;
import concurrency.cabsearchservice.data.Cab;
import java.util.*;

public class Solution {

    private SearchEngineConstants.CabSupplier cabSource;
    private SearchRequest searchRequest;
    private List<Cab> cabs;

    public Solution() {
    }

    public Solution(SearchEngineConstants.CabSupplier cabSource, SearchRequest searchRequest) {
        this.cabSource = cabSource;
        this.searchRequest = searchRequest;
    }

    public SearchEngineConstants.CabSupplier getCabSource() {
        return cabSource;
    }

    public void setCabSource(SearchEngineConstants.CabSupplier cabSource) {
        this.cabSource = cabSource;
    }

    public SearchRequest getSearchRequest() {
        return searchRequest;
    }

    public void setSearchRequest(SearchRequest searchRequest) {
        this.searchRequest = searchRequest;
    }

}

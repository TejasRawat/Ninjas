package concurrency.cabsearchservice.connectors;

import concurrency.cabsearchservice.dto.SearchRequest;
import concurrency.cabsearchservice.dto.SearchRespone;

public interface Connector {

    SearchRespone doSearch(SearchRequest searchRequest);

}

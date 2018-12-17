package concurrency.cabsearchservice.service;

import concurrency.cabsearchservice.dto.SearchRequest;
import concurrency.cabsearchservice.dto.SearchRespone;

public interface SearchService {

    SearchRespone search(SearchRequest searchRequest);

}

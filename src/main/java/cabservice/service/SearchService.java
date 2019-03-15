package cabservice.service;

import cabservice.dto.SearchRequest;
import cabservice.dto.SearchRespone;

public interface SearchService {

    SearchRespone search(SearchRequest searchRequest);

}

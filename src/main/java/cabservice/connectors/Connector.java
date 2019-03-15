package cabservice.connectors;

import cabservice.dto.SearchRequest;
import cabservice.dto.SearchRespone;

public interface Connector {

    SearchRespone doSearch(SearchRequest searchRequest);

}

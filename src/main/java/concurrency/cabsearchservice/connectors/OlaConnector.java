package concurrency.cabsearchservice.connectors;

import concurrency.cabsearchservice.constants.SearchEngineConstants;
import concurrency.cabsearchservice.dto.SearchRequest;
import concurrency.cabsearchservice.dto.SearchRespone;

public class OlaConnector extends BaseConnector {

    public OlaConnector(SearchEngineConstants.CabSupplier cabSupplier) {
        super(cabSupplier);
    }

    @Override
    public SearchRespone doSearch(SearchRequest searchRequest) {

        // Creating Mock Response
        SearchRespone searchRespone = new SearchRespone();

        return searchRespone;
    }
}

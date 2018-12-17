package concurrency.cabsearchservice.connectors;

import concurrency.cabsearchservice.constants.SearchEngineConstants;
import concurrency.cabsearchservice.dto.SearchRequest;
import concurrency.cabsearchservice.dto.SearchRespone;

public class UberConnector extends BaseConnector {

    public UberConnector(SearchEngineConstants.CabSupplier cabSupplier) {
        super(cabSupplier);
    }

    @Override
    public SearchRespone doSearch(SearchRequest searchRequest) {

        return null;
    }
}

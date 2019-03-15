package cabservice.connectors;

import cabservice.constants.SearchEngineConstants;
import cabservice.dto.SearchRequest;
import cabservice.dto.SearchRespone;

public class UberConnector extends BaseConnector {

    public UberConnector(SearchEngineConstants.CabSupplier cabSupplier) {
        super(cabSupplier);
    }

    @Override
    public SearchRespone doSearch(SearchRequest searchRequest) {

        return null;
    }
}

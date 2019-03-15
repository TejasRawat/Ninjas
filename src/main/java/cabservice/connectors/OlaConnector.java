package cabservice.connectors;

import cabservice.constants.SearchEngineConstants;
import cabservice.dto.SearchRequest;
import cabservice.dto.SearchRespone;

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

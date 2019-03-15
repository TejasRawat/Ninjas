package cabservice.connectors;

import cabservice.constants.SearchEngineConstants;
import cabservice.dto.SearchRequest;
import cabservice.dto.SearchRespone;

public class GrabConnector extends BaseConnector {

    public GrabConnector(SearchEngineConstants.CabSupplier cabSupplier) {
        super(cabSupplier);
    }

    @Override
    public SearchRespone doSearch(SearchRequest searchRequest) {


        return null;
    }

}

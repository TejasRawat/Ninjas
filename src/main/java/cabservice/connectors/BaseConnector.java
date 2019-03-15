package cabservice.connectors;

import cabservice.constants.SearchEngineConstants;
import cabservice.dto.SearchRequest;
import cabservice.dto.SearchRespone;

public abstract class BaseConnector implements Connector {

    private SearchEngineConstants.CabSupplier cabSupplier;
    //Cache for reading property , integrate spring consul

    public BaseConnector(SearchEngineConstants.CabSupplier cabSupplier) {
        this.cabSupplier = cabSupplier;
    }


    @Override
    public SearchRespone doSearch(SearchRequest searchRequest) {


        return null;
    }


    public SearchEngineConstants.CabSupplier getCabSupplier() {
        return cabSupplier;
    }


}

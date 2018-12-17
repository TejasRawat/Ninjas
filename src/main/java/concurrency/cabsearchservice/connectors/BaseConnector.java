package concurrency.cabsearchservice.connectors;

import concurrency.cabsearchservice.constants.SearchEngineConstants;
import concurrency.cabsearchservice.dto.SearchRequest;
import concurrency.cabsearchservice.dto.SearchRespone;

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

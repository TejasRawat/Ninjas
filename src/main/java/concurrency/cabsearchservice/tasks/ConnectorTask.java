package concurrency.cabsearchservice.tasks;

import concurrency.cabsearchservice.connectors.Connector;
import concurrency.cabsearchservice.dto.SearchRequest;
import concurrency.cabsearchservice.dto.SearchRespone;

import java.util.concurrent.Callable;

public class ConnectorTask<ConnectorTask> implements Callable<ConnectorTask> {

    private SearchRequest searchRequest;
    private SearchRespone searchRespone;
    private Connector connector;

    public ConnectorTask() {
    }

    public ConnectorTask(SearchRequest searchRequest, SearchRespone searchRespone, Connector connector) {
        this.searchRequest = searchRequest;
        this.searchRespone = searchRespone;
        this.connector = connector;
    }


    @Override
    public ConnectorTask call() throws Exception {
        connector.doSearch(searchRequest);
        return null;
    }

    public SearchRequest getSearchRequest() {
        return searchRequest;
    }

    public void setSearchRequest(SearchRequest searchRequest) {
        this.searchRequest = searchRequest;
    }

    public SearchRespone getSearchRespone() {
        return searchRespone;
    }

    public void setSearchRespone(SearchRespone searchRespone) {
        this.searchRespone = searchRespone;
    }

    public Connector getConnector() {
        return connector;
    }

    public void setConnector(Connector connector) {
        this.connector = connector;
    }
}

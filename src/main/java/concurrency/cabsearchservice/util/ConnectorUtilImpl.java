package concurrency.cabsearchservice.util;

import concurrency.cabsearchservice.connectors.GrabConnector;
import concurrency.cabsearchservice.connectors.OlaConnector;
import concurrency.cabsearchservice.connectors.UberConnector;
import concurrency.cabsearchservice.constants.SearchEngineConstants;
import concurrency.cabsearchservice.dto.SearchRequest;
import concurrency.cabsearchservice.tasks.ConnectorTask;

import java.util.*;

public class ConnectorUtilImpl implements ConnectorUtil {

    private static ConnectorUtilImpl connectorUtil = new ConnectorUtilImpl();

    private ConnectorUtilImpl() {
    }

    public static ConnectorUtil getInstance() {
        return connectorUtil;
    }

    @Override
    public List<ConnectorTask> getConnectorTask(SearchRequest searchRequest) {
        List<ConnectorTask> tasks = new ArrayList<>();

        // Mock Data
        // Connector task contains (SearchRequest + SearchResponse + Connector)
        // Task Uber
        ConnectorTask connectorTaskUber = new ConnectorTask();
        connectorTaskUber.setConnector(new UberConnector(SearchEngineConstants.CabSupplier.Uber));
        connectorTaskUber.setSearchRequest(searchRequest);


        // Task Ola
        ConnectorTask connectorTaskOla = new ConnectorTask();
        connectorTaskOla.setConnector(new OlaConnector(SearchEngineConstants.CabSupplier.Ola));
        connectorTaskOla.setSearchRequest(searchRequest);

        // Task Grab
        ConnectorTask connectorTaskGrab = new ConnectorTask();
        connectorTaskGrab.setConnector(new GrabConnector(SearchEngineConstants.CabSupplier.Grab));
        connectorTaskGrab.setSearchRequest(searchRequest);

        tasks.add(connectorTaskUber);
        tasks.add(connectorTaskOla);
        tasks.add(connectorTaskGrab);

        return tasks;
    }
}

package concurrency.cabsearchservice.util;

import concurrency.cabsearchservice.dto.SearchRequest;
import concurrency.cabsearchservice.tasks.ConnectorTask;

import java.util.List;

public interface ConnectorUtil {

    List<ConnectorTask> getConnectorTask(SearchRequest searchRequest);


}
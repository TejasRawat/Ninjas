package cabservice.util;

import cabservice.dto.SearchRequest;
import cabservice.tasks.ConnectorTask;

import java.util.List;

public interface ConnectorUtil {

    List<ConnectorTask> getConnectorTask(SearchRequest searchRequest);


}
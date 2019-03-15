package cabservice.service;

import cabservice.dto.SearchRequest;
import cabservice.dto.SearchRespone;
import cabservice.tasks.ConnectorTask;
import cabservice.util.ConnectorUtil;
import cabservice.util.ConnectorUtilImpl;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class SearchServiceImpl implements SearchService {

    private static SearchService searchService = new SearchServiceImpl();

    private SearchServiceImpl() {
    }

    public static SearchService getInstance() {
        return searchService;
    }


    @Override
    public SearchRespone search(SearchRequest searchRequest) {
        ConnectorUtil connectorUtil = ConnectorUtilImpl.getInstance();
        List<ConnectorTask> tasks = connectorUtil.getConnectorTask(searchRequest);

        ExecutorService executor = Executors.newFixedThreadPool(5);

        List<Future<ConnectorTask>> futures = null;

        for (int i = 0; i < 5; i++) {
            ConnectorTask cTask = tasks.get(i);
            Future future = executor.submit(cTask);
            futures.add(future);
        }





        executor.shutdown();
        while (!executor.isTerminated()) {
        }
        System.out.println("Finished all threads");

        return null;
    }
}
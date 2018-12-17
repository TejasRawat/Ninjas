package concurrency.cabsearchservice.test;


import concurrency.cabsearchservice.dto.SearchRequest;
import concurrency.cabsearchservice.dto.SearchRespone;
import concurrency.cabsearchservice.service.SearchService;
import concurrency.cabsearchservice.service.SearchServiceImpl;

public class CabServiceAsynchTester {
    public static void main(String args[]) {

        SearchService searchService = SearchServiceImpl.getInstance();
        SearchRequest searchRequest = new SearchRequest();
        searchRequest.setFrom("BOM");
        searchRequest.setTo("DEL");

        SearchRespone searchRespone = searchService.search(searchRequest);
        System.out.print(searchRespone);

    }
}


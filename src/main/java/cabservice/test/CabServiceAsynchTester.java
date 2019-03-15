package cabservice.test;


import cabservice.dto.SearchRequest;
import cabservice.dto.SearchRespone;
import cabservice.service.SearchService;
import cabservice.service.SearchServiceImpl;

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


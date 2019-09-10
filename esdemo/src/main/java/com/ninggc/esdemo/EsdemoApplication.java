package com.ninggc.esdemo;

import org.elasticsearch.action.search.SearchRequestBuilder;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.search.SearchHits;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@SpringBootApplication
@RestController
@ImportResource(locations = "classpath:es.properties")
public class EsdemoApplication {

    @Autowired
    TransportClient client;
    @Value("${es.index}")
    private String index;

    public static void main(String[] args) {
        SpringApplication.run(EsdemoApplication.class, args);
    }

    @GetMapping("")
    public void app() {
        SearchRequestBuilder searchRequestBuilder = client.prepareSearch(index);
        BoolQueryBuilder queryBuilder = new BoolQueryBuilder();
        searchRequestBuilder.setQuery(queryBuilder);

        SearchResponse response = searchRequestBuilder.setExplain(true).execute().actionGet();
        SearchHits hits = response.getHits();

    }

}

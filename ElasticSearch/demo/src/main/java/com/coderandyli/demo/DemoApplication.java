package com.coderandyli.demo;

import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchRequestBuilder;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.search.SearchType;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.action.update.UpdateResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.xcontent.XContentBuilder;
import org.elasticsearch.common.xcontent.XContentFactory;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.RangeQueryBuilder;
import org.elasticsearch.search.SearchHit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;

@SpringBootApplication
@RestController
public class DemoApplication {

    @Autowired
    private TransportClient client;

    /**
     * 根据Id查询
     *
     * @param id
     * @return
     */
    @GetMapping("/get/book/novel")
    public ResponseEntity get(@RequestParam(name = "id") String id) {
        if (id.isEmpty()) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        GetResponse result = this.client.prepareGet("book", "novel", id).get();
        if (!result.isExists()) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity(result.getSource(), HttpStatus.OK);
    }

    @PostMapping("add/book/novel")
    public ResponseEntity add(@RequestParam(name = "title") String title,
                              @RequestParam(name = "author") String author,
                              @RequestParam(name = "word_count") int wordCount,
                              @RequestParam(name = "publish_date")
                              @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
                                      Date publishDate
    ) {
        try {
            System.out.println("pulish_date: " + publishDate);
            XContentBuilder content = XContentFactory.jsonBuilder().startObject()
                    .field("title", title)
                    .field("author", author)
                    .field("word_count", wordCount)
                    .field("publish_date", publishDate.getTime())
                    .endObject();

            IndexResponse result = this.client.prepareIndex("book", "novel")
                    .setSource(content)
                    .get();
            return new ResponseEntity(result.getId(), HttpStatus.OK);
        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("delete/book/novel")
    public ResponseEntity delete(@RequestParam(name = "id") String id) {
        DeleteResponse result = this.client.prepareDelete("book", "novel", id).get();
        return new ResponseEntity(result.getResult().toString(), HttpStatus.OK);
    }

    @PutMapping("update/book/novel")
    public ResponseEntity update(
            @RequestParam(name = "id") String id,
            @RequestParam(name = "title") String title,
            @RequestParam(name = "author") String author
    ) {

        UpdateRequest update = new UpdateRequest("book", "novel", id);
        try {
            XContentBuilder builder = XContentFactory.jsonBuilder()
                    .startObject();
            if (title != null) {
                builder.field("title", title);
            }
            if (author != null) {
                builder.field("author", author);
            }
            builder.endObject();
            update.doc(builder);

        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        try {
            UpdateResponse result = this.client.update(update).get();
            return new ResponseEntity(result.getResult().toString(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/query/book/novel")
    public ResponseEntity query(@RequestParam(name = "title", required = false) String title,
                                @RequestParam(name = "author", required = false) String author,
                                @RequestParam(name = "gt_word_count", defaultValue = "0") int gtWordCount,
                                @RequestParam(name = "lt_word_count", required = false) Integer ltWordCount) {

        BoolQueryBuilder boolQuery = QueryBuilders.boolQuery();
        if (title != null) {
            boolQuery.must(QueryBuilders.matchQuery("title", title));
        }
        if (author != null) {
            boolQuery.must(QueryBuilders.matchQuery("author", author));
        }

        RangeQueryBuilder rangeQuery = QueryBuilders.rangeQuery("word_count");
        if (ltWordCount != null && ltWordCount > 0) {
            rangeQuery.to(ltWordCount);
        }
        boolQuery.filter(rangeQuery);

        SearchRequestBuilder builder = this.client.prepareSearch("book")
                .setTypes("novel")
                .setSearchType(SearchType.DFS_QUERY_THEN_FETCH)
                .setQuery(boolQuery)
                .setFrom(0)
                .setSize(10);
        SearchResponse response = builder.get();
        List<Map<String, Object>> result = new ArrayList<>();
        for (SearchHit hit : response.getHits()) {
            result.add(hit.getSourceAsMap());
        }

        return new ResponseEntity(result, HttpStatus.OK);
    }

    @GetMapping("/")
    public String index() {
        return "index";
    }

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }
}


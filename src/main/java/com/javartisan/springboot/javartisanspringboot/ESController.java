package com.javartisan.springboot.javartisanspringboot;


import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.query.NativeSearchQuery;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.elasticsearch.index.query.QueryBuilders.matchQuery;


@RestController
public class ESController {

//    @Autowired
//    private TransportClient client;
//
//
//    @GetMapping("/indexes")
//    public String getIndexes() throws Exception {
//        IndexRequest request = client.prepareIndex().setId("jd").request();
//        ActionFuture<IndexResponse> res = client.index(request);
//        return res.get().getIndex();
//    }


    @Autowired
    private UserService userService;

    @Autowired
    private ElasticsearchTemplate elasticsearchTemplate;


    @GetMapping("/indexes")
    public String getIndexes() throws Exception {
        User user = new User();

        user.setName("root");
        user.setAge(18);
        user.setCreatetm("2018-12-12");
        user.setDescription("jd");
        user.setId(1L);
        userService.insert(user);

        //QueryBuilders 常用的方法
        SearchQuery searchQuery = new NativeSearchQueryBuilder().withQuery(matchQuery("name", "root")).build();
        List<User> users = elasticsearchTemplate.queryForList(searchQuery, User.class);


        user = userService.getUser(1L);
        System.out.println(user);
        user = userService.getUser(2L);
        System.out.println(user);
        return "ok";
    }


}

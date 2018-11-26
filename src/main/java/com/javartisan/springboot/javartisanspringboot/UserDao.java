package com.javartisan.springboot.javartisanspringboot;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface UserDao extends ElasticsearchRepository<User, Long> {


}

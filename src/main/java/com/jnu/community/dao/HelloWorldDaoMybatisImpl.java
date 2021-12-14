package com.jnu.community.dao;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

@Repository
@Primary
public class HelloWorldDaoMybatisImpl implements HelloWorldDao{
    @Override
    public String select() {
        return "Mybatis";
    }
}

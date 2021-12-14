package com.jnu.community.service;

import com.jnu.community.dao.HelloWorldDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Service
public class HelloWorldService {

    public HelloWorldService(){
        System.out.println("实例化");
    }

    @PostConstruct
    public void init(){
        System.out.println("初始化HelloWorldService");
    }

    @PreDestroy
    public void destroy(){
        System.out.println("销毁HelloWorldService");
    }


    @Autowired
    private HelloWorldDao helloWorldDao;

    public String getDao(){
        return helloWorldDao.select();
    }
}

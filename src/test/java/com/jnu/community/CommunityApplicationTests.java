package com.jnu.community;

import com.jnu.community.config.HelloWorldConfig;
import com.jnu.community.dao.HelloWorldDao;
import com.jnu.community.service.HelloWorldService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.SimpleDateFormat;
import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = CommunityApplication.class)
class CommunityApplicationTests implements ApplicationContextAware {

    private ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    @Test
    public void testApplicationContext(){
        System.out.println(applicationContext);
    }

    @Test
    public void testDao(){
        HelloWorldDao dao = applicationContext.getBean(HelloWorldDao.class);
        System.out.println(dao.select());
    }

    @Test
    public void testBeanManager(){
        HelloWorldService helloWorldService = applicationContext.getBean(HelloWorldService.class);
        System.out.println(helloWorldService);
    }

    @Test
    public void testConfig(){
        SimpleDateFormat simpleDateFormat = applicationContext.getBean(SimpleDateFormat.class);
        System.out.println(simpleDateFormat.format(new Date()));
    }

    @Autowired
    @Qualifier("DaoHibernate")
    private HelloWorldDao helloWorldDao;

    @Autowired
    private HelloWorldConfig helloWorldConfig;

    @Autowired
    private HelloWorldService helloWorldService;

    @Test
    public void testAutoWired(){
        System.out.println(helloWorldDao);
        System.out.println(helloWorldService);
        System.out.println(helloWorldConfig);
    }
}

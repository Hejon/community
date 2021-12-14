package com.jnu.community.dao;

import org.springframework.stereotype.Repository;

@Repository("DaoHibernate")
public class HelloWorldDaoHibernateImpl implements HelloWorldDao{
    @Override
    public String select() {
        return "Hibernate";
    }
}

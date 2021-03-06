package com.jnu.community.service;

import com.jnu.community.dao.DiscussPostMapper;
import com.jnu.community.entity.DiscussPost;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DiscussPostService {

    @Autowired
    private DiscussPostMapper discussPostMapper;

    public List<DiscussPost> selectDiscussPosts(int userId, int offset, int limit){
        List<DiscussPost> discussPosts = discussPostMapper.selectDiscussPosts(userId, offset, limit);
        return discussPosts;
    }

    public int selectDiscussPostRows(int userId){
        int rows = discussPostMapper.selectDiscussPostRows(userId);
        return rows;
    }
}

package com.caidi.springbootdemo.service.impl;

import com.caidi.springbootdemo.MybatisDao.MyBatisDao;
import com.caidi.springbootdemo.domain.MybaitsUser;
import com.caidi.springbootdemo.service.UserService;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Resource
    private MyBatisDao myBatisDao;

    @Override
    public int insert(MybaitsUser user) {
        user.setEnabled(1);
        user.setPassword("559492");
        user.setUsername("小李子");
        myBatisDao.insert(user);
        return 1;
    }

    @Override
    public List<MybaitsUser> listUser() {
        PageHelper.startPage(2,1);
        return myBatisDao.listUser();
    }

    @Override
    public MybaitsUser getUser(Integer id) {
        return null;
    }
}

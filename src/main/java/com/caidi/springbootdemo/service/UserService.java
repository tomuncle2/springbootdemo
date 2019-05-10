package com.caidi.springbootdemo.service;

import com.caidi.springbootdemo.domain.MybaitsUser;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * mybatis dao的service
 */
public interface UserService {
    int insert(MybaitsUser user);


    List<MybaitsUser> listUser();


    MybaitsUser getUser(Integer id);
}

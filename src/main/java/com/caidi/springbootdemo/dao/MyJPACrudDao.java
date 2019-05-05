package com.caidi.springbootdemo.dao;

import com.caidi.springbootdemo.domain.User;
import org.springframework.data.repository.CrudRepository;

/*
继承crud接口
 */
public interface MyJPACrudDao extends CrudRepository<User,Integer> {
}

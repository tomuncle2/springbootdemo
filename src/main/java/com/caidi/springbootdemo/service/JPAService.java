package com.caidi.springbootdemo.service;

import com.caidi.springbootdemo.domain.User;

import java.util.ArrayList;
import java.util.List;

public interface JPAService {
     void saveUser();

     void removeUser();
     void updateUser();
     User getUser(Integer uid);
     List<User> listUser();
     default List<String>  listAll(){
         return new ArrayList<>();
     }
}

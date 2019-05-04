package com.caidi.springbootdemo.domain;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="user")
public class User {
    @Id
    private Integer uid;
    private  String username;
    private  String password;
    private Integer enabled;
}

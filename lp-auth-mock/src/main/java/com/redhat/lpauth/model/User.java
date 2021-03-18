package com.redhat.lpauth.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class User {
    //
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String password;
}

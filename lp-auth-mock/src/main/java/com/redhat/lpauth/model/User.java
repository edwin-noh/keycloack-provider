package com.redhat.lpauth.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cno;

    @Column(nullable = false)
    private String name;
}

package com.example.feginclientpoc.domain;

import lombok.Value;

@Value
public class Post {

    Long id;
    Long userId;
    String title;
    String body;
}
package com.starter.play.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Post {
    private int userId;
    private int id;
    private String title;
    private String body;
    private String link;
    private int comment_count;
}

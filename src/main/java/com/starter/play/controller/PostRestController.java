package com.starter.play.controller;
import com.starter.play.model.Post;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/posts")
public class PostRestController {
    private final RestTemplate restTemplate;

    public PostRestController() {
        this.restTemplate = new RestTemplate();
    }

    @GetMapping("/rest")
    public ResponseEntity<List<Post>> getPostsWithRestTemplate() {
        String url = "https://dummy-json.mock.beeceptor.com/posts";

        ResponseEntity<Post[]> response = restTemplate.getForEntity(url, Post[].class);
        Post[] postArray = response.getBody();

        if (postArray == null) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(Arrays.asList(postArray));
    }
}

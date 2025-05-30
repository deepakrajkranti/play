package com.starter.play.mapper;
import com.starter.play.dto.PostDto;
import com.starter.play.dto.UserDto;
import com.starter.play.oneToMany.Post;
import com.starter.play.oneToMany.User;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class userPostMapper {
    public User toEntity(UserDto userDto){
        User user = new User();
        user.setUsername(userDto.getUsername());

        if (userDto.getPosts() != null) {
            for (PostDto postDto : userDto.getPosts()) {
                Post post = new Post();
                post.setContent(postDto.getContent());
                user.addPost(post); // sets both sides
            }
        }

        return user;
    }

    public UserDto toDto(User user) {
        UserDto dto = new UserDto();
        dto.setUsername(user.getUsername());

        List<PostDto> posts = user.getPosts().stream().map(post -> {
            PostDto pd = new PostDto();
            pd.setContent(post.getContent());
            return pd;
        }).collect(Collectors.toList());

        dto.setPosts(posts);
        return dto;
    }
}

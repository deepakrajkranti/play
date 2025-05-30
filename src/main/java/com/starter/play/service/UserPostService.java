package com.starter.play.service;
import com.starter.play.dto.UserDto;
import com.starter.play.mapper.userPostMapper;
import com.starter.play.oneToMany.User;
import com.starter.play.repository.UserPostRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserPostService {
    private static final Logger logger = LoggerFactory.getLogger(UserPostService.class);
    @Autowired
    private UserPostRepository userPostRepository;

    @Autowired
    private userPostMapper userPostMapper;

    public UserDto createUser(UserDto userDto) {
        logger.info("Creating user with details in Service: {}", userDto);
        User user = userPostMapper.toEntity(userDto);

        return userPostMapper.toDto(userPostRepository.save(user));
    }

    public List<UserDto> getAllUsers() {
        logger.info("Fetching all users in Service");
        return userPostRepository.findAll().stream()
                .map(userPostMapper::toDto)
                .collect(Collectors.toList());
    }
}

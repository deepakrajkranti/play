package com.starter.play.service;
import com.starter.play.onetoOne.User;
import com.starter.play.onetoOne.UserProfile;
import com.starter.play.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User createUserWithProfile(User user) {
        UserProfile profile = user.getUserProfile();

        if (profile != null) {
            user.setUserProfile(profile); // this sets both sides
        }
        return userRepository.save(user);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    public User updateUser(Long id, User updatedUser) {
        return userRepository.findById(id).map(user -> {
            user.setUsername(updatedUser.getUsername());

            UserProfile updatedProfile = updatedUser.getUserProfile();
            if (updatedProfile != null) {
                updatedProfile.setUser(user); // owning side
                user.setUserProfile(updatedProfile); // both sides
            }

            return userRepository.save(user);
        }).orElseThrow(() -> new RuntimeException("User not found"));
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}

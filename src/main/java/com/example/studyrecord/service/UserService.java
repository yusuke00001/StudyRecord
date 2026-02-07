package com.example.studyrecord.service;

import com.example.studyrecord.entity.User;
import com.example.studyrecord.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional
    public User create (String name, String email) {
        if (userRepository.existsByEmail(email)) {
            throw new IllegalArgumentException("このメールアドレスはすでに使われています");
        }
        User user = new User(name, email);
        return userRepository.save(user);
    }
}

package com.example.studyrecord.repository;

import com.example.studyrecord.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}

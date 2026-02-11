package com.example.studyrecord.repository;

import com.example.studyrecord.entity.Subject;
import com.example.studyrecord.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SubjectRepository extends JpaRepository<Subject , Long> {
  boolean existsByTitle(String title, User user);
  List<Subject> findByUser_Id(Long userId);
}

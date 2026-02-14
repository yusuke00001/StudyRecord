package com.example.studyrecord.repository;

import com.example.studyrecord.entity.Subject;
import com.example.studyrecord.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SubjectRepository extends JpaRepository<Subject , Long> {
  boolean existsByTitle(String title, User user);
  @Query("""
           select distinct s
           from Subject s
           left join fetch s.workbooks
           where s.user.id = :userId
           order by s.id desc
          """)
  List<Subject> findByUserIdWithWorkbooks(Long userId);
}
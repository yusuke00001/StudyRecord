package com.example.studyrecord.repository;

import com.example.studyrecord.entity.Subject;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubjectRepository extends JpaRepository<Subject , Long> {
}

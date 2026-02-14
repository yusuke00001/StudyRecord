package com.example.studyrecord.repository;

import com.example.studyrecord.entity.Subject;
import com.example.studyrecord.entity.Workbook;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkbookRepository extends JpaRepository<Workbook, Long> {
    boolean existsByTitle(String title, Subject subject);
}

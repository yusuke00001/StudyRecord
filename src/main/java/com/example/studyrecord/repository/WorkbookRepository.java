package com.example.studyrecord.repository;

import com.example.studyrecord.entity.Workbook;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkbookRepository extends JpaRepository<Workbook, Long> {
}

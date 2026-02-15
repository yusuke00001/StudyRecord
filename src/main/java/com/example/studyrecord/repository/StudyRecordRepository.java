package com.example.studyrecord.repository;

import com.example.studyrecord.entity.StudyRecord;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudyRecordRepository extends JpaRepository<StudyRecord, Long> {
    List<StudyRecord> findByWorkbookId(Long workbookId);
}

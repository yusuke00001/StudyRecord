package com.example.studyrecord.repository;

import com.example.studyrecord.entity.StudyRecord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudyRecordRepository extends JpaRepository<StudyRecord, Long> {
}

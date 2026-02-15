package com.example.studyrecord.service;

import com.example.studyrecord.entity.StudyRecord;
import com.example.studyrecord.entity.Workbook;
import com.example.studyrecord.repository.StudyRecordRepository;
import com.example.studyrecord.repository.WorkbookRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class StudyRecordService {

    private final StudyRecordRepository studyRecordRepository;
    private final WorkbookRepository workbookRepository;

    public StudyRecordService(StudyRecordRepository studyRecordRepository, WorkbookRepository workbookRepository) {
        this.studyRecordRepository = studyRecordRepository;
        this.workbookRepository = workbookRepository;
    }

    public StudyRecord create(LocalDate studyDate, String questionNumber, String link, Boolean result, Long workbookId) {
        Workbook workbook = workbookRepository.findById(workbookId).orElseThrow(()-> new IllegalArgumentException("参考書が存在しません"));
        StudyRecord studyRecord = new StudyRecord(studyDate, questionNumber,link, result, workbook);
        return studyRecordRepository.save(studyRecord);
    }
}

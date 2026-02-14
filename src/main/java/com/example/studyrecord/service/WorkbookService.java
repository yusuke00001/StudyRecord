package com.example.studyrecord.service;

import com.example.studyrecord.entity.Subject;
import com.example.studyrecord.entity.Workbook;
import com.example.studyrecord.repository.SubjectRepository;
import com.example.studyrecord.repository.WorkbookRepository;
import org.springframework.stereotype.Service;

@Service
public class WorkbookService {

    private final WorkbookRepository workbookRepository;
    private final SubjectRepository subjectRepository;

    public WorkbookService(WorkbookRepository workbookRepository, SubjectRepository subjectRepository) {
        this.workbookRepository = workbookRepository;
        this.subjectRepository = subjectRepository;
    }

    public Workbook create(String title, Long subjectId) {
        Subject subject = subjectRepository.findById(subjectId).orElseThrow(()-> new IllegalArgumentException("科目が存在しません"));
        if (workbookRepository.existsByTitle(title, subject)) {
            throw new IllegalArgumentException("この参考書はすでに登録されています");
        }
        Workbook workbook = new Workbook(title, subject);
        return workbookRepository.save(workbook);
    }
}

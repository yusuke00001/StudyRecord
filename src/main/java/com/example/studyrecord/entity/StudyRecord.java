package com.example.studyrecord.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class StudyRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private LocalDate studyDate;

    @Column(nullable = false)
    private String questionNumber;

    @Column
    private String link;

    @Column(nullable = true)
    private Boolean result;

    @ManyToOne(optional = false)
    @JoinColumn(name = "workbook_id", nullable = false)
    private Workbook workbook;

    public StudyRecord() {
    }

    public StudyRecord(LocalDate studyDate, String questionNumber, Workbook workbook) {
        this.studyDate = studyDate;
        this.questionNumber = questionNumber;
        this.workbook = workbook;
    }

    public Long getId() {
        return id;
    }

    public LocalDate getStudyDate() {
        return studyDate;
    }

    public String getQuestionNumber() {
        return questionNumber;
    }

    public String getLink() {
        return link;
    }
    public void changeLink(String link) {
        this.link = link;
    }

    public Boolean getResult() {
        return result;
    }
    public void changeResult(Boolean result) {
        this.result = result;
    }

    public Workbook getWorkbook() {
        return workbook;
    }
}

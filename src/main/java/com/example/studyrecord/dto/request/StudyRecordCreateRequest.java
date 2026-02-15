package com.example.studyrecord.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public class StudyRecordCreateRequest {

    @NotNull(message = "日付を入力してください")
    private LocalDate studyDate;

    @NotBlank(message = "問題番号を入力してください")
    private String questionNumber;

    private String link;

    private Boolean result;

    public StudyRecordCreateRequest() {
    }

    public StudyRecordCreateRequest(LocalDate studyDate, String questionNumber) {
        this.studyDate = studyDate;
        this.questionNumber = questionNumber;
    }

    public LocalDate getStudyDate() {
        return studyDate;
    }
    public void setStudyDate(LocalDate studyDate) {
        this.studyDate = studyDate;
    }

    public String getQuestionNumber() {
        return questionNumber;
    }
    public void setQuestionNumber(String questionNumber) {
        this.questionNumber = questionNumber;
    }

    public String getLink() {
        return link;
    }
    public void setLink(String link) {
        this.link = link;
    }

    public Boolean getResult() {
        return result;
    }
    public void setResult(Boolean result) {
        this.result = result;
    }
}

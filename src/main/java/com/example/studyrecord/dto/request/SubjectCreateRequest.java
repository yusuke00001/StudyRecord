package com.example.studyrecord.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class SubjectCreateRequest {

    @NotBlank(message = "参考書のタイトルを入力してください")
    @Size(max = 100, message = "タイトルは100文字までです")
    private String title;

    public SubjectCreateRequest() {
    }

    public SubjectCreateRequest(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}

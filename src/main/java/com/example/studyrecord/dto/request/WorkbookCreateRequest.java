package com.example.studyrecord.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class WorkbookCreateRequest {

    @NotBlank(message = "タイトルを入力してください")
    @Size(max = 50, message = "タイトルは50文字までです")
    private String title;

    public WorkbookCreateRequest() {
    }
    public WorkbookCreateRequest(String title){
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}

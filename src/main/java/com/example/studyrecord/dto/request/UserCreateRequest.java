package com.example.studyrecord.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;


public class UserCreateRequest {

    @NotBlank(message = "名前を入力してください")
    @Size(max = 50, message = "名前は50文字までです")
    private String name;

    @NotBlank(message = "メールアドレスを入力してください")
    @Size(max = 255, message = "メールアドレスは255文字までです")
    @Email
    private String email;

    public UserCreateRequest() {
    }

    public UserCreateRequest(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public String getName() {
        return name;
    }
    public String getEmail() {
        return email;
    }

}

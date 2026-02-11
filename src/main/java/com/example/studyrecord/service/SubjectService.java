package com.example.studyrecord.service;

import com.example.studyrecord.entity.Subject;
import com.example.studyrecord.entity.User;
import com.example.studyrecord.repository.SubjectRepository;
import com.example.studyrecord.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubjectService {

    private final SubjectRepository subjectRepository;
    private final UserRepository userRepository;

    public SubjectService(SubjectRepository subjectRepository, UserRepository userRepository) {
        this.subjectRepository = subjectRepository;
        this.userRepository = userRepository;
    }

    public List<Subject> index(Long userId) {
        return subjectRepository.findByUser_Id(userId);
    }

    public Subject create(String title, Long userId) {
        User user = userRepository.findById(userId).orElseThrow(()-> new IllegalArgumentException("ユーザーが存在しません"));
        Subject subject = new Subject(title, user);
        if (subjectRepository.existsByTitle(title, user)) {
            throw new IllegalArgumentException("この科目名はすでに登録されています");
        }
        return subjectRepository.save(subject);
    }
}


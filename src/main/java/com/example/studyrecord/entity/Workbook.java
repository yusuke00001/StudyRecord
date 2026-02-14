package com.example.studyrecord.entity;

import jakarta.persistence.*;

@Entity
@Table(
        uniqueConstraints = @UniqueConstraint(
                columnNames = {"subject_id", "title"}
        )
)

public class Workbook {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length= 50)
    private String title;

    @ManyToOne(optional = false)
    @JoinColumn(name = "subject_id", nullable = false)
    private Subject subject;

    public Workbook(){
    }
    public Workbook(String title, Subject subject) {
        this.title = title;
        this.subject = subject;
    }

    public Long getId() {
        return id;
    }
    public String getTitle() {
        return title;
    }
    public Subject getSubject() {
        return subject;
    }


}
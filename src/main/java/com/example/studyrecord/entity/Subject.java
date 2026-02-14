package com.example.studyrecord.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "subjects")
public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String title;

    @ManyToOne(optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @OneToMany(mappedBy = "subject")
    private List<Workbook> workbooks;

    public Subject() {
    }

    public Subject(String title, User user) {
        this.title = title;
        this.user = user;
    }

    public Long getId() {
        return id;
    }
    public String getTitle() {
        return title;
    }
    public User getUser() {
        return user;
    }
    public List<Workbook> getWorkbooks() { return workbooks; }
}

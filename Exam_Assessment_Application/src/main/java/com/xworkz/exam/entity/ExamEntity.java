package com.xworkz.exam.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.apachecommons.CommonsLog;

import javax.persistence.*;

@Getter
@Setter
@ToString
@Entity

@Table(name = "exam")
public class ExamEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name ="exam_name")
    private String examName;

    @Column(name = "total_marks")
    private int totalMarks;

    @Column(name = "difficulty_level")
    private String difficultyLevel;
}

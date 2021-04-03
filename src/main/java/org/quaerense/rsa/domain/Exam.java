package org.quaerense.rsa.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "exams")
public class Exam {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "exam")
    private List<ApplicantExam> applicantExams;

    @ManyToMany(mappedBy = "exams")
    private List<Specialty> specialties;
}

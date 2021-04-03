package org.quaerense.rsa.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "specialties")
public class Specialty {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "code")
    private String code;

    @Column(name = "name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "faculty_id")
    private Faculty faculty;

    @ManyToOne
    @JoinColumn(name = "level_of_education_id")
    private LevelOfEducation levelOfEducation;

    @OneToMany(mappedBy = "specialty")
    private List<SpecialtyFormOfEducation> specialtyFormOfEducations;

    @ManyToMany
    @JoinTable(name = "specialty_exam",
            joinColumns = @JoinColumn(name = "specialty_id"),
            inverseJoinColumns = @JoinColumn(name = "exam_id"))
    private List<Exam> exams;
}

package org.quaerense.rsa.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "forms_of_education")
public class FormOfEducation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "formOfEducation")
    private List<SpecialtyAndFormOfEducation> specialtyAndFormOfEducation;
}

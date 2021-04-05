package org.quaerense.rsa.domain;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "specialty_and_form_of_education_of_applicant")
public class SpecialtyAndFormOfEducationOfApplicant implements Serializable {
    @Id
    @ManyToOne
    @JoinColumn(name = "specialty_form_of_education_id")
    private SpecialtyAndFormOfEducation specialtyAndFormOfEducation;

    @Id
    @ManyToOne
    @JoinColumn(name = "applicant_id")
    private Applicant applicant;

    @Column(name = "points")
    private Integer points;
}

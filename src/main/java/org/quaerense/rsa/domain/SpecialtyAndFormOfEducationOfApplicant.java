package org.quaerense.rsa.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@Entity
@Table(name = "specialties_and_forms_of_education_of_applicant")
public class SpecialtyAndFormOfEducationOfApplicant implements Serializable {
    @Id
    @ManyToOne
    @JoinColumn(name = "specialty_and_form_of_education_id")
    private SpecialtyAndFormOfEducation specialtyAndFormOfEducation;

    @Id
    @ManyToOne
    @JoinColumn(name = "applicant_id")
    private Applicant applicant;

    @Column(name = "points")
    private Integer points;
}

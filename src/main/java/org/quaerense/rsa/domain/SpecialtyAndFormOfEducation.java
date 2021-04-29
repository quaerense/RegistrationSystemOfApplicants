package org.quaerense.rsa.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "specialty_and_forms_of_education")
public class SpecialtyAndFormOfEducation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "specialty_id")
    private Specialty specialty;

    @ManyToOne
    @JoinColumn(name = "form_of_education_id")
    private FormOfEducation formOfEducation;

    @Column(name = "number_of_budget_places", columnDefinition = "integer default 0")
    private Integer numberOfBudgetPlaces;
}

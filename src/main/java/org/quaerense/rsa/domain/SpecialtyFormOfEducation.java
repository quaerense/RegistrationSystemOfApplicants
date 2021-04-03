package org.quaerense.rsa.domain;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "specialty_form_of_education")
public class SpecialtyFormOfEducation implements Serializable {
    @Id
    @ManyToOne
    @JoinColumn(name = "specialty_id")
    private Specialty specialty;

    @Id
    @ManyToOne
    @JoinColumn(name = "form_of_education_id")
    private FormOfEducation formOfEducation;

    @Column(name = "number_of_budget_places", columnDefinition = "integer default 0")
    private Integer numberOfBudgetPlaces;
}

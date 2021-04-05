package org.quaerense.rsa.domain;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.sql.Date;
import java.util.List;

@Data
@Entity
@Table(name = "applicants")
public class Applicant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotNull(message = "Поле обязательно для заполнения")
    @NotBlank(message = "Поле не может быть пустым или пробелом")
    @Column(name = "first_name")
    private String firstName;

    @NotNull(message = "Поле обязательно для заполнения")
    @NotBlank(message = "Поле не может быть пустым или пробелом")
    @Column(name = "last_name")
    private String lastName;

    @Column(name = "patronymic")
    private String patronymic;

    @NotNull(message = "Поле обязательно для заполнения")
    @Column(name = "passport_series")
    private Integer passportSeries;

    @NotNull(message = "Поле обязательно для заполнения")
    @Column(name = "passport_number")
    private Integer passportNumber;

    @NotNull(message = "Поле обязательно для заполнения")
    @Column(name = "passport_issued_on")
    private Date passportIssuedOn;

    @NotNull(message = "Поле обязательно для заполнения")
    @NotBlank(message = "Поле не может быть пустым или пробелом")
    @Column(name = "passport_issued_by")
    private String passportIssuedBy;

    @Column(name = "phone_number")
    private String phone_number;

    @Email(message = "Не является адресом email")
    @Column(name = "email")
    private String email;

    @Column(name = "extra_points", columnDefinition = "integer default 0")
    private Integer extraPoints;

    @Column(name = "application_submitted_on")
    private Date applicationSubmittedOn;

    @ManyToOne
    @JoinColumn(name = "registered_by_user_id")
    private User registeredBy;

    @OneToMany(mappedBy = "applicant")
    private List<ApplicantExam> applicantExams;

    @OneToMany(mappedBy = "applicant")
    private List<SpecialtyAndFormOfEducationOfApplicant> specialtiesAndFormsOfEducationOfApplicant;
}


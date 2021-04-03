package org.quaerense.rsa.domain;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Email;
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

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "patronymic")
    private String patronymic;

    @Column(name = "passport_series")
    private Integer passportSeries;

    @Column(name = "passport_number")
    private Integer passportNumber;

    @Column(name = "passport_issued_on")
    private Date passportIssuedOn;

    @Column(name = "passport_issued_by")
    private String passportIssuedBy;

    @Column(name = "phone_number")
    private String phone_number;

    @Email
    @Column(name = "email")
    private String email;

    @Column(name = "extra_points")
    private Integer extraPoints;

    @ManyToOne
    @JoinColumn(name = "registered_by_user_id")
    private User registeredBy;

    @OneToMany(mappedBy = "applicant")
    private List<ApplicantExam> applicantExams;
}


package org.quaerense.rsa.domain;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "applicant_exam")
public class ApplicantExam implements Serializable {
    @Id
    @ManyToOne
    @JoinColumn(name = "applicant_id")
    private Applicant applicant;

    @Id
    @ManyToOne
    @JoinColumn(name = "exam_id")
    private Exam exam;

    @Column(name = "points")
    private Integer points;
}

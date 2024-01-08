package com.example.wsb.jobpost;

import com.example.wsb.user.companyhr.CompanyHR;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@SuperBuilder
public class JobPost {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer jobId;

    @Column
    private String title;

    @Column
    private String description;

    @Column
    private String requirements;

    @Column
    private Integer salary;

    @ManyToOne
    @JoinColumn(name = "company_hr_id")
    private CompanyHR companyHrId;

    public void addCompanyHr(CompanyHR companyHR) {
        setCompanyHrId(companyHR);
    }

    public void removeCompanyHr() {
        setCompanyHrId(null);
    }
}

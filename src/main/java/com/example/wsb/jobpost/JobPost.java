package com.example.wsb.jobpost;

import com.example.wsb.application.Application;
import com.example.wsb.user.User;
import com.example.wsb.user.companyhr.CompanyHR;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.List;

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

    @OneToMany(mappedBy = "jobPost", cascade = CascadeType.ALL, orphanRemoval = true)
    @ToString.Exclude
    private List<Application> application;

    @ManyToOne
    @JoinColumn(name = "companyHr")
    @ToString.Exclude
    private User companyHr;

    public void addCompanyHr(User companyHR) {
        setCompanyHr(companyHR);
    }

    public void removeCompanyHr() {
        setCompanyHr(null);
    }
}

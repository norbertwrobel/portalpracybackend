package com.example.wsb.user.companyhr;

import java.util.List;

public interface CompanyHRDao {
    List<CompanyHR> selectAllCompanyHRs();
    CompanyHR selectCompanyHRById(Integer id);
    void insertCompanyHR(CompanyHR companyHR);
    void deleteCompanyHRById(Integer companyHRId);
    void updateCompanyHR(CompanyHR update);
}

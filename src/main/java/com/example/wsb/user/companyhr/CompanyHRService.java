package com.example.wsb.user.companyhr;

import com.example.wsb.exception.ResourceNotFoundException;
import com.example.wsb.user.User;

import java.util.List;

public class CompanyHRService {
    private final CompanyHRDao companyHRDao;

    public CompanyHRService(CompanyHRDao companyHRDao) {
        this.companyHRDao = companyHRDao;
    }

    public List<CompanyHR> getAllCompanyHRs() {
        return companyHRDao.selectAllCompanyHRs();
    }

    public CompanyHR getCompanyHR(Integer id) {
        return companyHRDao.selectCompanyHRById(id);
    }

    public void createCompanyHR(User user) {
        CompanyHR companyHR = CompanyHR.builder()
                .userId(user.getUserId())
                .build();

        companyHRDao.insertCompanyHR(companyHR);
    }

    public void deleteCompanyHRById(Integer companyHRId) {
        companyHRDao.deleteCompanyHRById(companyHRId);
    }
}

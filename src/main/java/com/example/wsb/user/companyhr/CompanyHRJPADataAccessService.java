package com.example.wsb.user.companyhr;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CompanyHRJPADataAccessService implements CompanyHRDao{
    private final CompanyHRRepository companyHRRepository;

    public CompanyHRJPADataAccessService(CompanyHRRepository companyHRRepository) {
        this.companyHRRepository = companyHRRepository;
    }

    @Override
    public List<CompanyHR> selectAllCompanyHRs() {
        return companyHRRepository.findAll();
    }

    @Override
    public CompanyHR selectCompanyHRById(Integer id) {
        return companyHRRepository.getById(id);
    }

    @Override
    public void insertCompanyHR(CompanyHR companyHR) {
        companyHRRepository.save(companyHR);
    }


    @Override
    public void deleteCompanyHRById(Integer companyHRId) {
        companyHRRepository.deleteById(companyHRId);
    }

    @Override
    public void updateCompanyHR(CompanyHR update) {
        companyHRRepository.save(update);
    }
}

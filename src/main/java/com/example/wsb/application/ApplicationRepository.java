package com.example.wsb.application;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ApplicationRepository extends JpaRepository<Application, Integer> {

    boolean existsApplicationByApplicationId(Integer id);
    List<Application> findByCandidate_UserId(Integer userId);
}

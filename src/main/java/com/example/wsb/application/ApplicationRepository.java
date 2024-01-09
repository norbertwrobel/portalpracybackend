package com.example.wsb.application;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ApplicationRepository extends JpaRepository<Application, Integer> {

    boolean existsApplicationByApplicationId(Integer id);
}

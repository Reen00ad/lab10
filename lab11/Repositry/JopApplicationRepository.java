package com.example.lab11.Repositry;

import com.example.lab11.Model.JopApplication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JopApplicationRepository extends JpaRepository<JopApplication,Integer> {
}

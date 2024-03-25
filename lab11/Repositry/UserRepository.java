package com.example.lab11.Repositry;

import com.example.lab11.Model.Userr;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Userr,Integer> {
}

package com.example.lab11.Repositry;

import com.example.lab11.Model.JopPost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JopPostRepository extends JpaRepository<JopPost,Integer> {
}

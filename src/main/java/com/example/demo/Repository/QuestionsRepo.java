package com.example.demo.Repository;

import com.example.demo.Entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface QuestionsRepo extends JpaRepository<Question,Long> {
    List<Question> findByCategory(String category);

    @Query(value = "SELECT * FROM question q WHERE category=:category ORDER BY RAND() LIMIT :numQ",nativeQuery = true)
    List<Question> findRandomQuestionsByCategory(String category,int numQ);
}

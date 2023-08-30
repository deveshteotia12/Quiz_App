package com.example.demo.Controller;
import com.example.demo.Entity.Question;
import com.example.demo.Exception.UserNotFoundException;
import com.example.demo.Service.QuestionService;
import jakarta.validation.Valid;
import org.hibernate.annotations.Cache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;



@RestController
@RequestMapping("question")
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    @Autowired
    private CacheManager cacheManager;


    @GetMapping("/allQuestions")
    @Cacheable("questions")
    public ResponseEntity<List<Question>> getAllQuestion()
    {
        System.out.println("I AM HERE IN GET QUESTION METHOD");
        return questionService.getAllQuestionHandler();
    }

    @PostMapping("/saveQuestions")
    @CacheEvict(value = "questions",allEntries = true)
    public String saveQuestions(@RequestBody @Valid Question question)
    {
        return questionService.addQuestionHandler(question);
    }

    @GetMapping("/category/{category}")
    public List<Question> getQuestionByCategory(@PathVariable String category)
    {

          return questionService.getQuestionByCategory(category);
    }

    @GetMapping("/findById/{id}")
    @Cacheable("questionbyId")
    public Question getQuestionById(@PathVariable Long id) throws UserNotFoundException {
       return questionService.getQuestionById(id);
    }

}
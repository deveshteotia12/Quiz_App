package com.example.demo.Controller;
import com.example.demo.Entity.Question;
import com.example.demo.Exception.UserNotFoundException;
import com.example.demo.Service.QuestionService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("question")
public class QuestionController {

    @Autowired
    private QuestionService questionService;


    @GetMapping("/allQuestions")
    public ResponseEntity<List<Question>> getAllQuestion()
    {
        return questionService.getAllQuestionHandler();
    }

    @PostMapping("/saveQuestions")
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
    public Question getQuestionById(@PathVariable Long id) throws UserNotFoundException {
       return questionService.getQuestionById(id);
    }

}
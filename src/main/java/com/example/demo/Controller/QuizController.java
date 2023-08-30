package com.example.demo.Controller;


import com.example.demo.Entity.Question;
import com.example.demo.Entity.QuestionWrapper;
import com.example.demo.Entity.Quiz;
import com.example.demo.Entity.Response;
import com.example.demo.Exception.QuizNotFoundException;
import com.example.demo.Service.QuestionService;
import com.example.demo.Service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("quiz")
public class QuizController {


    @Autowired
   QuizService quizService;

    @PostMapping("create")
    public ResponseEntity<List<Question>> createQuiz(@RequestParam String category, @RequestParam int numQ, @RequestParam String title)
    {
        return (ResponseEntity<List<Question>>) quizService.createQuizHandler(category,numQ,title);
    }

    @GetMapping("get")
    public ResponseEntity<List<QuestionWrapper>> getQuizQuestion(@RequestParam String id) throws QuizNotFoundException {
        return quizService.getQuizQuestionHandler(id);
    }

    @PostMapping("submit/{id}")
    public ResponseEntity<Integer> submitQuiz(@PathVariable Long id,@RequestBody List<Response> responses) throws QuizNotFoundException {
        return quizService.
                getQuizResult(id,responses);
    }

}

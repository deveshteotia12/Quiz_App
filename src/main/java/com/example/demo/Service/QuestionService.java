package com.example.demo.Service;

import com.example.demo.Entity.Question;
import com.example.demo.Exception.UserNotFoundException;
import com.example.demo.Repository.QuestionsRepo;
import jakarta.validation.constraints.Null;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuestionService {

    @Autowired
    public QuestionsRepo questionsRepo;

//    @Autowired
//    public IgniteCache<Long,String> igniteCache;


    public String addQuestionHandler(Question question)
    {
        questionsRepo.save(question);
        return "Successfully Saved the Question";
    }

    public ResponseEntity<List<Question>> getAllQuestionHandler()
    {
//        Long key=1L;
//        igniteCache.put(key,"DEVESH");
        try{
            return new ResponseEntity<>(questionsRepo.findAll(),HttpStatus.OK);
        }catch (Exception e)
        {
            e.printStackTrace();
        }
       return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
    }

    public List<Question> getQuestionByCategory(String category) {
        return questionsRepo.findByCategory(category);
    }

    public Question getQuestionById(Long id) throws UserNotFoundException {
            Optional<Question> ques=questionsRepo.findById(id);
            System.out.println(ques);
            if(ques.isPresent())
            {
                return (Question)ques.orElse(null);
            }else{
                System.out.println("I AM HERE IN SYSTEM");
                throw new UserNotFoundException("User Not Found with id :" +id);
            }
    }

    //Generate
    //GetQuestions
    //GetResults
}

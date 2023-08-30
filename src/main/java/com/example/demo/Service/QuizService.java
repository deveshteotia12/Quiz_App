package com.example.demo.Service;

import com.example.demo.Entity.Question;
import com.example.demo.Entity.QuestionWrapper;
import com.example.demo.Entity.Quiz;
import com.example.demo.Entity.Response;
import com.example.demo.Exception.QuizNotFoundException;
import com.example.demo.Repository.QuestionsRepo;
import com.example.demo.Repository.QuizRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuizService {

    @Autowired
    QuestionsRepo questionsRepo;
    @Autowired
    QuizRepository quizRepository;

    @Transactional
    public ResponseEntity<List<Question>> createQuizHandler(String category, int numQ, String title)
    {
        List<Question> questions= questionsRepo.findRandomQuestionsByCategory(category,numQ);

        Quiz quiz= new Quiz();
        quiz.setTitle(title);
        quiz.setQuestions(questions);
        Quiz quiz1= quizRepository.save(quiz);
        System.out.println(quiz1);
        return new ResponseEntity<>(questions, HttpStatus.OK);
    }

    public ResponseEntity<List<QuestionWrapper>> getQuizQuestionHandler(String id) throws QuizNotFoundException {

        Optional<Quiz> quiz=quizRepository.findById( Long.parseLong(id));
        if(quiz.isPresent()) {
            List<Question> questionList = quiz.get().getQuestions();
            List<QuestionWrapper> questionData = new ArrayList<>();
            for (Question q1 : questionList) {
                QuestionWrapper questionWrapper = new QuestionWrapper(q1.getId(), q1.getCategory(), q1.getQuestion_title(), q1.getOption1(), q1.getOption2(), q1.getOption3(), q1.getOption4());
                questionData.add(questionWrapper);
            }
            return new ResponseEntity<>(questionData,HttpStatus.OK);
        }else{
              System.out.println("I AM HERE IN ELSE::");
              throw new QuizNotFoundException("Quiz you have passed id for is not there..");
        }
    }

    public ResponseEntity<Integer> getQuizResult(Long id, List<Response> responses) throws QuizNotFoundException {
        Optional<Quiz> quiz=quizRepository.findById(id);
        if(quiz.isPresent()) {
            List<Question> questionList = quiz.get().getQuestions();

            Integer rightAnswer=0;
            int ind=0;
            for(Response response: responses)
            {
                if(response.getResponse().equals(questionList.get(ind).getRight_answer()))
                {
                    rightAnswer+=1;
                }
                ind+=1;
            }
            return new ResponseEntity<>(rightAnswer,HttpStatus.OK);
        }else{
            System.out.println("I AM HERE IN ELSE::");
            throw new QuizNotFoundException("Quiz you have passed id for is not there..");
        }
    }
}

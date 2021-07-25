package service;

import entity.Quiz;
import entity.Student;

import java.util.List;

public interface QuizService {

    List<Quiz> getQuestions() throws Exception;

    void startQuiz(Student student);

}

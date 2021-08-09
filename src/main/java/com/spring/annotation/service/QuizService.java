package com.spring.annotation.service;

import com.spring.annotation.entity.Quiz;
import com.spring.annotation.entity.Student;

import java.util.List;

public interface QuizService {

    List<Quiz> getQuestions() throws Exception;

    void quizStart(Student student);

}

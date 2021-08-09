package com.spring.annotation.util;

import com.spring.annotation.entity.Quiz;

import java.util.List;

public interface CsvReader {

    List<Quiz> readQuestionsFromSource() throws Exception;
}

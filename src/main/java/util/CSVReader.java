package util;

import entity.Quiz;

import java.util.List;

public interface CSVReader {

    List<Quiz> readQuestions() throws Exception;

}

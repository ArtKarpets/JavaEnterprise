package com.spring.annotation.service;

import com.spring.annotation.util.CsvReader;
import com.spring.annotation.entity.Student;
import com.spring.annotation.entity.Quiz;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import static java.lang.System.lineSeparator;

@Service
public class QuizServiceImpl implements QuizService {

    private final CsvReader reader;
    private final MessageSource message;

    public QuizServiceImpl(CsvReader reader, MessageSource message) {
        this.reader = reader;
        this.message = message;
    }

    private void printQuestion(Quiz question) {
        System.out.println(message.getMessage("interview.number", null, Locale.getDefault()) + question.getQuestionNumber()
                + ":" + lineSeparator() + question.getQuestion() + lineSeparator()
                + message.getMessage("interview.enter", null, Locale.getDefault()));
    }

    private void printResult(Student student) {
        System.out.println(message.getMessage("student.name", null, Locale.getDefault()) + student.getName() + " "
                + student.getSurname()
                + ", " + message.getMessage("student.result1", null, Locale.getDefault()) + student.getAnswer() + " "
                + message.getMessage("student.result2", null, Locale.getDefault()));
    }

    @Override
    public List<Quiz> getQuestions() throws Exception {
        return reader.readQuestionsFromSource();
    }

    @Override
    public void quizStart(Student student) {
        try {
            List<Quiz> questions = this.getQuestions();
            int answer;
            Scanner scanner = new Scanner(System.in);
            System.out.println(message.getMessage("enter.name", null, Locale.getDefault()));
            String scan = scanner.nextLine();
            student.setName(scan);
            System.out.println(message.getMessage("enter.surname", null, Locale.getDefault()));
            scan = scanner.nextLine();
            student.setSurname(scan);
            int count = 0;
            for (Quiz question : questions) {
                printQuestion(question);
                answer = scanner.nextInt();
                if (question.getAnswer() == answer) {
                    count++;
                }
            }
            student.setAnswer(count);
            printResult(student);
        } catch (Exception e) {
            System.out.println(message.getMessage("enter.surname", null, Locale.getDefault()));
        }
    }
}
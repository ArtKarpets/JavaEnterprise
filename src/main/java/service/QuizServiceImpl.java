package service;

import entity.Quiz;
import entity.Student;
import util.CSVReader;

import java.util.List;
import java.util.Scanner;

public class QuizServiceImpl implements QuizService {

    private final CSVReader csvReader;

    public QuizServiceImpl(CSVReader csvReader) {
        this.csvReader = csvReader;
    }

    @Override
    public List<Quiz> getQuestions() throws Exception {
        return csvReader.readQuestions();
    }

    @Override
    public void startQuiz(Student student) {
        try {
            List<Quiz> questions = this.getQuestions();
            int answer;
            Scanner scanner = new Scanner(System.in);
            System.out.println("Your name:");
            String scan = scanner.nextLine();
            student.setName(scan);
            System.out.println("Your surname:");
            scan = scanner.nextLine();
            student.setSurname(scan);
            int count = 0;
            for (Quiz question : questions) {
                System.out.println(question);
                answer = scanner.nextInt();
                if (question.getAnswer() == answer) {
                    count++;
                }
            }
            student.setAnswer(count);
            System.out.println(student);
        } catch (Exception e) {
            System.out.println("You have a problem");
        }
    }
}


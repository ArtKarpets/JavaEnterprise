package com.spring.annotation;

import com.spring.annotation.service.QuizService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import com.spring.annotation.entity.Student;

@Configuration
@ComponentScan
public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(Main.class);
        QuizService service = ctx.getBean(QuizService.class);
        service.quizStart(new Student());
    }
}

import entity.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import service.QuizService;


public class Main {
    public static void main(String[] args) {

        ApplicationContext appContext = new ClassPathXmlApplicationContext("config/ApplicationContext.xml");
        QuizService service = appContext.getBean(QuizService.class);
        service.startQuiz(new Student());

    }
}

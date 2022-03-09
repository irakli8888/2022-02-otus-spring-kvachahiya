import org.springframework.context.support.ClassPathXmlApplicationContext;
import service.QuestionService;
import service.QuestionServiceImpl;

public class Main {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext classPathXmlApplicationContext =
                new ClassPathXmlApplicationContext("spring-context.xml");
        QuestionService questionServiceImp = classPathXmlApplicationContext.getBean("questionService", QuestionServiceImpl.class);
        questionServiceImp.conductTest();
    }
}

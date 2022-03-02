package domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Questionnaire {

    //ответы
    private List<Answer> answers;
    //вопрос
    private Question question;
    //верный ответ
    private Response response;

}

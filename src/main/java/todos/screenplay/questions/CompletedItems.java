package todos.screenplay.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import todos.screenplay.ui.TodoForm;

import java.util.List;

public class CompletedItems implements Question<List<String>> {

    @Override
    public List<String> answeredBy(Actor actor) {
        return Text.of(TodoForm.COMPELTED_ITEMS)
                .viewedBy(actor)
                .asList();
    }

}

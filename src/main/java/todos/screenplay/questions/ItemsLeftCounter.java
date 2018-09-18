package todos.screenplay.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import todos.screenplay.ui.TodoForm;

public class ItemsLeftCounter implements Question<Integer> {

    @Override
    public Integer answeredBy(Actor actor) {
        return Text.of(TodoForm.ITEMS_LEFT)
                .viewedBy(actor)
                .asInteger();
    }

}

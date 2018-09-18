package todos.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.thucydides.core.annotations.Step;
import todos.ui.TodoForm;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class ToggleAll implements Task {

    @Override
    @Step("{0} toggles all items in todo list")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Click.on(TodoForm.TOGGLE_ALL));
    }

    public static ToggleAll items() {
        return instrumented(ToggleAll.class);
    }

}

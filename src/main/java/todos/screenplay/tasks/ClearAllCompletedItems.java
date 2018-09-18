package todos.screenplay.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.thucydides.core.annotations.Step;
import todos.screenplay.ui.TodoForm;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class ClearAllCompletedItems implements Task {

    @Override
    @Step("{0} clears all completed items")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(TodoForm.CLEAR_COMPLETED));
    }

    public static ClearAllCompletedItems items() {
        return instrumented(ClearAllCompletedItems.class);
    }

}

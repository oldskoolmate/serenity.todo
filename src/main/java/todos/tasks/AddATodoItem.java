package todos.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Enter;
import net.thucydides.core.annotations.Step;
import todos.ui.TodoForm;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static org.openqa.selenium.Keys.RETURN;

public class AddATodoItem implements Task {

    private final String thingToDo;

    @Override
    @Step("{0} adds a todo item called: '#thingToDo'")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.theValue(thingToDo)
                        .into(TodoForm.TO_BE_DONE)
                        .thenHit(RETURN));
    }

    public static AddATodoItem called(String thingToDo) {
        return instrumented(AddATodoItem.class, thingToDo);
    }

    public AddATodoItem(String thingToDo) {
        this.thingToDo = thingToDo;
    }

}

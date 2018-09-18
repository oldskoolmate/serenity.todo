package todos.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.thucydides.core.annotations.Step;
import todos.model.Status;
import todos.ui.TodoForm;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class FilterTodoItems implements Task {

    private final Status status;

    @Override
    @Step("{0} filters items to show only #status")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(TodoForm.FILTER.of(status.name()))
        );
    }

    public static FilterTodoItems byStatus(Status status) {
        return instrumented(FilterTodoItems.class, status);
    }

    public FilterTodoItems(Status status) {
        this.status = status;
    }

}

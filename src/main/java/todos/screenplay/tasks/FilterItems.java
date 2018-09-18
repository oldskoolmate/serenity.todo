package todos.screenplay.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.thucydides.core.annotations.Step;
import todos.screenplay.model.Status;
import todos.screenplay.ui.TodoForm;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class FilterItems implements Task {

    private final Status status;

    @Override
    @Step("{0} filters items to show only #status")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(TodoForm.FILTER.of(status.name()))
        );
    }

    public static FilterItems byStatus(Status status) {
        return instrumented(FilterItems.class, status);
    }

    public FilterItems(Status status) {
        this.status = status;
    }

}

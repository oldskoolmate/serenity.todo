package todos.screenplay.tasks;

import net.serenitybdd.core.strings.Joiner;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.conditions.Check;
import net.thucydides.core.annotations.Step;
import todos.screenplay.ui.TodoHomePage;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class OpenApplication implements Task {

    private final Collection<String> items;
    private TodoHomePage todoHomePage;
    private final String todoListDescription;

    @Override
    @Step("{0} starts with #todoListDescription")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Open.browserOn().the(todoHomePage),
                Check.whether(items.isEmpty()).otherwise(AddItems.called(items)));
    }

    public static OpenApplication withAnEmptyTodoList() {
        return instrumented(OpenApplication.class, Collections.EMPTY_LIST, "no items");
    }

    public static OpenApplication withATodoListContaining(List<String> items) {
        return instrumented(OpenApplication.class, items, "a todo list containing " + Joiner.on(", ").join(items));
    }

    public OpenApplication(Collection<String> items, String todoListDescription) {
        this.items = items;
        this.todoListDescription = todoListDescription;
    }

}

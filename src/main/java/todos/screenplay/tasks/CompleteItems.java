package todos.screenplay.tasks;

import com.google.common.collect.ImmutableList;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.thucydides.core.annotations.Step;

import java.util.Collection;
import java.util.List;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class CompleteItems implements Task {

    private final List<String> todos;

    @Override
    @Step("{0} completes the todo items called: #todos")
    public <T extends Actor> void performAs(T actor) {
        todos.forEach(
                todo -> actor.attemptsTo(
                        CompleteItem.called(todo)
                )
        );
    }

    public static CompleteItems called(Collection<String> items) {
        return instrumented(CompleteItems.class, items);
    }

    public CompleteItems(List<String> items) {
        this.todos = ImmutableList.copyOf(items);
    }

}

package todos.tasks;

import com.google.common.collect.ImmutableList;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.thucydides.core.annotations.Step;

import java.util.Collection;
import java.util.List;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class CompleteTodoItems implements Task {

    private final List<String> todos;

    @Override
    @Step("{0} completes the todo items called: #todos")
    public <T extends Actor> void performAs(T actor) {
        todos.forEach(
                todo -> actor.attemptsTo(
                        CompleteTodoItem.called(todo)
                )
        );
    }

    public static CompleteTodoItems called(Collection<String> items) {
        return instrumented(CompleteTodoItems.class, items);
    }

    public CompleteTodoItems(List<String> items) {
        this.todos = ImmutableList.copyOf(items);
    }

}

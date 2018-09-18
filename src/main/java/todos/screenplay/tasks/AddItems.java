package todos.screenplay.tasks;

import com.google.common.collect.ImmutableList;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.thucydides.core.annotations.Step;

import java.util.Collection;
import java.util.List;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class AddItems implements Task {

    private final List<String> todos;

    @Override
    @Step("{0} adds the todo items called: #todos")
    public <T extends Actor> void performAs(T actor) {
        todos.forEach(
                todo -> actor.attemptsTo(
                        AddItem.called(todo))
        );
    }

    public static AddItems called(Collection<String> items) {
        return instrumented(AddItems.class, items);
    }

    public AddItems(List<String> items) {
        this.todos = ImmutableList.copyOf(items);
    }

}

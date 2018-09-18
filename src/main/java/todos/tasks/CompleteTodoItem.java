package todos.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.thucydides.core.annotations.Step;
import todos.ui.ToDoItem;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class CompleteTodoItem implements Task {

    private String itemName;

    @Override
    @Step("{0} completes the item called: #itemName")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(ToDoItem.COMPLETE.of(itemName)));
    }

    public static CompleteTodoItem called(String itemName) {
        return instrumented(CompleteTodoItem.class, itemName);
    }

    public CompleteTodoItem(String itemName) {
        this.itemName = itemName;
    }

}

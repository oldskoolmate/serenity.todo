package todos.screenplay.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.thucydides.core.annotations.Step;
import todos.screenplay.ui.ToDoItem;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class CompleteItem implements Task {

    private String itemName;

    @Override
    @Step("{0} completes the item called: #itemName")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(ToDoItem.COMPLETE.of(itemName)));
    }

    public static CompleteItem called(String itemName) {
        return instrumented(CompleteItem.class, itemName);
    }

    public CompleteItem(String itemName) {
        this.itemName = itemName;
    }

}

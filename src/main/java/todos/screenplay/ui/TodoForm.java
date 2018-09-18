package todos.screenplay.ui;

import net.serenitybdd.screenplay.targets.Target;

public class TodoForm {

    public static Target TO_BE_DONE = Target.the("'To be done' input field").locatedBy(".new-todo");
    public static Target ITEMS = Target.the("Todo items list").locatedBy(".todo-list .view label");
    public static Target ITEMS_LEFT = Target.the("Items left to be done").locatedBy(".todo-count strong");
    public static Target FILTER = Target.the("Filter hyperlink").locatedBy("//a[text()='{0}']");
    public static Target CLEAR_COMPLETED = Target.the("Clear completed button").locatedBy(".clear-completed");
    public static Target TOGGLE_ALL = Target.the("Toogle all items button").locatedBy("//*[@for='toggle-all']");
    public static Target COMPELTED_ITEMS = Target.the("Completed items").locatedBy(".completed");

}

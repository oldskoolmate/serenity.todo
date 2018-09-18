package todos.screenplay.ui;

import net.serenitybdd.screenplay.targets.Target;

public class ToDoItem {

    public static Target COMPLETE = Target.the("Complete item checkbox").locatedBy("//*[@class='view' and contains(.,'{0}')]//input[@type='checkbox']");

}
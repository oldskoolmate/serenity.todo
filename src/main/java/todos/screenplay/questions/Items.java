package todos.screenplay.questions;

import net.serenitybdd.screenplay.Question;

import java.util.List;

public class Items {

    public static Question<List<String>> displayed() {
        return new DisplayedItems();
    }

    public static Question<Integer> leftCount() {
        return new ItemsLeftCounter();
    }

    public static Question<List<String>> completed() {
        return new CompletedItems();
    }

}

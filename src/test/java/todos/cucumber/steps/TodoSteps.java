package todos.cucumber.steps;

import cucumber.api.PendingException;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import todos.model.Status;
import todos.questions.Items;
import todos.tasks.*;

import java.util.List;

import static java.util.Collections.EMPTY_LIST;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.Matchers.*;

public class TodoSteps {

    @Before
    public void set_the_stage() {
        OnStage.setTheStage(new OnlineCast());
    }

    @Given("^(\\w+) has an empty todo list$")
    public void hasAnEmptyTodoList(String actorName) {
        theActorCalled(actorName).wasAbleTo(OpenApplication.withAnEmptyTodoList());
    }

    @When("^s?he adds '(.*)' to (?:her|his) list$")
    public void addsItemToList(String item) {
        theActorInTheSpotlight().attemptsTo(AddATodoItem.called(item));
    }

    @Then("^'(.*)' should be created in (?:her|his) list$")
    public void itemShouldBeCreatedInTheList(String expectedItem) {
        theActorInTheSpotlight().should(seeThat(Items.displayed(), hasItem(expectedItem)));
    }

    @Given("^(\\w+) has items? '(.*)' in (?:her|his) todo list$")
    public void hasItemsInTodoList(String actorName, List<String> items) {
        theActorCalled(actorName).wasAbleTo(OpenApplication.withATodoListContaining(items));
    }

    @Then("^(?:her|his) todo list should contain items? '(.*)'$")
    public void usersTodoListShouldContain(List<String> expectedItems) {
        theActorInTheSpotlight().should(seeThat(Items.displayed(), equalTo(expectedItems)));
    }

    @When("^s?he completes the item called '(.*)'$")
    public void userCompletesItem(String item) {
        theActorInTheSpotlight().attemptsTo(CompleteTodoItem.called(item));
    }

    @When("^s?he completes the items called '(.*)'$")
    public void userCompletesItems(List<String> items) {
        theActorInTheSpotlight().attemptsTo(CompleteTodoItems.called(items));
    }

    @And("^s?he filters (?:her|his) list to show(?: only)? (\\w+) items$")
    public void userFiltersListBy(Status status) {
        theActorInTheSpotlight().attemptsTo(FilterTodoItems.byStatus(status));
    }

    @Then("^(?:her|his) todo list should be empty$")
    public void todoListShouldBeEmpty() {
        theActorInTheSpotlight().should(seeThat(Items.displayed(), equalTo(EMPTY_LIST)));
    }

    @When("^s?he clears all completed items$")
    public void userClicksOnClearCompletedButton() {
        theActorInTheSpotlight().attemptsTo(ClearAllCompleted.items());
    }

    @When("^s?he toggles the status of all items$")
    public void userTogglesTheStatusOfAllItems() {
        theActorInTheSpotlight().attemptsTo(ToggleAll.items());
    }

    @Then("^s?he should see (\\d+) items? left on (?:her|his) todo list counter$")
    public void itemLeftOnTodoListCounter(int count) {
        theActorInTheSpotlight().should(seeThat(Items.leftCount(), is(count)));
    }

    @Given("^(\\w+) has completed items '(.*)' in (?:her|his) todo list$")
    public void johnHasCompletedItemsFixMyCarWalkTheDogInHisTodoList(String actorName, List<String> items) throws Throwable {
        hasItemsInTodoList(actorName, items);
        userCompletesItems(items);
    }
}

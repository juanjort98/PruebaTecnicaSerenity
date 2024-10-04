package org.com.screenplay.project.stepdefinition;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import org.com.screenplay.project.tasks.SelectCategory;
import org.com.screenplay.project.tasks.SelectProduct;

import static org.com.screenplay.project.utils.Constants.ACTOR;

public class OpenWebStep {

    @Before
    public void setStage(){
        OnStage.setTheStage(new OnlineCast());
    }


    @Given("Juan selects a category in the navigation bar")
    public void juanSelectsACategory() {
        OnStage.theActorCalled(ACTOR).attemptsTo(
                SelectCategory.choose("Amor")
        );
    }

    @When("Adds a product from the selected category to the shopping cart")
    public void addsAProductFromTheSelectedCategory() {
        OnStage.theActorCalled(ACTOR).attemptsTo(
                SelectProduct.chooseProduct("1")
        );
    }

    @Then("Should see the product's name in the shopping cart view")
    public void shouldSeeTheProductNameInTheShoppingCartView() {
    }
}

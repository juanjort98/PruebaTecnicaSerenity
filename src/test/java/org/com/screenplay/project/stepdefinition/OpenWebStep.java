package org.com.screenplay.project.stepdefinition;

import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import org.com.screenplay.project.questions.ValidateProductCode;
import org.com.screenplay.project.tasks.KeepShopping;
import org.com.screenplay.project.tasks.SelectCategory;
import org.com.screenplay.project.tasks.SelectProduct;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
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

    @And("Goes back to the product selection view to add a new product")
    public void goesBackToTheProductSelectionViewToAddANewProduct() {

        OnStage.theActorCalled(ACTOR).attemptsTo(
                KeepShopping.chooseNewProduct(),
                SelectProduct.chooseProduct("2")
        );

    }


    @Then("Should see the added product's name in the shopping cart view")
    public void shouldSeeTheAddedProductSNameInTheShoppingCartView() {
        String validTextOne = "MDF 0001";
        String validTextTwo = "MDF 0010";

        theActorInTheSpotlight().should(seeThat(ValidateProductCode.validation(validTextOne,validTextTwo)));

    }
}

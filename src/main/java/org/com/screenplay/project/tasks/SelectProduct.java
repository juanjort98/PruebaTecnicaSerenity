package org.com.screenplay.project.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.MoveMouse;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static org.com.screenplay.project.ui.HomeUI.ADD_CART_BUTTON;
import static org.com.screenplay.project.ui.HomeUI.PRODUCT_SELECT;

public class SelectProduct implements Task {

    private String option;

    public SelectProduct(String option) {
        this.option = option;
    }

    public Target productOption(String option){
        return PRODUCT_SELECT.of(option);
    }
    public Target addCartButton(String option){
        return  ADD_CART_BUTTON.of(option);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        Target product = productOption(option);
        Target cartButton = addCartButton(option);
        actor.attemptsTo(
                MoveMouse.to(product),
                WaitUntil.the(cartButton,isVisible()).forNoMoreThan(2).seconds(),
                Click.on(cartButton)
        );

    }
    public static SelectProduct chooseProduct(String option) {
        return Tasks.instrumented(SelectProduct.class, option);
    }
}

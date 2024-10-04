package org.com.screenplay.project.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static org.com.screenplay.project.ui.HomeUI.KEEP_SHOPPING_BTN;

public class KeepShopping implements Task {


    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(KEEP_SHOPPING_BTN,isVisible()).forNoMoreThan(5).seconds(),
                Click.on(KEEP_SHOPPING_BTN)

        );
    }
    public static KeepShopping  chooseNewProduct() {
        return Tasks.instrumented(KeepShopping .class);
    }
}

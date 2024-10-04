package org.com.screenplay.project.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isEnabled;
import static org.com.screenplay.project.ui.HomeUI.NAV_BAR_ELEMENTS;


public class SelectCategory implements Task {

    private String nameOfCategory;

    public SelectCategory(String nameOfCategory) {
        this.nameOfCategory = nameOfCategory;
    }

    public Target navBarElement(String category) {
        return NAV_BAR_ELEMENTS.of(category);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        Target target = navBarElement(nameOfCategory);
        actor.attemptsTo(WaitUntil.the(target, isEnabled()).forNoMoreThan(5).seconds(),
                Click.on(target));
    }

    public static SelectCategory choose(String nameOfCategory) {
        return Tasks.instrumented(SelectCategory.class, nameOfCategory);
    }
}

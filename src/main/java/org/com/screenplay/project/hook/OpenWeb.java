package org.com.screenplay.project.hook;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class OpenWeb  implements Task {


    @Override
    public <T extends Actor> void performAs(T actor) {
        String pathWebUrl = "https://www.floristeriamundoflor.com/";
        actor.attemptsTo(Open.url(pathWebUrl));
    }

    public static Performable   browserURL(){
        return instrumented(OpenWeb.class);
    }
}

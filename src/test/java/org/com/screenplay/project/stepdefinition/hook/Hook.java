package org.com.screenplay.project.stepdefinition.hook;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import org.com.screenplay.project.hook.OpenWeb;

import static org.com.screenplay.project.utils.Time.waiting;

public class Hook {

    @Before
    public void setTheStage(){
        OnStage.setTheStage(new OnlineCast());
    }

    @Given("{string} opens the testing web page")
    public void openTestingPage(String actor){
        OnStage.theActorCalled(actor).attemptsTo(
                OpenWeb.browserURL()
        );
        waiting(5);
    }



}

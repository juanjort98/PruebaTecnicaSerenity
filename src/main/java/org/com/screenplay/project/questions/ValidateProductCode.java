package org.com.screenplay.project.questions;

import groovy.util.logging.Slf4j;
import lombok.AllArgsConstructor;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.targets.Target;

import static org.com.screenplay.project.ui.HomeUI.PRODUCT_IN_TABLE;

@AllArgsConstructor
@Slf4j
public class ValidateProductCode implements Question<Boolean> {

    private String validateFirstElement;
    private String validateSecondElement;

    @Override
    public Boolean answeredBy(Actor actor) {
        boolean result;


        Target firstProduct = PRODUCT_IN_TABLE.of("1");
        Target secondProduct = PRODUCT_IN_TABLE.of("2");

        String firstProductText = firstProduct.resolveFor(actor).getText();
        String secondProductText = secondProduct.resolveFor(actor).getText();
        System.out.println("first product: " + firstProductText);
        System.out.println("second product: " + secondProductText);

        return validateFirstElement != null && validateSecondElement != null
                && validateFirstElement.equals(firstProductText)
                && validateSecondElement.equals(secondProductText);
    }



    public static ValidateProductCode validation(String validateFirstElement, String validateSecondElement){
        return new ValidateProductCode(validateFirstElement,validateSecondElement);
    }
}

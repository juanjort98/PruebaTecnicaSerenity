package org.com.screenplay.project.ui;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;



public class HomeUI extends PageObject {



    public static final Target  NAV_BAR_ELEMENTS = Target.the("Button in nav bar category")
            .locatedBy("//ul[@class = 'nav navbar-nav megamenu']/descendant::a[text()='{0}']");
    public static final Target  PRODUCT_SELECT = Target.the("Product Selected")
            .locatedBy("(//div[@class = 'product-block grid'])[{0}]");
    public static final Target  ADD_CART_BUTTON = Target.the("Add Cart Button")
            .locatedBy("(//div[@class = 'product-block grid'])[{0}]//a/child::span[text()='Añadir al carrito']");
    public static final Target  KEEP_SHOPPING_BTN = Target.the("Button to go back to product selection")
            .locatedBy("//a[text()='Seguir comprando']");
    public static final Target  PRODUCT_IN_TABLE = Target.the("Product added to shopping cart")
            .locatedBy("(//td[@class = 'product-name'])[{0}]");

}

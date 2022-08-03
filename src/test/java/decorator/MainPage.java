package decorator;

import org.openqa.selenium.By;

public class MainPage {
    private final Driver driver;
    private final String url = "http://demos.bellatrix.solutions/";

    public MainPage(Driver driver) {
        this.driver = driver;
    }

    private Element addToCartFalcon9() {
        return driver.findElement(By.cssSelector("[data-product_id*='28']"));
    }

    private Element viewCartButton() {
        return driver.findElement(By.cssSelector("[class*='added_to_cart wc-forward']"));
    }

    public void addRocketToShoppingCart() {
        driver.goToUrl(url);
        addToCartFalcon9().click();
        viewCartButton().click();
    }
}

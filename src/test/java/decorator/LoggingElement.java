package decorator;

import org.openqa.selenium.By;

public class LoggingElement extends ElementDecorator {
    protected LoggingElement(Element element) {
        super(element);
    }

    @Override
    public By getBy() {
        return element.getBy();
    }

    @Override
    public String getText() {
        System.out.print(String.format("Element Text = %s", element.getText()));
        System.out.print("\n");
        return element.getText();
    }

    @Override
    public Boolean isEnabled() {
        System.out.print(String.format("Element Enabled = %b", element.isEnabled()));
        System.out.print("\n");
        return element.isEnabled();
    }

    @Override
    public Boolean isDisplayed() {
        System.out.print(String.format("Element Displayed = %b", element.isDisplayed()));
        System.out.print("\n");
        return element.isDisplayed();
    }

    @Override
    public void typeText(String text) {
        System.out.print(String.format("Type Text = %s", text));
        System.out.print("\n");
        element.typeText(text);
    }

    @Override
    public void click() {
        System.out.print(String.format("Element Clicked %s", element));
        System.out.print("\n");
        element.click();
    }

    @Override
    public String getAttribute(String attributeName) {
        System.out.print("Element Clicked");
        return element.getAttribute(attributeName);
    }
}

package decorator;

public class LoggingElement extends ElementDecorator {
    protected LoggingElement(Element element) {
        super(element);
    }

    @Override
    public String getText() {
        System.out.printf("Element Text = %s", element.getText());
        System.out.print("\n");
        return element.getText();
    }

    @Override
    public void typeText(String text) {
        System.out.printf("Type Text = %s", text);
        System.out.print("\n");
        element.typeText(text);
    }

    @Override
    public void click() {
        System.out.printf("Element Clicked %s", element);
        System.out.print("\n");
        element.click();
    }
}

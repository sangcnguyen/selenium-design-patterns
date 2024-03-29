package decorator;

public class LoggingElement extends ElementDecorator {
    protected LoggingElement(Element element) {
        super(element);
    }

    @Override
    public String getText() {
        System.out.print(String.format("Element Text = %s", element.getText()));
        System.out.print("\n");
        return element.getText();
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
}

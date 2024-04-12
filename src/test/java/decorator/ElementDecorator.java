package decorator;

public class ElementDecorator extends Element {
    protected final Element element;

    protected ElementDecorator(Element element) {
        this.element = element;
    }

    @Override
    public String getText() {
        return element.getText();
    }

    @Override
    public void typeText(String text) {
        element.typeText(text);
    }

    @Override
    public void click() {
        element.click();
    }

    @Override
    public String getAttribute(String attributeName) {
        return null;
    }
}

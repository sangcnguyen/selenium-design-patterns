package decorator;

public abstract class Element {
    public abstract String getText();

    public abstract void typeText(String text);

    public abstract void click();

    public abstract String getAttribute(String attributeName);
}

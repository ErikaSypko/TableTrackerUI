package decorator.element;

import decorator.Element;
import org.openqa.selenium.WebElement;

public class TextArea extends Element {
    public TextArea(WebElement webElement) {
        super(webElement);
    }

    public String getText() {
        return webElement.getText();
    }
}

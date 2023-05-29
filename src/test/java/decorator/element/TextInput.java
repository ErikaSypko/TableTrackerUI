package decorator.element;

import decorator.Element;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public class TextInput extends Element {
    public TextInput(WebElement webElement) {
        super(webElement);
    }

    public void sendKeysInEmptyField(CharSequence keyToSend) {
        webElement.clear();
        webElement.sendKeys(keyToSend, Keys.ENTER);
    }
}

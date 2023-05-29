package decorator.element;

import decorator.Element;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import util.WebDriverSingleton;

public class Button extends Element {
    public Button(WebElement webElement) {
        super(webElement);
    }

    public void safeClick() {
        try {
            super.click();
        } catch (Exception e) {
            JavascriptExecutor executor = (JavascriptExecutor) WebDriverSingleton.getInstance();
            executor.executeScript("arguments[0].click();", webElement);
        }
    }

    public boolean isButtonDisabled() {
        return webElement.getAttribute("disabled") != null;
    }
}
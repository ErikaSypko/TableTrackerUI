package page;

import decorator.element.Button;
import decorator.element.TextArea;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{
    @FindBy(xpath = "//mat-icon[text()='logout']")
    private Button logoutButton;

    @FindBy(xpath = "//span[text()='Juan11']")
    private TextArea userLabel;


    public HomePage() {
        super();
    }

    public boolean ifLogoutButtonExist() {
        return logoutButton.isDisplayed();
    }

    public boolean ifUserExist() {
        return userLabel.isDisplayed();
    }




}

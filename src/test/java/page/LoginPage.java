package page;

import decorator.element.Button;
import decorator.element.TextArea;
import decorator.element.TextInput;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

import java.util.List;

public class LoginPage extends BasePage {
    @FindBy(xpath = "//input[@ng-reflect-name='email']")
    private TextInput emailField;

    @FindBy(xpath = "//input[@ng-reflect-name='password']")
    private TextInput passwordField;

    @FindBy(xpath = "//button/span[text()='Log in']")
    private Button loginButton;

    @FindBy(xpath = "//div[@class='error ng-star-inserted']")
    private TextArea authenticationErrorMessage;

    @FindBy(xpath = "//button[@ng-reflect-disabled='true']")
    private Button disabledLoginButton;

    @FindBys(@FindBy(xpath = "//em[@class='ng-star-inserted']"))
    private List<TextArea> missingCredentialsErrorMessages;

    public LoginPage() {
        super();
    }

    public void setEmailField(String email) {
        emailField.sendKeysInEmptyField(email);
    }

    public void setPasswordField(String password) {
        passwordField.sendKeysInEmptyField(password);
    }

    public void clickOnLoginButton() {
        loginButton.safeClick();
    }

    public String getAuthenticationErrorMessage() {
        return authenticationErrorMessage.getText();
    }

    public boolean isLoginButtonDisabled() {
        return disabledLoginButton.isButtonDisabled();
    }

    public String getEmailWarningMessage() {
        return missingCredentialsErrorMessages.stream()
                .findFirst().get().getText();
    }

    public String getPasswordWarningMessage() {
        return missingCredentialsErrorMessages.stream()
                .reduce((first, second) -> second).get().getText();
    }
}

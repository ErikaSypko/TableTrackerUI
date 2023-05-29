package step;

import lombok.extern.slf4j.Slf4j;
import page.LoginPage;

@Slf4j
public class LoginBL {
    private LoginPage loginPage;

    public LoginBL() {
        this.loginPage = new LoginPage();
    }

    public LoginBL login(String email, String password) {
        loginPage.setEmailField(email);
        log.info("Email field is filled with: " + email);
        loginPage.setPasswordField(password);
        log.info("Password field is filled with: " + password);
        loginPage.clickOnLoginButton();
        log.info("Login button is clicked");
        return this;
    }
    public String getLoginErrorMessage() {
        return loginPage.getAuthenticationErrorMessage();
    }

    public LoginBL loginWithMissingCredentials(String email, String password) {
        loginPage.setEmailField(email);
        log.info("Email field is filled with: " + email);
        loginPage.setPasswordField(password);
        log.info("Password field is filled with: " + password);
        loginPage.setEmailField(email);
        return this;
    }

    public boolean isLoginButtonDisabled() {
        return loginPage.isLoginButtonDisabled();
    }

    public String getEmailWarningMessage() {
        return loginPage.getEmailWarningMessage();
    }

    public String getPasswordWarningMessage() {
        return loginPage.getPasswordWarningMessage();
    }
}

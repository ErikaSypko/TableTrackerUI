package step;

import com.epam.reportportal.listeners.LogLevel;
import com.epam.reportportal.service.ReportPortal;
import lombok.extern.slf4j.Slf4j;
import page.LoginPage;

import java.util.Date;

@Slf4j
public class LoginBL {
    private LoginPage loginPage;

    public LoginBL() {
        this.loginPage = new LoginPage();
    }

    public LoginBL login(String email, String password) {
        loginPage.setEmailField(email);
        log.info("Email field is filled with: " + email);
        ReportPortal.emitLog("Email field is filled with: " + email, LogLevel.INFO.name(), new Date());
        loginPage.setPasswordField(password);
        log.info("Password field is filled with: " + password);
        ReportPortal.emitLog("Password field is filled with: " + password, LogLevel.INFO.name(), new Date());
        loginPage.clickOnLoginButton();
        log.info("Login button is clicked");
        ReportPortal.emitLog("Login button is clicked", LogLevel.INFO.name(), new Date());
        return this;
    }
    public String getLoginErrorMessage() {
        return loginPage.getAuthenticationErrorMessage();
    }

    public LoginBL loginWithMissingCredentials(String email, String password) {
        loginPage.setEmailField(email);
        log.info("Email field is filled with: " + email);
        ReportPortal.emitLog("Email field is filled with: " + email, LogLevel.INFO.name(), new Date());
        loginPage.setPasswordField(password);
        log.info("Password field is filled with: " + password);
        ReportPortal.emitLog("Password field is filled with: " + password, LogLevel.INFO.name(), new Date());
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

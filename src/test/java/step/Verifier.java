package step;

import org.testng.asserts.SoftAssert;
import util.PropertiesReader;
import util.WebDriverSingleton;

public class Verifier {
    private PropertiesReader propertiesReader = new PropertiesReader();

    public void checkLoginSuccess(HomeBL homeBL) {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(WebDriverSingleton.getInstance().getCurrentUrl(), propertiesReader.getSocketAddress() + propertiesReader.getHomeEndpoint(), "User is not logged in");
        softAssert.assertTrue(homeBL.isUserLoggedIn(), "User is not logged in");

    }

    public void checkIfLoginWithInvalidCredsFailed(LoginBL loginBL) {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(loginBL.getLoginErrorMessage(), propertiesReader.getAuthenticationErrorMessage(), "Error message is not appropriate");
        softAssert.assertAll();
    }

    public void checkIfUserIsNotLoggedInWithMissingCredentials(LoginBL loginBL) {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(WebDriverSingleton.getInstance().getCurrentUrl(), propertiesReader.getSocketAddress() + propertiesReader.getLoginEndpoint(), "Unappropriated page is opened");
        softAssert.assertTrue(loginBL.isLoginButtonDisabled(), "Login button is active");
        softAssert.assertAll();
    }

    public void checkIfUserSeesAnErrorMessageIndicatingMissingCredentials(LoginBL loginBL) {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(loginBL.getEmailWarningMessage(), propertiesReader.getMissingEmailErrorMessage(), "Error message is not appropriate");
        softAssert.assertEquals(loginBL.getPasswordWarningMessage(), propertiesReader.getMissingPasswordErrorMessage(), "Error message is not appropriate");
        softAssert.assertAll();
    }
}

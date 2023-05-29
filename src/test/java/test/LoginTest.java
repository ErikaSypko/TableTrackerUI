package test;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import step.HomeBL;
import step.LoginBL;
import step.Verifier;
import util.WebDriverSingleton;

public class LoginTest extends BaseTest {

    @BeforeMethod
    public void testsSetUP() {
        WebDriverSingleton.getInstance().manage().window().maximize();
        WebDriverSingleton.getInstance().get(SOCKET_ADDRESS + LOGIN_ENDPOINT);
    }


    @Test
    public void loginTest() {
        LoginBL loginBL = new LoginBL();
        HomeBL homeBL = new HomeBL();
        Verifier verifier = new Verifier();
        loginBL.login(propertiesReader.getEmail(), propertiesReader.getPassword());
        verifier.checkLoginSuccess(homeBL);
    }
}

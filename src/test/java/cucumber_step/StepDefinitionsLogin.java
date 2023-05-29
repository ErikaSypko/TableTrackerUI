package cucumber_step;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import step.HomeBL;
import step.LoginBL;
import step.Verifier;
import test.BaseTest;
import util.WebDriverSingleton;

public class StepDefinitionsLogin extends BaseTest {
    LoginBL loginBL;
    HomeBL homeBL;
    Verifier verifier;

    @Before
    public void testsSetUP() {
        WebDriverSingleton.getInstance().manage().window().maximize();
        WebDriverSingleton.getInstance().get(SOCKET_ADDRESS + LOGIN_ENDPOINT);
        loginBL = new LoginBL();
        homeBL = new HomeBL();
        verifier = new Verifier();
    }

    @Given("I login with valid email and password")
    public void iLoginWithValidEmailAndPassword() {
        loginBL.login(propertiesReader.getEmail(), propertiesReader.getPassword());
    }

    @Then("I should be successfully signed in")
    public void iShouldBeSuccessfullySignedIn() {
        verifier.checkLoginSuccess(homeBL);
    }

    @Given("I login with invalid email and password")
    public void iLoginWithInvalidEmailAndPassword() {
        loginBL.login(propertiesReader.getInvalidEmail(), propertiesReader.getInvalidPassword());

    }

    @Then("I should see an error message indicating invalid credentials")
    public void iShouldSeeAnErrorMessageIndicatingInvalidCredentials() {
        verifier.checkIfLoginWithInvalidCredsFailed(loginBL);
    }

    @Given("I leave the email and password field blank")
    public void iLeaveTheEmailAndPasswordFieldBlank() {
        loginBL.loginWithMissingCredentials(propertiesReader.getBlankEmail(), propertiesReader.getBlankPassword());

    }

    @Then("I should see an error message indicating missing credentials")
    public void iShouldSeeAnErrorMessageIndicatingMissingCredentials() {
        verifier.checkIfUserSeesAnErrorMessageIndicatingMissingCredentials(loginBL);
    }

    @And("I shouldn't be able to sign in")
    public void iShouldnTBeAbleToSignIn() {
        verifier.checkIfUserIsNotLoggedInWithMissingCredentials(loginBL);
    }

    @After
    public void tearDown() {
        WebDriverSingleton.close();
    }
}

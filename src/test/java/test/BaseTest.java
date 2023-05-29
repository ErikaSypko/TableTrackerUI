package test;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import util.PropertiesReader;
import util.WebDriverSingleton;

public class BaseTest {
    protected PropertiesReader propertiesReader = new PropertiesReader();
    protected static final String SOCKET_ADDRESS = new PropertiesReader().getSocketAddress();
    protected static final String HOME_ENDPOINT = new PropertiesReader().getHomeEndpoint();
    protected static final String LOGIN_ENDPOINT = new PropertiesReader().getLoginEndpoint();

    @AfterMethod
    public void tearDown() {
        WebDriverSingleton.close();
    }


}

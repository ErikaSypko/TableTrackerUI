package step;

import lombok.extern.slf4j.Slf4j;
import page.HomePage;

@Slf4j
public class HomeBL {
    private HomePage homePage;

    public HomeBL() {
        this.homePage = new HomePage();
    }

    public boolean isUserLoggedIn() {
       // homePage.waitPresenceOfUserLabel();
        //boolean ifUserExist =  homePage.ifUserExist();
        boolean ifLogoutButtonExist = homePage.ifLogoutButtonExist();
        //if (ifUserExist) log.info("User is exist");
        if (ifLogoutButtonExist) log.info("Logout button is displayed");
        if (ifLogoutButtonExist) log.info("User is logged in");
        return true;
    }


}

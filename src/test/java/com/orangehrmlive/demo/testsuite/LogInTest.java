package com.orangehrmlive.demo.testsuite;

import com.orangehrmlive.demo.pages.HomePage;
import com.orangehrmlive.demo.pages.LoginPage;
import com.orangehrmlive.demo.testbase.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LogInTest extends TestBase {

    LoginPage loginPage;
    HomePage homePage;

    @BeforeMethod
    public void inIt() {
        loginPage = new LoginPage();
        homePage = new HomePage();

    }
    @Test(groups = {"sanity","regression"})
    public void verifyUserShouldLoginSuccessFully() {
        loginPage.logInToApplication("Admin", "admin123");
        String actMsg = homePage.verifyWelcomeText().substring(0, 7);
        Assert.assertEquals(actMsg, "Welcome", "error");

    }

    @Test(groups = {"smoke","regression"})
    public void verifyThatTheLogoDisplayOnHomePage() {
        loginPage.logInToApplication("Admin", "admin123");
        homePage.verifyLogo();

    }

    @Test(groups = {"regression"})
    public void verifyUserShouldLogOutSuccessFully() throws InterruptedException {
        loginPage.logInToApplication("Admin", "admin123");
        homePage.clkOnLogout();
        Assert.assertEquals(homePage.verifyLogInPanelText(), "Login Panel", "error");


    }


}

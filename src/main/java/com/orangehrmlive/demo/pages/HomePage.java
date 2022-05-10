package com.orangehrmlive.demo.pages;


import com.orangehrmlive.demo.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import static com.orangehrmlive.demo.driverfactory.ManageDriver.driver;


public class HomePage extends Utility {

    public HomePage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//img[@alt='OrangeHRM']")
    WebElement logo;
    @FindBy(xpath = "//b[contains(text(),'Admin')]")
    WebElement adminText;
    @FindBy(xpath = "//b[contains(text(),'PIM')]")
    WebElement pimText;
    @FindBy(xpath = "//b[contains(text(),'Leave')]")
    WebElement leaveText;
    @FindBy(xpath = "//b[contains(text(),'Dashboard')]")
    WebElement dashboardText;
    @FindBy(xpath = "//a[@id='welcome']")
    WebElement welcomeText;
    @FindBy(xpath = "//a[@id='welcome']")
    WebElement profileLogo;
    @FindBy(xpath = "//a[contains(text(),'Logout')]")
    WebElement logOut;
    @FindBy(xpath = "//div[@id='logInPanelHeading']")
    WebElement logInPanelText;

    public String verifyLogInPanelText(){
        return getTextFromElement(logInPanelText);
    }
    public void clkOnLogout() throws InterruptedException {
        clickOnElement(profileLogo);
        Thread.sleep(1000);
        clickOnElement(logOut);
    }
    public String verifyWelcomeText() {
        return getTextFromElement(welcomeText);
    }

    public String verifyDashBoardText() {
        return getTextFromElement(dashboardText);
    }

    public String verifyLeaveText() {
        return getTextFromElement(leaveText);
    }

    public String verifyPimText() {
        return getTextFromElement(pimText);
    }

    public String verifyAdminText() {
        return getTextFromElement(adminText);
    }

    public void clkOnAdminTab() {
        clickOnElement(adminText);
    }

    public void verifyLogo() {
        Boolean logoPresent = logo.isDisplayed();
        Assert.assertTrue(logoPresent);
        if (logoPresent) {
            System.out.println("Logo present");
        } else {
            System.out.println("Logo not present");
        }
    }
}


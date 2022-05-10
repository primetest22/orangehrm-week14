package com.orangehrmlive.demo.pages;


import com.orangehrmlive.demo.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LoginPage extends Utility {

    public LoginPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@id='txtUsername']")
    WebElement userName;
    @FindBy(xpath = "//input[@id='txtPassword']")
    WebElement password;
    @FindBy(xpath = "//input[@id='btnLogin']")
    WebElement logBtn;
    @FindBy(xpath = "//div[@id='logInPanelHeading']")
    WebElement logPanelText;


    public String verifyLogPanelText() {
        return getTextFromElement(logPanelText);
    }

    public void clkOnLogBtn() {
        clickOnElement(logBtn);
    }

    public void enterUserName(String user) {
        sendTextToElement(userName, user);
    }

    public void enterPassword(String pswd) {
        sendTextToElement(password, pswd);
    }
    public void logInToApplication(String user,String pass){
        enterUserName(user);
        enterPassword(pass);
        clkOnLogBtn();
    }


}

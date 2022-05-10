package com.orangehrmlive.demo.pages;

import com.orangehrmlive.demo.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SystemUsersPage extends Utility {

    public SystemUsersPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//h1[contains(text(),'System Users')]")
    WebElement systemUserText;
    @FindBy(xpath = "//input[@id='btnAdd']")
    WebElement addBtn;
    @FindBy(xpath = "//h1[@id='UserHeading']")
    WebElement addUerText;
    @FindBy(xpath = "//select[@id='systemUser_userType']")
    WebElement clkUserRol;
    @FindBy(xpath = "//select[@id='systemUser_userType']")
    WebElement selectAdmin;
    @FindBy(xpath = "//input[@id='systemUser_employeeName_empName']")
    WebElement empName;
    @FindBy(xpath = "//input[@id='systemUser_userName']")
    WebElement usrName;
    @FindBy(xpath = "//select[@id='systemUser_status']")
    WebElement status;
    @FindBy(xpath = "//select[@id='systemUser_status']")
    WebElement selectDisable;
    @FindBy(xpath = "//input[@id='systemUser_password']")
    WebElement pass;
    @FindBy(xpath = "//input[@id='systemUser_confirmPassword']")
    WebElement confirmPass;
    @FindBy(xpath = "//input[@id='btnSave']")
    WebElement save;
    @FindBy(xpath = "//div[contains(text(),'Successfully Saved')]")
    WebElement saveMsg;


    public String verifySaveMsg() {
        return getTextFromElement(saveMsg);
    }

    public void clkSaveBtn() {
        clickOnElement(save);
    }

    public void enterCnfPass(String cnfm) {
        sendTextToElement(confirmPass, cnfm);
    }

    public void enterPass(String password) {
        sendTextToElement(pass, password);
    }

    public void selectDisable(String disable) {
        selectByVisibleTextFromDropDown(selectDisable, disable);
    }

    public void enterUsrName(String usr) {
        sendTextToElement(usrName, usr);
    }

    public void enterEmpName(String emname) {
        sendTextToElement(empName, emname);
    }

    public void selectAdminValue(String text) {
        selectByVisibleTextFromDropDown(selectAdmin, text);
    }

    public void clkOnUserRol() {
        clickOnElement(clkUserRol);
    }

    public String verifyaddUserText() {
        return getTextFromElement(addUerText);
    }

    public void clkAddBtn() {
        clickOnElement(addBtn);
    }

    public String verifySystemText() {
        return getTextFromElement(systemUserText);
    }
    public void verifySuccessfullySavedText(String text){
        verifyThatTextIsDisplayed(saveMsg,text);
    }

}

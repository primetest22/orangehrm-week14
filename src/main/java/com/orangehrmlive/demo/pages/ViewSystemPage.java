package com.orangehrmlive.demo.pages;

import com.orangehrmlive.demo.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ViewSystemPage extends Utility {

     public void inIt(){
         PageFactory.initElements(driver,this);
     }
     @FindBy(xpath = "//input[@id='searchSystemUser_userName']")
     WebElement usr;
     @FindBy(xpath = "//select[@id='searchSystemUser_userType']")
    WebElement userType;
     @FindBy(xpath = "//select[@id='searchSystemUser_status']")
     WebElement status;
     @FindBy(xpath = "//input[@id='searchBtn']")
     WebElement serchBtn;
     @FindBy(xpath = "//a[contains(text(),'dashdash91')]")
     WebElement userIsThere;
     @FindBy(xpath ="//input[@name='chkSelectRow[]']")
     WebElement checkBox;
     @FindBy(xpath = "//input[@id='btnDelete']")
     WebElement delete;
     @FindBy(xpath = "//input[@id='dialogDeleteBtn']")
     WebElement closePopUp;
    @FindBy(xpath = "//div[contains(text(),'Successfully Deleted')]")
    WebElement deleteMessageDialog;
    @FindBy(xpath = "//td[contains(text(),'No Records Found')]")
    WebElement noRecord;

    public String verifyRecordDeleted(){
        return getTextFromElement(noRecord);
    }
    public String verifyPopUp(){
        return getTextFromElement(deleteMessageDialog);
    }
    public void clkOnPopUp(){
        clickOnElement(closePopUp);
    }
    public void clkOnDelete(){
        clickOnElement(delete);
    }
     public void clkOnCheckBox(){
         clickOnElement(checkBox);
     }
     public String verifyUserISThere(){
         return getTextFromElement(userIsThere);
     }
     public void clkOnSearchBtn(){
         clickOnElement(serchBtn);
     }
     public void selectStatus(String status1){
         selectByVisibleTextFromDropDown(status,status1);
     }
     public void selectUserType(String type){
         selectByVisibleTextFromDropDown(userType,type);
     }
     public void clkOnUserType(){
         clickOnElement(userType);
     }
     public void enterUser(String user){
         sendTextToElement(usr,user);
     }
     public void verifySuccefullyDeleted(String text){
        verifyThatTextIsDisplayed(deleteMessageDialog,text);
     }
     public void verifyRecordDeletedSuccessfully(String text){
        verifyThatTextIsDisplayed(noRecord,text);
     }


}

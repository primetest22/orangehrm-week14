package com.orangehrmlive.demo.pages;

import com.orangehrmlive.demo.utility.Utility;
import org.openqa.selenium.support.PageFactory;

public class AdminPage extends Utility {

    public AdminPage(){
        PageFactory.initElements(driver,this);
    }



}

package com.orangehrmlive.demo.testsuite;

import com.orangehrmlive.demo.pages.HomePage;
import com.orangehrmlive.demo.pages.LoginPage;
import com.orangehrmlive.demo.pages.SystemUsersPage;
import com.orangehrmlive.demo.pages.ViewSystemPage;
import com.orangehrmlive.demo.testbase.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import resources.testdata.TestData;

public class UsersTest extends TestBase {

    LoginPage loginPage;
    HomePage homePage;
    SystemUsersPage systemUsersPage;
    ViewSystemPage viewSystemPage;

    @BeforeMethod(alwaysRun = true)
    public void inIt() {
        loginPage = new LoginPage();
        homePage = new HomePage();
        systemUsersPage = new SystemUsersPage();
        viewSystemPage = new ViewSystemPage();
    }

    @Test(dataProvider = "credentials", dataProviderClass = TestData.class,groups = {"sanity","regression"})
    public void adminShouldAddUserSuccessFully(String user, String pass) throws InterruptedException {

        loginPage.logInToApplication(user, pass);
        homePage.clkOnAdminTab();
        Assert.assertEquals(systemUsersPage.verifySystemText(), "System Users", "error");
        systemUsersPage.clkAddBtn();
        Assert.assertEquals(systemUsersPage.verifyaddUserText(), "Add User", "error");
        systemUsersPage.clkOnUserRol();
        systemUsersPage.selectAdminValue("Admin");
        systemUsersPage.enterEmpName("Ananya Dash");
        systemUsersPage.enterUsrName("dashdash91");
        systemUsersPage.enterPass("primetest");
        systemUsersPage.enterCnfPass("primetest");
        Thread.sleep(1000);
        systemUsersPage.clkSaveBtn();
        // Assert.assertEquals(systemUsersPage.verifySaveMsg(), "Successfully Saved", "error");
        systemUsersPage.verifySuccessfullySavedText("Successfully Saved1");
    }

    @Test(dataProvider = "credentials", dataProviderClass = TestData.class,groups = {"sanity","regression"})
    public void searchTheUserCreatedAndVerifyIt(String user, String pass) {

        loginPage.logInToApplication(user, pass);
        homePage.clkOnAdminTab();
        Assert.assertEquals(systemUsersPage.verifySystemText(), "System Users", "error");
        viewSystemPage.enterUser("dashdash10");
        // viewSystemPage.clkOnUserType();
        viewSystemPage.selectUserType("Admin");
        viewSystemPage.selectStatus("Enabled");
        viewSystemPage.clkOnSearchBtn();
        Assert.assertEquals(viewSystemPage.verifyUserISThere(), "dashdash10101", "error");

    }

    @Test(dataProvider = "credentials", dataProviderClass = TestData.class,groups = {"smoke","regression"})
    public void verifyThatAdminShouldDeleteTheUserSuccessFully(String user, String pass) throws InterruptedException {
        searchTheUserCreatedAndVerifyIt(user, pass);
        viewSystemPage.clkOnCheckBox();
        viewSystemPage.clkOnDelete();
        Thread.sleep(2000);
        viewSystemPage.clkOnPopUp();
        Thread.sleep(10000);
        viewSystemPage.verifySuccefullyDeleted("Successfully Deleted");
    }

    @Test(dataProvider = "credentials", dataProviderClass = TestData.class,groups = {"regression"})
    public void searchTheDeletedUserAndVerifyTheMessageNoRecordFound(String user, String pass) {
        loginPage.logInToApplication(user, pass);
        homePage.clkOnAdminTab();
        Assert.assertEquals(systemUsersPage.verifySystemText(), "System Users", "error");
        viewSystemPage.enterUser("dashdash10101");
        // viewSystemPage.clkOnUserType();
        viewSystemPage.selectUserType("Admin");
        viewSystemPage.selectStatus("Enabled");
        viewSystemPage.clkOnSearchBtn();
        viewSystemPage.verifyRecordDeletedSuccessfully("No Records Found");

    }


}

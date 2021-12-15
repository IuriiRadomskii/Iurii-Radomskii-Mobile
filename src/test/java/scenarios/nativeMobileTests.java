package scenarios;

import TestData.Data;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.nativePages.BudgetActivityPage;
import pageObjects.nativePages.LoginPage;
import pageObjects.nativePages.RegistrationPage;
import pojos.User;
import setup.BaseTest;

public class nativeMobileTests extends BaseTest {

    @Test(groups = {"native"}, description = "Register new user, login and assert that Budget Page is opened",
          dataProviderClass = Data.class, dataProvider = "getTestUser")
    public void simpleNativeTest(User user) {
        LoginPage loginPage = (LoginPage) getPageObject().getEntryPageObject();
        loginPage.getRegisterBtn().click();
        RegistrationPage registrationPage = new RegistrationPage(getDriver());
        registrationPage.fillRegistrationFields(user);
        registrationPage.getRegisterBtn().click();
        loginPage.fillLoginFields(user);
        loginPage.getSignInBtn().click();
        BudgetActivityPage budgetActivityPage = new BudgetActivityPage(getDriver());
        Assert.assertTrue(budgetActivityPage.getAddExpenseBtn().isDisplayed());
        System.out.println("Budget activity page is opened");
    }
}

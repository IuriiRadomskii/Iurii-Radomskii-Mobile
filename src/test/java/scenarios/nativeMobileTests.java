package scenarios;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.PageObject;
import pageObjects.nativePages.BudgetActivityPage;
import pageObjects.nativePages.LoginPage;
import pageObjects.nativePages.RegistrationPage;
import pojos.User;
import setup.BaseTest;

public class nativeMobileTests extends BaseTest {

    @Test(groups = {"native"}, description = "This simple test just click on the Sign In button")
    public void simpleNativeTest()
        throws InterruptedException {
        User user = new User("aaa@mail.ru", "aaa", "password4");
        PageObject pageObject = getPageObject();
        LoginPage loginPage = (LoginPage) pageObject.getEntryPageObject();
        loginPage.getRegisterBtn().click();
        RegistrationPage registrationPage = new RegistrationPage(getDriver());
        registrationPage.fillRegistrationFields(user);
        registrationPage.getRegisterBtn().click();
        loginPage.fillLoginFields(user);
        loginPage.getSignInBtn().click();
        BudgetActivityPage budgetActivityPage = new BudgetActivityPage(getDriver());
        Assert.assertTrue(budgetActivityPage.getAddExpenseBtn().isDisplayed());
    }
}

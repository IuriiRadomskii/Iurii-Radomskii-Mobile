package scenarios.ex3;

import ex3.TestData.Data;
import org.testng.Assert;
import org.testng.annotations.Test;
import ex3.pageObjects.nativePages.BudgetActivityPage;
import ex3.pageObjects.nativePages.LoginPage;
import ex3.pageObjects.nativePages.RegistrationPage;
import ex3.pojos.User;
import ex3.setup.BaseTest;

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

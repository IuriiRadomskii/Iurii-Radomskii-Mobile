package pageObjects.nativePages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import pojos.User;

public class LoginPage {

    @AndroidFindBy(id = "platkovsky.alexey.epamtestapp:id/login_email")
    private WebElement loginTextField;

    @AndroidFindBy(id = "platkovsky.alexey.epamtestapp:id/login_pwd")
    private WebElement passwordTextField;

    @AndroidFindBy(id = "platkovsky.alexey.epamtestapp:id/email_sign_in_button")
    private WebElement signInBtn;

    @AndroidFindBy(id = "platkovsky.alexey.epamtestapp:id/register_button")
    private WebElement registerBtn;

    public LoginPage(AppiumDriver appiumDriver) {
        PageFactory.initElements( new AppiumFieldDecorator(appiumDriver), this);
    }

    public void loginAsUser(User user) {
        loginTextField.sendKeys(user.getUserName());
        passwordTextField.sendKeys(user.getPassword());
        signInBtn.click();
    }






}

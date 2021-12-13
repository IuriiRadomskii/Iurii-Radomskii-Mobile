package pageObjects.nativePages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import pojos.User;

public class RegistrationPage {

    @AndroidFindBy(id = "platkovsky.alexey.epamtestapp:id/login_email")
    private WebElement emailTextField;

    @AndroidFindBy(id = "platkovsky.alexey.epamtestapp:id/login_pwd")
    private WebElement usernameTextField;

    @AndroidFindBy(id = "platkovsky.alexey.epamtestapp:id/email_sign_in_button")
    private WebElement pswdTextField;

    @AndroidFindBy(id = "platkovsky.alexey.epamtestapp:id/register_button")
    private WebElement confirmPswdTextField;

    @AndroidFindBy(id = "platkovsky.alexey.epamtestapp:id/register_button")
    private WebElement agreeCheckbox;

    @AndroidFindBy(id = "platkovsky.alexey.epamtestapp:id/register_button")
    private WebElement registerBtn;

    @AndroidFindBy(id = "platkovsky.alexey.epamtestapp:id/register_button")
    private WebElement cancelBtn;

    private AppiumDriver appiumDriver;

    public RegistrationPage(AppiumDriver appiumDriver) {
        PageFactory.initElements( new AppiumFieldDecorator(appiumDriver), this);
        this.appiumDriver = appiumDriver;
    }

    public void registerAsUser(User user) {
        emailTextField.sendKeys(user.getEmail());
        usernameTextField.sendKeys(user.getUserName());
        pswdTextField.sendKeys(user.getPassword());
        confirmPswdTextField.sendKeys(user.getPassword());
    }

}

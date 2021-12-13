package pageObjects.nativePages;

import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class BudgetActivityPage {

    @AndroidFindBy(id = "platkovsky.alexey.epamtestapp:id/add_new_expense")
    private WebElement addExpenseBtn;

}

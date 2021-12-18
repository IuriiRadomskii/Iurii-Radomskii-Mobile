package ex2.TestData;

import org.testng.annotations.DataProvider;
import ex2.pojos.User;

public class Data {

    @DataProvider
    public static Object[][] getTestUser() {
        //no-hardcoded credentials was removed for easier home task checking
        String mail = "mail@mail.ru";
        String name = "name";
        String password = "password";
        User user = new User(mail, name, password);
        return new Object[][] {
            {user}
        };
    }

    @DataProvider
    public static Object[][] getRequestedString() {
        return new Object[][] {
            {"EPAM"}
        };
    }

}
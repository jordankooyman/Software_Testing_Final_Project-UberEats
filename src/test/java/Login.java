import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.io.FileHandler;

import java.io.File;
import java.io.IOException;

public class Login extends Setup {
    @Test (priority = 1)
    void LoginPage() {
        WebDriver driver = getDriver();
//        System.out.println("Navigate to Login Page");



    }

    @Test (priority = 2)
    void EnterCredentials()
    {
//        System.out.println("Put in credentials and log in");
    }

    @Test (priority = 3)
    void Something()
    {
//        System.out.println("Something, navigate to a page or something");
    }
}

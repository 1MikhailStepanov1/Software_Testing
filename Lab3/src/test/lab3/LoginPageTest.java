import utils.ConfigProperties;
import utils.DriversHandler;
import model.LoginPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Dimension;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
public class LoginPageTest {

    List<LoginPage> loginPages = new ArrayList<>();
    @BeforeEach
    public void setUp(){
        DriversHandler.initDrivers();
        loginPages = new ArrayList<>();
        String startURL = ConfigProperties.getProp("start_page_url");
        System.out.println(DriversHandler.drivers.size());
        DriversHandler.drivers.parallelStream().forEach(driver -> {
            driver.get(startURL);
            driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            loginPages.add(new LoginPage(driver));
            driver.manage().window().setSize(new Dimension(1024, 1024));
        });
    }
    @AfterEach
    public void close(){
        DriversHandler.closeDrivers();
    }

    @Test
    @DisplayName("Login test")
    public void loginTest() {
        String login = ConfigProperties.getProp("login");
        String password = ConfigProperties.getProp("password");
        loginPages.parallelStream().forEach(page -> {
            page.enterEmail(login);
            page.loginButtonClick();
            page.waitUntilPasswordInputIsPresent();
            page.enterPassword(password);
            page.passwordButtonClick();
            page.waitUntilAuthorize();
            page.accountImgClick();
            page.assertLogin();
        });
    }
}

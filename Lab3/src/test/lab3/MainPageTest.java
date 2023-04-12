import model.LoginPage;
import model.MainPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Dimension;
import utils.ConfigProperties;
import utils.DriversHandler;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainPageTest {

    List<MainPage> mainPages;
    List<LoginPage> loginPages;

    @BeforeEach
    public void setUp(){
        DriversHandler.initDrivers();
        mainPages = new ArrayList<>();
        loginPages = new ArrayList<>();
        String startURL = ConfigProperties.getProp("start_page_url");
        System.out.println(DriversHandler.drivers.size());
        DriversHandler.drivers.parallelStream().forEach(driver -> {
            driver.get(startURL);
            driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            loginPages.add(new LoginPage(driver));
            mainPages.add(new MainPage(driver));
            driver.manage().window().setSize(new Dimension(1024, 1024));
        });
        String login = ConfigProperties.getProp("login");
        String password = ConfigProperties.getProp("password");
        loginPages.parallelStream().forEach(page -> {
            page.enterEmail(login);
            page.loginButtonClick();
            page.waitUntilPasswordInputIsPresent();
            page.enterPassword(password);
            page.passwordButtonClick();
            page.waitUntilAuthorize();
        });
    }

    @AfterEach
    public void close(){
        DriversHandler.closeDrivers();
    }

    @Test
    @DisplayName("Letter send test")
    public void sendLetter(){
        mainPages.parallelStream().forEach(mainPage -> {
            mainPage.waitWriteMessageButton();
            mainPage.writeMailButtonCLick();
            mainPage.waitWriteLetterPage();
            mainPage.setRecipientMail(ConfigProperties.getProp("login"));
            mainPage.setMailTheme(ConfigProperties.getProp("message_theme"));
            mainPage.setLetterInput(ConfigProperties.getProp("message_text"));
            mainPage.sendButtonClick();
            mainPage.waitSuccessMessage();
            assertEquals("Письмо отправлено", mainPage.getMessageLetterSend().getText());
        });
    }

    @Test
    @DisplayName("Empty search test")
    public void emptySearchTest (){
        mainPages.parallelStream().forEach(mainPage -> {
            mainPage.waitSearchStringButton();
            mainPage.searchStringButtonClick();
            mainPage.waitSearchString();
            mainPage.searchStringInput(ConfigProperties.getProp("wrong_search"));
            mainPage.waitEmptySearchMessage();
            assertEquals("По вашему запросу ничего не найдено", mainPage.getEmptySearchMessage().getText());
        });
    }

    @Test
    @DisplayName("Read send letter test")
    public void readSentLetterTest(){
        mainPages.parallelStream().forEach(mainPage -> {
            mainPage.waitSearchStringButton();
            mainPage.searchStringButtonClick();
            mainPage.waitSearchString();
            mainPage.searchStringInput(ConfigProperties.getProp("message_theme"));
            mainPage.waitSentMessage();
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            mainPage.sentMessageClick();
            mainPage.waitMessageTheme();
            assertEquals("Self: Test", mainPage.getMessageTheme().getText());
        });
    }
}

package model;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

//page_url=https://e.mail.ru/inbox?app_id_mytracker=52695&authid=lgden38i.8xh&back=1%2C1&dwhsplit=s10273.b1ss12743s&from=octavius&x-login-auth=1
public class MainPage {

    private final WebDriver driver;
    @FindBy(xpath = "//html/body//a[@data-title-shortcut=\"N\"]")
    private WebElement writeMailButton;

    @FindBy(xpath = "//html/body//input[@tabindex=\"100\"]")
    private WebElement recipientMailInput;

    @FindBy(xpath = "//html/body//input[@tabindex=\"400\"]")
    private WebElement mailThemeInput;

    @FindBy(xpath = "//html/body//div[@tabindex=\"505\" and @role=\"textbox\"]/div[1]")
    private WebElement letterInput;

//    @FindBy(xpath = "//html/body//div[@data-test-id=\"underlay-wrapper\"]")
    @FindBy(xpath = "//html/body//button[@data-test-id = \"send\"]")
    private WebElement sendButton;

//    @FindBy(xpath = "//html/body//a[contains(/*, \"Письмо отправлено\")]")
//    @FindBy(xpath = "/html/body/div[10]/div/div/div[2]/div[2]/div/div/div[2]/a")
    @FindBy(xpath = "//a[contains(@class, 'layer__link')]")
    private WebElement messageLetterSend;
    public MainPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    public void writeMailButtonCLick(){
        writeMailButton.click();
    }

    public void setRecipientMail(String mail){
        recipientMailInput.sendKeys(mail);
    }

    public void setMailTheme(String theme){
        mailThemeInput.sendKeys(theme);
    }

    public void setLetterInput(String input){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].innerHTML = \"" + input + "\";", letterInput);
//        letterInput.sendKeys(input);
    }

    public void sendButtonClick(){
        sendButton.click();
    }

    public WebElement getMessageLetterSend(){
        return messageLetterSend;
    }

    public void waitWriteLetterPage(){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//html/body//div[@data-test-id=\"underlay-wrapper\"]")));
    }

    public void waitSuccessMessage(){
        WebDriverWait wait = new WebDriverWait(driver, 10);
//        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//html/body//a[contains(//*, \"Письмо отправлено\")]")));
//        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[10]/div/div/div[2]/div[2]/div/div/div[2]/a")));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[contains(@class, 'layer__link')]")));
    }

    public void waitWriteMessageButton(){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//html/body//a[@data-title-shortcut=\"N\"]")));
    }
}

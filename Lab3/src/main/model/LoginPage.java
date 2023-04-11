package model;

import utils.ConfigProperties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

    private final WebDriver driver;

    @FindBy(xpath = "/html/body/div[1]/div[2]/div[2]/div/div/div/div/div/form/div[2]/div[2]/div[1]/div/div/div/div/div/div[1]/div/input")
    private WebElement emailName;

    @FindBy(xpath = "/html/body/div[1]/div[2]/div[2]/div/div/div/div/div/form/div[2]/div[2]/div[3]/div/div/div[1]/button")
    private WebElement submitLoginButton;

    @FindBy(xpath = "//html/body//input[@type=\"password\"]")
    private WebElement passwordInput;

    @FindBy(xpath = "/html/body/div[1]/div[2]/div[2]/div/div/div/div/div/form/div[2]/div/div[3]/div/div/div[1]/div/button")
    private WebElement submitPassword;

    @FindBy(xpath = "//html/body//div[@data-testid=\"whiteline-account\"]")
    private WebElement accountImg;

    public LoginPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    public void loginButtonClick(){
        submitLoginButton.click();
    }

    public void enterEmail(String name){
        emailName.sendKeys(name);
    }

    public void enterPassword(String password){
        passwordInput.sendKeys(password);
    }

    public void passwordButtonClick(){
        submitPassword.click();
    }

    public void accountImgClick(){
        accountImg.click();
    }

    public void waitUntilPasswordInputIsPresent(){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[1]/div[2]/div[2]/div/div/div/div/div/form/div[2]/div/div[2]/div/div/div/div/div/input")));
    }

    public void waitUntilAuthorize(){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[3]/div[1]/div/div[2]/div")));
    }

    public void assertLogin(){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        String selector = "//html/body//div[@aria-label=\"" + ConfigProperties.getProp("login") + "\"]";
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(selector)));
    }
}

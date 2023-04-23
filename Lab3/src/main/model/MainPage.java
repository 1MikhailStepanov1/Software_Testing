package model;

import org.openqa.selenium.*;
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

    @FindBy(xpath = "//html/body//button[@data-test-id = \"send\"]")
    private WebElement sendButton;

    @FindBy(xpath = "//a[contains(@class, 'layer__link')]")
    private WebElement messageLetterSend;

    @FindBy(xpath = "//div[contains(@class, 'search-panel-button')]")
    private WebElement searchStringButton;

    @FindBy(xpath = "//input[contains(@class, 'mail')]")
    private WebElement searchString;

    @FindBy(xpath = "//span[@class='octopus__title octopus__title_with-subtitle']")
    private WebElement emptySearchMessage;

    @FindBy(xpath = "//a[@data-id=\"16812937811856411461\"]")
    private WebElement searchMessage;

    @FindBy(xpath = "//h2")
    private WebElement messageTheme;

    @FindBy(xpath = "//div[contains(@title, 'Выделить')]")
    private WebElement highlightLettersButton;

    @FindBy(xpath = "//span[@title='Удалить']")
    private WebElement deleteButton;

    @FindBy(xpath = "//div[contains(@class, 'submit')]")
    private WebElement submitDeleteButton;

    @FindBy(xpath = "//span[contains(@class, 'octopus')]")
//    @FindBy(xpath = "/html/body/div[5]/div/div[1]/div[1]/div/div[2]/span/div[2]/div/div/div/div/div[2]/div/div/div/div/div/div/div[2]/span")
    private WebElement emptyFolderText;

    @FindBy(xpath = "//a[contains(@title, 'Корзина')]")
    private WebElement trashIcon;

    @FindBy(xpath = "//span[@title='Выделить все']")
    private WebElement highlightAllLettersButton;

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
    }

    public void sendButtonClick(){
        sendButton.click();
    }

    public WebElement getMessageLetterSend(){
        return messageLetterSend;
    }

    public void searchStringButtonClick(){
        searchStringButton.click();
    }

    public void searchStringInput(String input){
        searchString.sendKeys(input);
        searchString.sendKeys(Keys.ENTER);
    }

    public WebElement getEmptySearchMessage(){
        return emptySearchMessage;
    }

    public void sentMessageClick(){
        searchMessage.click();
    }

    public WebElement getMessageTheme(){
        return messageTheme;
    }

    public void highlightLettersButtonClick(){ highlightLettersButton.click(); }

    public void deleteButtonCLick(){ deleteButton.click(); }

    public void submitDeleteButtonClick(){ submitDeleteButton.click(); }

    public WebElement getEmptyFolderText() { return emptyFolderText; }

    public void trashIconClick(){ trashIcon.click(); }

    public void highlightAllLettersButtonClick(){ highlightAllLettersButton.click(); }

    public void waitWriteLetterPage(){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//html/body//div[@data-test-id=\"underlay-wrapper\"]")));
    }

    public void waitSuccessMessage(){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[contains(@class, 'layer__link')]")));
    }

    public void waitWriteMessageButton(){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//html/body//a[@data-title-shortcut=\"N\"]")));
    }

    public void waitSearchStringButton(){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(@class, 'search-panel-button')]")));
    }

    public void waitSearchString(){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[contains(@class, 'mail')]")));
    }

    public void waitEmptySearchMessage(){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[@class='octopus__title octopus__title_with-subtitle']")));
    }

    public void waitSearchMessage(){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@data-id=\"16812937811856411461\"]")));
    }

    public void waitMessageTheme(){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h2")));
    }

    public void waitHighlightLettersButton(){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(@title, 'Выделить')]")));
    }

    public void waitDeleteButton(){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[@title='Удалить']")));
    }

    public void waitSubmitDeleteButton(){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(@class, 'submit')]")));
    }

    public void waitEmptyFolderText(){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[contains(@class, 'octopus')]")));
//        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[5]/div/div[1]/div[1]/div/div[2]/span/div[2]/div/div/div/div/div[2]/div/div/div/div/div/div/div[2]/span")));
    }

    public void waitTrashIcon(){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[contains(@title, 'Корзина')]")));
    }

    public void waitHighlightAllLettersButton(){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[@title='Выделить все']")));
    }
}

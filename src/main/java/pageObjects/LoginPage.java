package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
    public WebDriver driver;

    public LoginPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(css ="#user-name")
    WebElement username;

    @FindBy(css ="#password")
    WebElement password;

    @FindBy(css ="input.btn_action")
    WebElement btnLogin;


    public void Login(WebDriver driver, String login,String pass) {
        username.sendKeys(login);
        password.sendKeys(pass);
        btnLogin.click();
    }
}
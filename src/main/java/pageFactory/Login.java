package pageFactory;

import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocator;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class Login {

    WebDriver webDriver;

    @FindBy(name = "uid")
    WebElement userID;

    @FindBy(name = "password")
    WebElement password;

    @FindBy(name = "btnLogin")
    WebElement login;


    public Login(WebDriver driver) {
        this.webDriver = driver;
        AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(this.webDriver,100);
        PageFactory.initElements(factory, this);
    }

    public void setUserID(String userID) {
        this.userID.sendKeys(userID);
    }

    public void setPassword(String password) {
        this.password.sendKeys(password);
    }

    public void clickLogin() {
        login.click();
    }

    public String conected(){
        try {
            return webDriver.switchTo().alert().getText();
        }catch (NoAlertPresentException e){
            return "";
        }
    }

    public void acceptAlert(){
        webDriver.switchTo().alert().accept();
    }

    public void login(String userID,String passWord){
        setUserID(userID);
        setPassword(passWord);
        clickLogin();
    }
}

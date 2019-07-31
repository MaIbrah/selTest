package pageFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class HomePage {

    WebDriver driver;

    @FindBy(className = "heading3")
    WebElement heading;

    @FindBy(linkText="New Customer")
    WebElement managerLinkText;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(this.driver,100);
        PageFactory.initElements(factory,this);
    }

    public String getHeadingText(){
        return heading.getText();
    }

    public void enterManagerMenu(){
        managerLinkText.click();
    }

}

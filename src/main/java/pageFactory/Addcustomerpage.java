package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import sun.awt.SunHints;

public class Addcustomerpage {

    WebDriver webDriver;

    @FindBy(name = "name")
    WebElement name;

    @FindBy(xpath = "//table/tbody/tr/td/table/tbody/tr[5]/td[2]/input[2]")
    WebElement MRadioBtn;

    @FindBy(id = "dob")
    WebElement datePicker;

    public Addcustomerpage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(this.webDriver,this);
    }

    public void setName(String name) {
        this.name.sendKeys(name);
    }

    public void selectMRadioBtn() {
        this.MRadioBtn.click();
    }

    public void setDatePicker(String  date){
        datePicker.sendKeys(date);
    }



}

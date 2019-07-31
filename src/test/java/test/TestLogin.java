package test;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageFactory.Addcustomerpage;
import pageFactory.HomePage;
import pageFactory.Login;
import pageFactory.dataProvider.DataProviderParameters;

public class TestLogin {

    WebDriver driver;
    Login objLogin;
    HomePage objHomePage;
    Addcustomerpage addcustomerpage;

    @BeforeTest
    public void setup() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://demo.guru99.com/V4/");
    }


    @AfterTest
    public void after() {

    }

    @Test(dataProvider = "SearchProvider", dataProviderClass = DataProviderParameters.class)
    public void test_Home_Page_Appear_Correct(String userID, String password) throws IOException {

        objLogin = new Login(driver);

        objLogin.login(userID, password);

        if (objLogin.conected() == "") {
            objHomePage = new HomePage(driver);
            System.out.println(objHomePage.getHeadingText());
            objHomePage.enterManagerMenu();
            addcustomerpage =new Addcustomerpage(driver);
            addcustomerpage.setName("name");
            addcustomerpage.selectMRadioBtn();
            addcustomerpage.setDatePicker("1992-05-05");

            TakesScreenshot scrShot =((TakesScreenshot)driver);
            File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
            System.out.println("==== file ===="+SrcFile);
            File desFile=new File("C:\\Users\\imannane\\Desktop\\screen.png");
            FileUtils.copyFile(SrcFile,desFile);
        }
        else objLogin.acceptAlert();

      /*    driver.findElement(By.xpath("dede"));

      objHomePage.enterManagerMenu();
//        Assert.assertTrue(objHomePage.getHeadingText().equals("Welcome To Manager's Page of Guru99 Bank"));

        addcustomerpage =new Addcustomerpage(driver);
        addcustomerpage.setName("name");
        addcustomerpage.selectMRadioBtn();
        addcustomerpage.setDatePicker("1992-05-05");*/
        //Verify home page

    }
}

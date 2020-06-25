import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.Base;
import pageObjects.LoginPage;
import pageObjects.MainPage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class OrderItems extends Base {
    public WebDriver driver;

    @BeforeTest
    public void setUpDriver() throws IOException {
        driver = intializeDriver();
        driver.get(urlTesting);
        LoginPage lp = new LoginPage(driver);
        lp.Login(driver, "standard_user", "secret_sauce");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @Test
    public void OrderItemsTest() throws InterruptedException {

        MainPage mp = new MainPage(driver);
        WebDriverWait wa = new WebDriverWait(driver,10);
        wa.until(ExpectedConditions.visibilityOfAllElements(mp.tbProducts()));

        //Check if Product page is opened
        System.out.println("Verify Product Page is opened ");
        Assert.assertTrue(mp.isProductPageOpened());

        //Save list for evidence
        List<WebElement> listBefore = mp.tbProducts();
        for(int i = 0;i<listBefore.size();i++){
            System.out.println("Price init: "+listBefore.get(i).getText());
        }

        //Perform sort
        System.out.println("Order items by price and low to high");
        Select sts = new Select(mp.filterBtn());
        sts.selectByValue("lohi");
        Thread.sleep(5000);

        List<WebElement> listAfter = mp.tbProducts();
        for(int i = 0;i<listAfter.size();i++){
            System.out.println("Price low to high: "+listAfter.get(i).getText());
        }

        //Sort listBefore by java method
        Collections.reverse(listBefore);
        for(WebElement ele : listBefore){
            System.out.println("Price low to high (draf): "+ele.getText());
        }

        //Compare drafList with sourceList
        Assert.assertEquals(listBefore, listAfter);

    }

    @AfterTest
    public void tearDown(){
        driver.close();
    }

}

package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class MainPage {
    public WebDriver driver;

    public MainPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this );
    }

    @FindBy (css = "#inventory_filter_container>div")
    WebElement Logo;

    @FindBy (css = "select.product_sort_container")
    WebElement filterBtn;

    @FindBy (css = "div.inventory_item_price")
    List<WebElement> tbProducts;



    public WebElement filterBtn(){
        return filterBtn;
    }

    public List<WebElement> tbProducts() {
        return tbProducts;
    }

    public boolean isProductPageOpened(){
        return Logo.getText().toString().contains("Products");
    }


}


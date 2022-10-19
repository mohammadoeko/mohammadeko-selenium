package com.juaracoding.mohammadeko.ujiantigadanpostestdelapanbelas.pageobject.pages;

import com.juaracoding.mohammadeko.ujiantigadanpostestdelapanbelas.pageobject.drivers.DriverSingleton;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AddCart {

    private WebDriver driver;

    public AddCart() {
        this.driver = DriverSingleton.getDriver();
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@id=\"noo-site\"]/div[2]/div[2]/div/div/div[1]/div/h3/a")
    WebElement clickItem;

    @FindBy(id = "pa_color")
    WebElement color;

    @FindBy(id = "pa_size")
    WebElement size;

    @FindBy(xpath = "//*[@id=\"product-1162\"]/div[1]/div[2]/form/div/div[2]/div/div/button[2]")
    WebElement clickQtyIncrement;

    @FindBy(xpath = "//*[@id=\"product-1162\"]/div[1]/div[2]/form/div/div[2]/button")
    WebElement btnAddCart;

    @FindBy(id = "nav-menu-item-cart")
    WebElement btnViewCart;

    @FindBy(xpath = "//*[@id=\"product-1162\"]/div[1]/div[2]/h1")
    WebElement txtItemDetail;

    @FindBy(xpath = "//a[normalize-space()='Black Cross Back Maxi Dress - Black']")
    WebElement txtAddCartItem;

    @FindBy(xpath = "//a[normalize-space()='Orders']")
    WebElement clickMenuOrders;

    @FindBy(xpath = "//a[@class='woocommerce-Button button']")
    WebElement btnBrowseProducts;


    public void clickMenuOrders() {
        clickMenuOrders.click();
        System.out.println("Click menu orders");
        btnBrowseProducts.click();
        System.out.println("Clikc button browse products");
    }

    public void shopItemDetail() {
        clickItem.click();
        System.out.println("Click Item");
    }

    public void addToCart() {
        Select selectMenuColor = new Select(this.color);
        Select selectMenuSize = new Select(this.size);
        JavascriptExecutor js = (JavascriptExecutor) driver;

        selectMenuColor.selectByValue("black");
        System.out.println("Select Menu Color");
        selectMenuSize.selectByValue("large");
        System.out.println("Select Menu Size");
        clickQtyIncrement.click();
        System.out.println("Click button inqrement qty");
        btnAddCart.click();
        System.out.println("Click button addcart");
        btnViewCart.click();
        System.out.println("Click icon cart");
        js.executeScript("window.scrollBy(0,500)");

    }

    public String getTxtItemDetail() {
        return txtItemDetail.getText();
    }

    public String getTxtAddCartItem() {
        return txtAddCartItem.getText();
    }
}

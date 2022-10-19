package com.juaracoding.mohammadeko.ujiantigadanpostestdelapanbelas.pageobject.pages;

import com.juaracoding.mohammadeko.ujiantigadanpostestdelapanbelas.pageobject.drivers.DriverSingleton;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Wishlist {
    private WebDriver driver;
    JavascriptExecutor js = (JavascriptExecutor) driver;

    public Wishlist() {
        this.driver = DriverSingleton.getDriver();
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@id=\"noo-site\"]/div[2]/div[2]/div/div/div[1]/div/div[1]/div[1]/div[2]/div/a")
    WebElement btnWishlistProductOne;

    @FindBy(xpath = "//a[normalize-space()='white milkmaid hook and eye bodycon midi dress']")
    WebElement txtProductAddedOne;

    @FindBy(xpath = "//a[normalize-space()='mustard strappy frill ribbed mini dress']")
    WebElement txtProductAddedTwo;

    @FindBy(xpath = "//*[@id=\"noo-site\"]/div[2]/div[2]/div/div/div[3]/div/div[1]/div[1]/div[2]/div/a")
    WebElement btnWishlistProductTwo;


    public void btnWishlishProduct() {
        btnWishlistProductOne.click();
        System.out.println("Click button wishlist product one");
        btnWishlistProductTwo.click();
        System.out.println("Click button wishlist product two");
    }

    public String getTxtProductAddedOne() {
        return txtProductAddedOne.getText();
    }

    public String getTxtProductAddedTwo() {
        return txtProductAddedTwo.getText();
    }
}

package com.juaracoding.selenium;

import com.juaracoding.mohammadeko.ujiantigadanpostestdelapanbelas.pageobject.drivers.DriverSingleton;
import com.juaracoding.mohammadeko.ujiantigadanpostestdelapanbelas.pageobject.pages.AddCart;
import com.juaracoding.mohammadeko.ujiantigadanpostestdelapanbelas.pageobject.pages.Login;
import com.juaracoding.mohammadeko.ujiantigadanpostestdelapanbelas.pageobject.pages.Search;
import com.juaracoding.mohammadeko.ujiantigadanpostestdelapanbelas.pageobject.utils.Constants;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestAddCart {
    public static WebDriver driver;
    private Login login;

    private AddCart addCart;

    @BeforeClass
    public void setUp() {
        DriverSingleton.getInstance(Constants.CHROME);
        driver = DriverSingleton.getDriver();
        driver.get(Constants.URL_LOGIN);
    }

    @BeforeMethod
    public void pageObject() {
        login = new Login();
        addCart = new AddCart();
    }

    @AfterClass
    public void closeBrowser() {
        delay(3);
//        driver.quit();
        DriverSingleton.closeObjectInstance();
    }

    @Test(priority = 1)
    public void testShopItemDetail() {

        delay(Constants.DETIK);
        //PreCondition
        login.loginForm("mohammadeko@email.com","Rumahku1234!");
        delay(Constants.DETIK);
        addCart.clickMenuOrders();
        delay(Constants.DETIK);
        addCart.shopItemDetail();
        Assert.assertTrue(addCart.getTxtItemDetail().contains("BLACK CROSS"));
        System.out.println("Test case ShopItem Detail");
    }

    @Test(priority = 2)
    public void testAddToCart() {
        delay(Constants.DETIK);
        addCart.addToCart();
        Assert.assertTrue(addCart.getTxtAddCartItem().contains("BLACK CROSS"));
        System.out.println("Test case add item to cart");
    }

    static void delay(int detik) {
        try {
            Thread.sleep(1000*detik);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}

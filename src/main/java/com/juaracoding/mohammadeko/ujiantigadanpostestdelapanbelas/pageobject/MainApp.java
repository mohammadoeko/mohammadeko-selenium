package com.juaracoding.mohammadeko.ujiantigadanpostestdelapanbelas.pageobject;

import com.juaracoding.mohammadeko.ujiantigadanpostestdelapanbelas.pageobject.drivers.DriverSingleton;
import com.juaracoding.mohammadeko.ujiantigadanpostestdelapanbelas.pageobject.pages.*;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import com.juaracoding.mohammadeko.ujiantigadanpostestdelapanbelas.pageobject.utils.Constants;

public class MainApp {

    public static void main(String[] args) {
        DriverSingleton.getInstance(Constants.CHROME);
        WebDriver driver = DriverSingleton.getDriver();
        JavascriptExecutor js = (JavascriptExecutor) driver;

        Register register = new Register();
        Login login = new Login();
        AddCart addCart = new AddCart();
        Search search = new Search();
        Wishlist wishlist = new Wishlist();

        // Register Account
        driver.get(Constants.URL_LOGIN);
        register.registerForm("Mohammad Eko", "mohammadeko@email.com", "Rumahku1234!");

        driver.navigate().back();
        driver.navigate().refresh();

        // Login Account
        login.loginForm("mohammadeko@email.com", "Rumahku1234!");

        //Item list one product
        driver.get(Constants.URL_SHOP);
        js.executeScript("window.scrollBy(0,550)");
        addCart.shopItemDetail();

        // Add item to cart
        driver.get(Constants.URL_DETAIL_SHOP);
        js.executeScript("window.scrollBy(0,500)");
        addCart.addToCart();

        driver.get("https://shop.demoqa.com/cart/");
        search.searchItem();

        driver.get("https://shop.demoqa.com/?s=dress&post_type=product");
        js.executeScript("window.scrollBy(0,550)");
        wishlist.btnWishlishProduct();


        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

//        driver.quit();
    }
}

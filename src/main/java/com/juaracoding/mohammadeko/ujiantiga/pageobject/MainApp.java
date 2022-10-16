package com.juaracoding.mohammadeko.ujiantiga.pageobject;

import com.juaracoding.mohammadeko.ujiantiga.pageobject.drivers.DriverSingleton;
import com.juaracoding.mohammadeko.ujiantiga.pageobject.pages.AddCart;
import com.juaracoding.mohammadeko.ujiantiga.pageobject.pages.Dashboard;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import com.juaracoding.mohammadeko.ujiantiga.pageobject.pages.Login;
import com.juaracoding.mohammadeko.ujiantiga.pageobject.pages.Register;
import com.juaracoding.mohammadeko.ujiantiga.pageobject.utils.Constants;

public class MainApp {

    public static void main(String[] args) {
        DriverSingleton.getInstance(Constants.CHROME);
        WebDriver driver = DriverSingleton.getDriver();
        JavascriptExecutor js = (JavascriptExecutor) driver;

        Dashboard dashboard = new Dashboard();
        Register register = new Register();
        Login login = new Login();
        AddCart addCart = new AddCart();

        // Dashboard
        driver.get(Constants.URL);
        dashboard.dashboard();

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
        addCart.shopItem();

        // Add item in cart
        driver.get(Constants.URL_DETAIL_SHOP);
        js.executeScript("window.scrollBy(0,500)");
        addCart.addToCart();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        driver.quit();
    }
}

package com.juaracoding.mohammadeko.ujiantigadanpostestdelapanbelas.pageobject.pages;

import com.juaracoding.mohammadeko.ujiantigadanpostestdelapanbelas.pageobject.drivers.DriverSingleton;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Search {

    private WebDriver driver;

    public Search() {
        this.driver = DriverSingleton.getDriver();
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@id=\"noo-site\"]/header/div[2]/div/div/div/a")
    WebElement clickSearch;

    @FindBy(name = "s")
    WebElement inputSearch;

    @FindBy(xpath = "//a[normalize-space()='white milkmaid hook and eye bodycon midi dress']")
    WebElement txtDress;

    public void searchItem() {
        clickSearch.click();
        System.out.println("Click search");
        inputSearch.sendKeys("dress", Keys.ENTER);
        System.out.println("Input dress for values search");
    }

    public String getTxtDress() {
        return txtDress.getText();
    }
}

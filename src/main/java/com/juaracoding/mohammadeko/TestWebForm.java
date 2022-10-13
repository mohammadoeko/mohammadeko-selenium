package com.juaracoding.mohammadeko;

import net.bytebuddy.implementation.bytecode.Throw;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class TestWebForm {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "D:\\selenium\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        String url = "https://formy-project.herokuapp.com/form";
        driver.get(url);

        JavascriptExecutor js = (JavascriptExecutor) driver;
        int detik = 1;

        String titleName = driver.getTitle();
        System.out.println(titleName);

        delay(detik);
        WebElement titleFormName = driver.findElement(By.xpath("/html/body/div/h1"));
        System.out.println("Title menu : " +titleFormName.getText());

        delay(detik);
        driver.findElement(By.id("first-name")).sendKeys("Mohammad Eko");
        System.out.println("Input First Name");

        delay(detik);
        driver.findElement(By.id("last-name")).sendKeys("Nur Fauzi");
        System.out.println("Input Last Name");

        delay(detik);
        driver.findElement(By.id("job-title")).sendKeys("QA Engineer");
        System.out.println("Input Job Title");

        delay(detik);
        WebElement collegeRadio = driver.findElement(By.id("radio-button-2"));
        js.executeScript("arguments[0].click();", collegeRadio);
        System.out.println("College Radio Clicked");

        js.executeScript("window.scrollBy(0,500)");

        delay(detik);
        driver.findElement(By.id("checkbox-1")).click();
        System.out.println("Male Checkbox");

        WebElement elementSelect = driver.findElement(By.id("select-menu"));
        Select selectMenu = new Select(elementSelect);

        delay(detik);
        selectMenu.selectByValue("1");
        System.out.println("Select years of experience");

        delay(detik);
        driver.findElement(By.id("datepicker")).sendKeys("26/07/2000");
        System.out.println("Input Date Picker");

        delay(detik);
        driver.findElement(By.xpath("/html/body/div/form/div/div[8]/a")).click();
        System.out.println("Click Submit");

        delay(detik);
        driver.quit();

    }

    static void delay (int detik) {
        try {
            Thread.sleep(1000*detik);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}





//Uncheckbox
//        delay(detik);
//        driver.findElement(By.id("checkbox-1")).click();
//        System.out.println("Male Uncheckbox");
//
//        delay(detik);
//        driver.findElement(By.id("checkbox-2")).click();
//        System.out.println("Female Uncheckbox");
//
//        delay(detik);
//        driver.findElement(By.id("checkbox-3")).click();
//        System.out.println("Prefer not to say Uncheckbox");


//        delay(detik);
//        driver.findElement(By.id("checkbox-2")).click();
//        System.out.println("Female Checkbox");
//
//        delay(detik);
//        driver.findElement(By.id("checkbox-3")).click();
//        System.out.println("Prefer not to say Checkbox");

//        delay(detik);
//        WebElement highSchoolRadio = driver.findElement(By.id("radio-button-1"));
//        js.executeScript("arguments[0].click();", highSchoolRadio);
//        System.out.println("High School Radio Clicked");
//
//        delay(detik);
//        WebElement gradSchoolRadio = driver.findElement(By.id("radio-button-3"));
//        js.executeScript("arguments[0].click();", gradSchoolRadio);
//        System.out.println("Grad School Radio Clicked");

//        delay(detik);
//        driver.get("https://formy-project.herokuapp.com/thanks");
//
//        WebElement titleSuccessSubmit = driver.findElement(By.xpath("/html/body/div/h1"));
//        System.out.println("Title Successfully Submit : " +titleSuccessSubmit);
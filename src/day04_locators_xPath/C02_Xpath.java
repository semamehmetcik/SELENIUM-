package day04_locators_xPath;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import utilities.ReusableMethods;

import java.time.Duration;

public class C02_Xpath {
    public static void main(String[] args) {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("user-data-dir=C:/path/to/your/custom/profile");

        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //1- https://testotomasyonu.com/addremove/ adresine gidin
        driver.get("https://testotomasyonu.com/addremove/");

        //2- Add Element butonuna basin
        driver.findElement(By.xpath("//button[@id='sub-btn']"))
                .click();

        //3- Remove butonu’nun gorunur oldugunu test edin
        WebElement removeButonElementi =
                driver.findElement(By.xpath("//button[@class='remove-btn']"));

        if (removeButonElementi.isDisplayed()){
            System.out.println("Remove butonu testi PASSED");
        }else System.out.println("Remove butonu testi FAILED");
        ReusableMethods.bekle(3);
        //4- Remove tusuna basin
        removeButonElementi.click();

        //5- “Add/Remove Elements” yazisinin gorunur oldugunu test edin
        // WebElement addRemoveYaziElementi = driver.findElement(By.tagName("h2"));
        WebElement addRemoveYaziElementi = driver.findElement(By.xpath("//h2"));

        if (addRemoveYaziElementi.isDisplayed()){
            System.out.println( "Add Remove Yazi Testi PASSED");
        }else System.out.println( "Add Remove Yazi Testi FAILED");


        ReusableMethods.bekle(3);
        driver.quit();
    }
}
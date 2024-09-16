package day04_locators_xPath;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import utilities.ReusableMethods;

import java.sql.Driver;
import java.time.Duration;
import java.util.List;

public class C01_ByLinkText {

    public static void main(String[] args) {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("user-data-dir=C:/path/to/your/custom/profile");

        //1- Bir test class’i olusturun ilgili ayarlari yapin
        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        //2- https://www.automationexercise.com/ adresine gidin
        driver.get("https://www.automationexercise.com/");

        //3- Sayfada 147 adet link bulundugunu test edin.
        //   link'lerin tag'i a olacagi icin

        List<WebElement> linkElementleriList = driver.findElements(By.tagName("a"));

        int expectedLinkSayisi = 147;
        int actualLinksayisi = linkElementleriList.size();

        if (expectedLinkSayisi == actualLinksayisi ){
            System.out.println("Link sayisi testi PASSED");
        } else System.out.println("Link sayisi testi FAILED");
        ReusableMethods.bekle(1);

        //4- Products linkine tiklayin
        driver.findElement(By.partialLinkText("Products"))
                .click();
        ReusableMethods.bekle(1);
        //5- special offer yazisinin gorundugunu test edin
        WebElement specialOfferElementi = driver.findElement(By.id("sale_image"));

        if ( specialOfferElementi.isDisplayed() ) {
            System.out.println("special offer yazi testi PASSED");
        } else System.out.println("special offer yazi testi FAILED");

        //6- Sayfayi kapatin
        ReusableMethods.bekle(3);
        driver.quit();
    }
}
package day03_webelements_locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class C01_By_id {

    public static void main(String[] args) throws InterruptedException {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("user-data-dir=C:/path/to/your/custom/profile");

        // Webdriver objesi edinmek ve mahserin 4 atlisini calistirmak

        System.setProperty("Webdriver.chrome.driver","kurulumDosyalari/chromedriver");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // testotomasyonu anasayfaya gidin
        driver.get("https://www.testotomasyonu.com");

        // arama kutusuna phone yazip aratin

        // bir webelementi kullanabilmek icin
        // driver'in o webelemnti bulmasi ve kullanmak uzere bu class'a getirmesi gerekiyor

        WebElement aramaKutusu = driver.findElement(By.id("global-search"));

        aramaKutusu.sendKeys("phone");

        aramaKutusu.submit();


        // arama sonucunda urun bulunabildigini test edin

        WebElement aramaSonucElementi = driver.findElement(By.className("product-count-text"));

        System.out.println(aramaSonucElementi.getText()); // 4 Products Found


        String aramaSonucYazisi = aramaSonucElementi.getText(); // 4 Products Found

        aramaSonucYazisi = aramaSonucYazisi.replaceAll("\\D",""); // "4"

        int aramaSonucSayisi = Integer.parseInt(aramaSonucYazisi);

        if (aramaSonucSayisi > 0){
            System.out.println("Urun arama testi PASSED");
        }else System.out.println("Urun arama testi FAILED");

        Thread.sleep(3000);
        driver.quit();

    }
}
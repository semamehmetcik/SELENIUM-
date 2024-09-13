package day02_driverMethodlari;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C02_IlkTestOtomasyonu {
    public static void main(String[] args) throws InterruptedException {

        // System.setProperty("WebDriver.chrome.driver","kurulumDosyaları/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        //1. testotomasyonu sayfasina gidelim. https://www.testotomasyonu.com/
        driver.get("https://www.testotomasyonu.com");



        //2. Sayfa basligini(title) yazdirin
        System.out.println(driver.getTitle());



        //3. Sayfa basliginin “Test Otomasyonu” icerdigini test edin
        String actualSayfaBasligi =driver.getTitle();
        String axpectedTitleIcerik = "Test Otomasyonu";

        if (actualSayfaBasligi.contains(axpectedTitleIcerik)){
            System.out.println("Title testi PASSED=TRUE");
        }else
            System.out.println("Title testi FAILED=FALSE");



        //4. Sayfa adresini(url) yazdirin
        System.out.println("Sayfa URL :" + driver.getCurrentUrl());



        //5. Sayfa url’inin https://testotomasyonu.com/ oldugunu test edin.
        String expectedUrl = "https://testotomasyonu.com/";
        String actualUrl = driver.getCurrentUrl();

        if (expectedUrl.equalsIgnoreCase(actualUrl)){
            System.out.println("Url testi PASSED=TRUE");
        }else {
            System.out.println("Url testi FAILED=FALSE");
        }



        //6. Sayfa handle degerini yazdirin
        System.out.println(driver.getWindowHandle());



        //7. Sayfa HTML kodlarinda “otomasyon” kelimesi gectigini test edin
        String expectedSayfaHtml = "otomasyon";
        String actualSayfaHtml = driver.getPageSource();

        if (actualSayfaHtml.contains(expectedSayfaHtml)){
            System.out.println("Sayfa Kaynağı Testi PASSED=TRUE");
        }else {
            System.out.println("Sayfa Kaynağı Testi FAILED=FALSE");
        }










        Thread.sleep(3000);
        driver.quit();


    }
}

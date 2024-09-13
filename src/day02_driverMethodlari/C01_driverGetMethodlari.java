package day02_driverMethodlari;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C01_driverGetMethodlari {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("WebDriver.chrome.driver","kurulumDosyaları/chromedriver.exe");
        WebDriver driver = new ChromeDriver();


        driver.get("https://www.testotomasyonu.com");

        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());

        driver.get("https://ramazon.com");

        System.out.println(driver.getCurrentUrl());
        System.out.println(driver.getWindowHandles());
        System.out.println(driver.getWindowHandle());
        System.out.println(driver.getPageSource());
        System.out.println(driver.getClass());


        Thread.sleep(3000);
        driver.quit();


    }
}

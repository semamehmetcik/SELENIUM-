package day02_driverMethodlari;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class C03_driverNavigateMethodlari {

    public static void main(String[] args) throws InterruptedException {
        /*
            Kodu ilk yazdigimizda test adimlarini gozle kontrol etmek
            Veya bir sunum yapiyorsak
            izleyenlerin test adimlarini algilamasi icin

            adimlar arasinda ve testin sonunda Thread.sleep() kullanilabilir

            ANCAK gozle takip islemini bir kere yaptiktan sonra
            MECBURI olarak kullanilanlar haric
            Thread.sleep()'leri silmek gerekir-----


         */

        // Selenium ile test otomasyonu yapmak istedigimizde
        // ilk yapmamiz gereken driver objesi EDINMEKTIR

        ChromeOptions options = new ChromeOptions();
        options.addArguments("user-data-dir=C:/path/to/your/custom/profile");

        System.setProperty("Webdriver.chrome.driver","kurulumDosyalari/chromedriver");
        WebDriver driver = new ChromeDriver(options);

        driver.get("https://www.testotomasyonu.com");


        // wisequarter sayfasina gidin
        driver.navigate().to("https://www.wisequarter.com");


        // testotomasyonu sayfasina geri donun
        driver.navigate().back();


        // yeniden wisequarter sayfasina gidin
        driver.navigate().forward();



        // sayfayi yenileyin
        driver.navigate().refresh();



        // sayfayi kapatin
        driver.quit();


    }
}
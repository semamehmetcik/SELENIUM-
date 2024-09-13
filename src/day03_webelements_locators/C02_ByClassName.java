package day03_webelements_locators;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;
import java.util.List;

public class C02_ByClassName {

    public static void main(String[] args) throws InterruptedException {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("user-data-dir=C:/path/to/your/custom/profile");
        // gerekli ayarlari yapin
        System.setProperty("Webdriver.chrome.driver","kurulumDosyalari/chromedriver");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // test otomasyonu anasayfaya gidin
        driver.get("https://www.testotomasyonu.com");

        // phone icin arama yapin
        WebElement aramaKutusu = driver.findElement(By.id("global-search"));
        aramaKutusu.sendKeys("phone" + Keys.ENTER );

        // bulunan urunlerden 2.sini tiklayin

        /*
            class attribute'u genellikle
            developer'lar tarafindan ayni bicimdeki webelementleri gruplandirmak icin kullanilir
            boylece tek css ile birden fazla webelementi sekillendirmis olurlar

            EGER kullandigimiz locator bize birden fazla webelement getiriyorsa
            o zaman findElements() kullanilir
            findElements() verdigimiz locator'a sahip butun webelementleri bir liste olarak getirir

            biz de gelen webelementleri bir listeye kaydedip
            list method'lari ile o elementleri kullanabiliriz
         */

        List<WebElement> bulunanUrunElementleriList =
                driver.findElements(By.className("prod-img"));
        // System.out.println(bulunanUrunElementleriList); // []
        // findElements() kullanildiginda, hic element bulamasa da bos liste dondurur

        bulunanUrunElementleriList.get(1).click();

        // acilan urun sayfasindaki urun taniminda
        // case sensitive olmadan "phone" gectigini test edin

        WebElement urunDetayElementi = driver.findElement(By.className("prod-detail"));

        String expectedUrunAciklamaIcerik = "phone";
        String actualUrunDetayBilgisi = urunDetayElementi.getText().toLowerCase();

        if (actualUrunDetayBilgisi.contains(expectedUrunAciklamaIcerik)){
            System.out.println("Urun isim testi PASSED");
        }else System.out.println("Urun isim testi FAILED");

        // sayfayi kapatin
        Thread.sleep(3000);
        driver.quit();


    }
}
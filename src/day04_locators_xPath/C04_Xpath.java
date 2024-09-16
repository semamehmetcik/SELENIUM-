package day04_locators_xPath;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import utilities.ReusableMethods;

import java.time.Duration;

public class C04_Xpath {
    public static void main(String[] args) {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("user-data-dir=C:/path/to/your/custom/profile");

        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //2-  https://www.testotomasyonu.com/ adresine gidin
        driver.get("https://www.testotomasyonu.com/");

        //3-  Browseri tam sayfa yapin
        driver.manage().window().maximize();

        //4-  Sayfayi “refresh” yapin
        driver.navigate().refresh();

        //5-  Sayfa basliginin “Test Otomasyonu” ifadesi icerdigini test edin
        String expectedTitleIcerik = "Test Otomasyonu";
        String actualTitle = driver.getTitle();

        if (actualTitle.contains(expectedTitleIcerik)){
            System.out.println("Title testi PASSED");
        } else System.out.println("Title testi FAILED");

        //6-  Furniture linkine tiklayin
        driver.findElement(By.xpath("(//a[text()='Furniture'])[3]"))
                .click();

        /*
            driver objesi bizim gozumuz gibidir
            biz bir websayfasinda goremedigimiz webelement'leri kullanamadigimiz GIBI
            driver'da bilgisayarin ekraninda gorunmeyen elemanlari KULLANAMAYABILIR

            gorunmeyen bir webelemntin kullanilip kullanilamayacagi
            TAMAMEN kodu yazan developer'a baglidir
            Bazi sayfalarda ekranda goremedigimiz webelement'leri kullanabilirken
            bazi sayfalarda KULLANAMAYIZ

            EGER ekranda gorunmeyen bir elemani kullanmak istedigimizde
            driver kullanabiliyorsa, hic sorun yapmadan KULLANABILIRIZ,
            AMMA driver goremedigi elementi kullanamiyorsa
            O element GORUNUR OLUNCAYA KADAR asagi inmemiz gerekir


         */



        //7-  price range filtresinde min degere 40, max degere 200 yazip filtreleyin

        WebElement minDegerKutusu = driver.findElement(By.xpath("//input[@name='min']"));
        WebElement maxDegerKutusu = driver.findElement(By.xpath("//input[@name='max']"));

        JavascriptExecutor js = (JavascriptExecutor) driver;
        // Elementi sayfanın ortasına kaydırma (hesaplama yapmadan)
        js.executeScript("arguments[0].scrollIntoView({block: 'center'});", minDegerKutusu);

        minDegerKutusu.clear();
        minDegerKutusu.sendKeys("40");
        maxDegerKutusu.clear();
        maxDegerKutusu.sendKeys("200");

        // filtreleme icin filtrele butonuna basalim
        driver.findElement(By.xpath("//button[@name='button']"))
                .click();

        //8-  filtreleme sonucunda urun bulunabildigini test edin
        WebElement aramaSonucElementi = driver.findElement(By.className("product-count-text"));

        String unExpectedSonucYazisi = "0 Products Found";
        String actualSonucYazisi = aramaSonucElementi.getText();

        if ( ! unExpectedSonucYazisi.equalsIgnoreCase(actualSonucYazisi)){
            System.out.println("Urun filtreleme testi PASSED");
        } else System.out.println("Urun filtreleme testi FAILED");

        //10-Ilk urunu tiklayin
        driver.findElement(By.xpath("(//*[@*='prod-img'])[1]"))
                .click();

        //11- Urun fiyatinin 40 ile 200 arasinda oldugunu test edin
        WebElement urunFiyatElementi = driver.findElement(By.xpath("//span[@id='priceproduct']"));

        String urunFiyatYazisi = urunFiyatElementi.getText(); // $50.00

        urunFiyatYazisi = urunFiyatYazisi.replaceAll("\\D","");

        double urunFiyati = Double.parseDouble(urunFiyatYazisi) / 100 ; // 50.00


        if (urunFiyati>=40 && urunFiyati<=200){
            System.out.println("Ilk urun fiyat testi PASSED");
        } else System.out.println("Ilk urun fiyat testi FAILED");

        //12-Sayfayi kapatin

        ReusableMethods.bekle(3);
        driver.quit();
    }
}
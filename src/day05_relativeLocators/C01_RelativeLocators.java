package day05_relativeLocators;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.locators.RelativeLocator;
import utilities.ReusableMethods;

import java.time.Duration;

public class C01_RelativeLocators {

    public static void main(String[] args) {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("user-data-dir=C:/path/to/your/custom/profile");

        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //1 ) https://testotomasyonu.com/relativeLocators adresine gidin
        driver.get("https://testotomasyonu.com/relativeLocators");

        //2 ) DSLR Camera’yi  etrafindaki elementleri kullanarak
        //    3 farkli relative locator ile locate edip tiklayin

        // once normal locate edip, tiklayalim
        driver.findElement(By.id("pictext7"))
                .click();
        ReusableMethods.bekle(3);
        //3 ) Acilan urunun DSLR Camera oldugunu test edin.
        WebElement urunIsimElementi = driver.findElement(By.xpath("(//*[text()='DSLR Camera'])[1]"));

        String expectedUrunIsmi = "DSLR Camera";
        String actualUrunIsmi = urunIsimElementi.getText();

        if (expectedUrunIsmi.equalsIgnoreCase(actualUrunIsmi)){
            System.out.println("Direk camerayi kullanma testi PASSED");
        }else System.out.println("Direk camerayi kullanma testi FAILED");



        /*
            Goruldugu gibi DSLR camera elementini direk kullanabiliyoruz

            EGERRR bir webElementi ve HTML kodunu gordugumuz halde KULLANAMIYORSAK
            alternatif olarak RELATIVE LOCATOR kullanabiliriz

            Relative locator sayesinde,
            kullanamadigimiz bir web elementi
            etrafindaki webelementler ile kullanilabilir hale getirebiliriz

            bunun icin 2 bilgiye ihtiyacimiz var
            1- kullanmak istedigimiz webelementin bir ozelligi
            2- etrafinda kullanilabilecek, locate edilmis herhangi bir webElement
         */

        driver.get("https://testotomasyonu.com/relativeLocators");

        //  1- apple kulakligin saginda seklinde locate edelim
        WebElement appleKulaklik = driver.findElement(By.id("pictext6"));

        WebElement dslrRelative1 =
                driver.findElement(RelativeLocator.with(By.id("pictext7")).toRightOf(appleKulaklik));

        ReusableMethods.bekle(1);
        dslrRelative1.click();

        // 2.defa DSLR Camera urun sayfasini actik
        //   daha once locate ettigimiz urun isim elementini kullandigimizda
        //   StaleElementReferenceException (bayat element) veriyor
        //   Bu sorunu asmak icin, kullandiktan sonra sayfa degistirdigimiz
        //   urunIsimElementi'ni yeniden locate etmeliyiz

        urunIsimElementi = driver.findElement(By.xpath("(//*[text()='DSLR Camera'])[1]"));

        actualUrunIsmi = urunIsimElementi.getText();

        if (expectedUrunIsmi.equalsIgnoreCase(actualUrunIsmi)){
            System.out.println("Relative1 camera testi PASSED");
        }else System.out.println("Relative1 camera testi FAILED");


        // 2- Motor telefonun solunda seklinde locate edelim
        driver.get("https://testotomasyonu.com/relativeLocators");
        ReusableMethods.bekle(3);

        WebElement motorTelefonElementi = driver.findElement(By.id("pictext8"));

        // relative locator ile 2.kez DSLR camerayi locate edelim

        WebElement dslrRelative2 = driver.findElement(RelativeLocator.with(By.id("pictext7")).toLeftOf(motorTelefonElementi));

        dslrRelative2.click();

        urunIsimElementi = driver.findElement(By.xpath("(//*[text()='DSLR Camera'])[1]"));

        actualUrunIsmi = urunIsimElementi.getText();

        if (expectedUrunIsmi.equalsIgnoreCase(actualUrunIsmi)){
            System.out.println("Relative2 camera testi PASSED");
        }else System.out.println("Relative2 camera testi FAILED");



        ReusableMethods.bekle(3);
        driver.quit();
    }
}
package day01_IlkOtomasyon;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C01_SayfayaGitme {

    public static void main(String[] args) throws InterruptedException {

        // FileStructure / Modules / Depencies
        // + tusuna basarak Selenium ile ilgili .jar dosyalarini projemize tanittik
        // projemiz selenium ile calismaya hazir

        // Selenium'un 4 bileseni var.
        // AMMA biz test otomasyonu icin WebDriver kullanacagiz

        // Her class'da WebDriver'i indirdigimiz chromedriver.exe dosyasi ile olusturmaliyiz
        // WebDriver'i olusturmak icin Java'daki System class'indan setProperty() kullanilir

        System.setProperty("Webdriver.chrome.driver","kurulumDosyalari/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage()
                .window()
                .maximize();


        driver.get("https://www.testotomasyonu.com");

        // driver objesi, url yazarken www yazmasak da istenen url'e gider
        //                ANCAKKK https:// yazmazsak GITMEZ

        Thread.sleep(3000); // kodu 3000 ms = 3 sn bekletir

        // WebDriver objesi olusturdugumuzda acilan browser'i kapatmak istersek
        //driver.close(); // test sirasinda driver objesi sadece 1 window aciyorsa
        // o window'u kapatir
        driver.quit(); // test sirasinda driver objesi birden fazla window aciyorsa
        // HEPSINI kapatir


    }
}

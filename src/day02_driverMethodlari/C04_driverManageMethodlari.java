package day02_driverMethodlari;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class C04_driverManageMethodlari {

    public static void main(String[] args) throws InterruptedException {


        // Bu 4 satira Mahserin 4 atlisi diyebiliriz
        // Her test class'i olusturdugumuzda
        // driver objesini olusturup window ve wait ayarlarini yapan
        // bu 4 adimi MUTLAKA calistiririz

        System.setProperty("Webdriver.chrome.driver","kurulumDosyalari/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://www.testotomasyonu.com");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        // dinamik olarak en fazla 10 saniye bekler
        // implicitlyWait sayfanin yuklenmesi veya kullanilacak webelementlerin bulunmasi icin
        // belirlenmis MAX bekleme suresidir

        // failed olan testlerde gereksiz uzun beklemeleri engelleyecek kadar kisa
        // ama sayfanin yuklenmesini ve webelementlerin bulunmasini saglayacak kadar uzun olmalidir

        Thread.sleep(3000);
        // tami tamina 3 saniye bekler
        // goreve degil beklemeye odaklidir
        // Java'nin bir alt satira gecmesini yazilan sure kadar bekletir

        System.out.println("ilk acildiginda window'un pozisyonu " + driver.manage().window().getPosition());
        System.out.println("ilk acildiginda window'un boyutu " + driver.manage().window().getSize());

        Thread.sleep(3000);

        driver.manage().window().maximize(); // sayfayi maximize eder
        System.out.println("maximize window'un pozisyonu " + driver.manage().window().getPosition());
        System.out.println("maximize window'un boyutu " + driver.manage().window().getSize());


        Thread.sleep(3000);
        driver.manage().window().fullscreen(); // sayfayi fullscreen yapar
        System.out.println("fullscreen window'un pozisyonu " + driver.manage().window().getPosition());
        System.out.println("fullscreen window'un boyutu " + driver.manage().window().getSize());


        Thread.sleep(3000);

        // window'u baslangic noktasi : 300,300
        driver.manage().window().setPosition(new Point(300,300));
        // boyutu 600X800 olacak sekilde boyutlayin
        driver.manage().window().setSize(new Dimension(600,800));

        System.out.println("ozel boyut window'un pozisyonu " + driver.manage().window().getPosition());
        System.out.println("ozel boyut window'un boyutu " + driver.manage().window().getSize());


        Thread.sleep(8000);
        driver.quit();



    }
}
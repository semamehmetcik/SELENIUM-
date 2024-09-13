package day03_webelements_locators;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import utilities.ReusableMethods;

import java.time.Duration;
import java.util.List;

public class C03_ByClassName {

    public static void main(String[] args)  {

        ReusableMethods.bekle(1);

        //1- Bir test class’i olusturun ilgili ayarlari yapin
        //System.setProperty("Webdriver.chrome.driver","kurulumDosyalari/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //2- https://www.testotomasyonu.com/ adresine gidin
        driver.get("https://www.testotomasyonu.com/");
        //3- arama kutusuna phone yazip aratin
        driver.findElement(By.id("global-search"))
                .sendKeys("phone" + Keys.ENTER);

        //4- Category bolumunde 8 element oldugunu test edin

        List<WebElement> categoryElementleriList = driver.findElements(By.className("panel-list"));

        int expectedCategorySayisi = 8 ;
        int actualCategorySayisi = categoryElementleriList.size();

        if (expectedCategorySayisi == actualCategorySayisi){
            System.out.println("Category sayisi testi PASSED");
        }else System.out.println("Category sayisi testi FAILED");

        //5- Category isimlerini yazdirin
        // Liste Webelement'lerden olustugu icin, listeyi direkt YAZDIRAMAYIZ
        // for-loop ile webelementleri tek tek ele alip, uzerlerindeki yaziyi yazdirabiliriz

        for( WebElement eachElement : categoryElementleriList){

            System.out.println(eachElement.getText());
        }

        // category'ler icerisinde "Travel" bulundugunu test edin

        boolean travelVarMi = false;

        for( WebElement eachElement : categoryElementleriList){

            if (eachElement.getText().equalsIgnoreCase("Travel")){
                travelVarMi = true;
            }
        }

        if (travelVarMi){ // travelVarMi == true
            System.out.println("Travel testi1 PASSED");
        }else System.out.println("Travel testi1 FAILED");

        // Webelement'lerden olusan listeyi, String'lerden olusan listeye ceviren bir method olusturalim

        if ( ReusableMethods.stringListeyeCevir(categoryElementleriList).contains("Travel") ){
            System.out.println("Travel testi2 PASSED");
        }else System.out.println("Travel testi2 FAILED");



        //6- Sayfayi kapatin

        ReusableMethods.bekle(3);
        driver.quit();

    }
}
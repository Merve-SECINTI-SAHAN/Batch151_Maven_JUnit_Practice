package day01_practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class C02 {
    WebDriver driver;
    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void test01() throws InterruptedException {

        // https://www.techproeducation.com/ sayfasina gidin
      driver.get("https://www.techproeducation.com/");

        // Title ve Url'ini alın ve yazdırın
        String techproTitle= driver.getTitle();
        System.out.println("TechproEducation Title: "+techproTitle);

        String techproURL = driver.getCurrentUrl();
        System.out.println("TechproEducation URL: "+techproURL);
        Thread.sleep(1500);

        // Title'in "Techpro" kelimesini içerip içermedigini test edin
        Assert.assertTrue(techproTitle.contains("Techpro"));

        // Url'in "techproeducation" kelimesini içerip içermedigini test edin
        Assert.assertTrue(techproURL.contains("techproeducation"));


        // https://www.amazon.com/ sayfasına gidin
        driver.get("https://www.amazon.com/");
        Thread.sleep(1500);

        // Title'ini alın ve yazdırın
        String amazonTitle= driver.getTitle();
        System.out.println("Amazon Title: "+amazonTitle);


        // Title'in "more" kelimesini içerip içermedigini test edin
        Assert.assertTrue(amazonTitle.contains("more"));
        Thread.sleep(1500);

        // techproeducation.com'a geri dönün
        driver.navigate().back();

        // sayfayı yenileyin
        driver.navigate().refresh();
        Thread.sleep(1500);


        // amazon.com'a tekrar gelin
        driver.navigate().forward();


    }


}

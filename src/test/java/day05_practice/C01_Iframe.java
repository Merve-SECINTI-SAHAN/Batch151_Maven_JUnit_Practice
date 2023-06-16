package day05_practice;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C01_Iframe extends TestBase {

    // https://www.jqueryscript.net/demo/jQuery-Plugin-For-Responsive-Flexible-Iframes-Flexy/ sayfasına gidiniz
    // Videoyu görecek kadar asagiya ininiz
    // Videoyu izlemek icin Play tusuna basiniz
    // videoyu durdurunuz
    // videoyu tam ekran yapınız
    // videoyu calıstırınız
    // videoyu kucultunuz
    // videoyu durdurunuz
    // Videoyu calistirdiginizi test ediniz
    // 'jQuery Flexy Plugin Demos' yazısının gorunur oldugunu test ediniz



    @Test
    public void test01() throws InterruptedException {

        // https://www.jqueryscript.net/demo/jQuery-Plugin-For-Responsive-Flexible-Iframes-Flexy/ sayfasına gidiniz
        driver.get("https://www.jqueryscript.net/demo/jQuery-Plugin-For-Responsive-Flexible-Iframes-Flexy/");


        // Videoyu görecek kadar asagiya ininiz
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).perform();


        // Videoyu izlemek icin Play tusuna basiniz
        WebElement iframe = driver.findElement(By.xpath("//iframe[@src='https://www.youtube.com/embed/x3kfyZJhC3U?rel=0&showinfo=0']"));
        driver.switchTo().frame(iframe);


        /*
        play'i dogru locate edip click yapmamıza ragmen videoyu calıstırmadı.
        Bunun üzerine HTML kodlarını inceleyince Play'in aslında bir iframe icerisinde oldugunu gördük
        Bu durumda önce iframe locate edip sonra switchTo() ile iframe'e gecmeliyiz
         */

        WebElement playTusu = driver.findElement(By.xpath("//button[@class='ytp-large-play-button ytp-button ytp-large-play-button-red-bg']"));
        playTusu.click();


        // videoyu durdurunuz
        WebElement videoDurdur= driver.findElement(By.xpath("//button[@class='ytp-play-button ytp-button']"));
        videoDurdur.click();

        Thread.sleep(3000);

        // videoyu tam ekran yapınız
        WebElement tamEkran= driver.findElement(By.xpath("//button[@class='ytp-fullscreen-button ytp-button']"));
        tamEkran.click();

        Thread.sleep(3000);


        // videoyu calıstırınız
        videoDurdur.click();

        Thread.sleep(3000);

        // videoyu kucultunuz
        tamEkran.click();

        Thread.sleep(3000);


        // videoyu durdurunuz
        videoDurdur.click();


        // Videoyu calistirdiginizi test ediniz
        WebElement youTubeYazisi = driver.findElement(By.xpath("//a[@class='ytp-youtube-button ytp-button yt-uix-sessionlink']"));
        Assert.assertTrue(youTubeYazisi.isDisplayed());


        // 'jQuery Flexy Plugin Demos' yazısının gorunur oldugunu test ediniz
        driver.switchTo().parentFrame();
        WebElement jQueryYazisi =driver.findElement(By.xpath("//h1"));
        Assert.assertTrue(jQueryYazisi.isDisplayed());


    }

}
//driver.switchTo().frame(iframe);
//driver i switchTo(); ile icteki web sayfasina gecirdik. Sonra play tusuna bastik.


//switchTo(). dedigimizde karsimiza 3 frame gelir bu ücü de driveri icteki web sayfasina gecirmek icin
//kullanilir. bizim kullandigimizin icinde webelement yaziyordu. parantez icine locate yazdik.
//diger yöntem name or id kullanmak. iframe in html kodlarindan name ve id aliriz
//diger yöntem iframe in index ini yazmaktir. iframe in indexini alip yazariz.
//id or name attribute almak ve direkt locate amlmak daha sagliklidir.

//indexini nasil aliriz?
//web sayfasina gideriz sag click incele deriz.html kodlarindan asagidaki cubuga //iframe yazariz.
// sayfada kac tane iframe oldugunu gösterir. ok tuslariyla iframe in indexlerini kullanarak
// icteki web sayfasina gecebiliriz. indexte yeni iframe eklendiginde kayma olabilir, pek saglikli degil
//en saglikli yöntem locate almaktir
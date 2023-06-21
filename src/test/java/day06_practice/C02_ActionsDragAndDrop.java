package day06_practice;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C02_ActionsDragAndDrop extends TestBase {
    @Test
    public void test01() {
// https://demoqa.com/droppable adresine gidiniz
        driver.get("https://demoqa.com/droppable");
// 'Drag me' butonunu tutup 'Drop here' kutusunun ustune birakiniz

        WebElement drag = driver.findElement(By.xpath("(//div)[64]"));
        WebElement drop = driver.findElement(By.xpath("(//div)[65]"));
        Actions actions = new Actions(driver);
        actions.clickAndHold(drag).moveToElement(drop).release().perform();

// 'Drop here' yazisi yerine 'Dropped!' oldugunu test ediniz
        WebElement yaziTest=driver.findElement(By.xpath("(//p)"));
        String actual=yaziTest.getText();
        String excepted="Dropped!";
        Assert.assertEquals(excepted,actual);


    }
}

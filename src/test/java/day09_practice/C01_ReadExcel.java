package day09_practice;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Assert;
import org.junit.Test;
import utilities.TestBase;

import java.io.FileInputStream;
import java.io.IOException;


public class C01_ReadExcel extends TestBase {
    @Test
    public void test01() throws IOException {
        //pom.xml'e excel dependency'lerini kopyaladık.



        // Ulkeler dosyasındaki 3.satırdaki indexin, 3. sutunundaki indexinin
        // "Cezayir" oldugunu test eden method olusturunuz.

        int satirNuIdx=3;
        int sutunNoIdx=3;

       String actualDAta= banaDataGetir(satirNuIdx,sutunNoIdx);
       String expectedData="Cezayir";

        Assert.assertEquals(expectedData, actualDAta);

    }

    public static String banaDataGetir(int satirNuIdx, int sutunNoIdx) throws IOException {
        FileInputStream fis= new FileInputStream("src/resources/ulkeler.xlsx"); //ülkeler dosyasını getirdi
        Workbook workbook= WorkbookFactory.create(fis); //dosyayı workbook'a atadık
       String istenenData= workbook.getSheet("Sayfa1").getRow(satirNuIdx).getCell(sutunNoIdx).toString();

       return istenenData;

    }
}

package day09_practice;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;
import utilities.TestBase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class C02 extends TestBase {

    //ulkeler dosyasındaki "Başkent(İngilizce)" sutununu yazdırınız.


    @Test
    public void test01() throws IOException {
        FileInputStream fis= new FileInputStream("src/resources/ulkeler.xlsx");
        Workbook workbook= WorkbookFactory.create(fis);

       int sonSatirIdx= workbook.getSheet("Sayfa1").getLastRowNum(); //getLastRowNum() son satır numarasını index olarak verir
        System.out.println(sonSatirIdx);
        for (int i = 0; i <= sonSatirIdx; i++) {
         String satirdakiData=   C01.banaDataGetir(i,1);
            System.out.println(satirdakiData);

        }

    }
}

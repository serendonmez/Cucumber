package stepdefinitions;


import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import pages.TestotomasyonuPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.io.FileInputStream;
import java.io.IOException;

public class TestotomasyonuStepdefinitions {
        TestotomasyonuPage testotomasyonuPage=new TestotomasyonuPage();
        Actions actions=new Actions(Driver.getDriver());
        JavascriptExecutor jse= (JavascriptExecutor) Driver.getDriver();
    String urununIsmi;
    String urununMiktari;
    String bulunanSonucsayisi;

    @Given("kullanici testotomasyonu anasayfaya gider")
    public void kullanici_testotomasyonu_anasayfaya_gider() {
        Driver.getDriver().get(ConfigReader.getProperty("toUrl"));
    }

    @When("arama kutusuna phone yazip aratir")
    public void arama_kutusuna_phone_yazip_aratir() {
        testotomasyonuPage.aramakutusu.sendKeys("phone"+ Keys.ENTER);
    }

    @Then("arama sonucunda urun bulunabildigini test eder")
    public void arama_sonucunda_urun_bulunabildigini_test_eder() {
       Assertions.assertTrue (testotomasyonuPage.sonucElementleriList.size()>0);
    }

    @Then("sayfayi kapatir")
    public void sayfayi_kapatir() {
        Driver.quitDriver();
    }

    @When("arama kutusuna dress yazip aratir")
    public void aramaKutusunaDressYazipAratir() {
        testotomasyonuPage.aramakutusu.sendKeys("dress"+Keys.ENTER);
    }


    @And("{int} saniye bekler")
    public void saniyeBekler(int saniye) {
        ReusableMethods.bekle(saniye);
    }


    @Given("kullanici {string} anasayfaya gider")
    public void kullanici_anasayfaya_gider(String url) {
      Driver.getDriver().get(ConfigReader.getProperty(url));
    }

    @When("kullanici account butonuna basar")
    public void kullanici_account_butonuna_basar() {
        testotomasyonuPage.accountLinki.click();
    }



    @Then("signIn butonuna basar")
    public void sign_in_butonuna_basar() {
        testotomasyonuPage.loginSigninButonu.click();
    }

    @Then("basarili giris yapabildigni test eder")
    public void basarili_giris_yapabildigni_test_eder() {
        Assertions.assertTrue(testotomasyonuPage.logOutButonu.isDisplayed());
    }


    @Then("account butonuna basar")
    public void accountButonunaBasar() {
        testotomasyonuPage.accountLinki.click();
    }

    @When("email olarak {string} girer")
    public void emailOlarakGirer(String eMail) {
        testotomasyonuPage.loginEmailKutusu.sendKeys(ConfigReader.getProperty(eMail));
    }

    @And("password olarak {string} girer")
    public void passwordOlarakGirer(String password) {
        testotomasyonuPage.loginPasswordKutusu.sendKeys(ConfigReader.getProperty(password));
    }

    @And("giris yapilamadigini test eder")
    public void girisYapilamadiginiTestEder() {
        Assertions.assertTrue(testotomasyonuPage.loginSigninButonu.isDisplayed());
    }

    @Then("urun excelindeki {string} daki urunun min. miktarini ve urun ismini kaydeder")
    public void urunExcelindekiDakiUrununMinMiktariniVeUrunIsminiKaydeder(String istenenSatir) throws IOException {
        String dosyaYolu="src/test/resources/urunListesi.xlsx";
        FileInputStream fileInputStream=new FileInputStream(dosyaYolu);
        Workbook workbook= WorkbookFactory.create(fileInputStream);
       Sheet sheet= workbook.getSheet("Sheet1");
       int satirNo=Integer.parseInt(istenenSatir);
       urununIsmi=sheet.getRow(satirNo-1).getCell(0).toString();
        urununMiktari= sheet.getRow(satirNo-1).getCell(1).toString();

    }

    @And("urun ismini testotomasyonu sayfasinda arar ve sonuc sayisini kaydeder")
    public void urunIsminiTestotomasyonuSayfasindaArarVeSonucSayisiniKaydeder() {
        testotomasyonuPage.aramakutusu.sendKeys(urununIsmi+Keys.ENTER);

        bulunanSonucsayisi= testotomasyonuPage.aramaSonucElementi.getText(); //4 Products Found


    }

    @And("bulunan urun sayisinin {string} da verilen min. miktara esit veya miktardan fazla oldugunu test eder")
    public void bulunanUrunSayisininDaVerilenMinMiktaraEsitVeyaMiktardanFazlaOldugunuTestEder(String istenenSatir) {

        Double intexceldekiUrunMik=Double.parseDouble(urununMiktari);
        Double sonucSayisi= Double.parseDouble(bulunanSonucsayisi.replaceAll("\\D",""));

        Assertions.assertTrue(sonucSayisi>=intexceldekiUrunMik);

    }


    @When("arama kutusuna {string} yazip aratir")
    public void aramaKutusunaYazipAratir(String aranacakKelime) {
        testotomasyonuPage.aramakutusu.sendKeys(aranacakKelime+ Keys.ENTER);
    }

    @And("aratilanUrune tiklar")
    public void aratilanuruneTiklar() {
        testotomasyonuPage.sonucElementleriList.get(0).click();
    }
    @And("aratilan Urunu sepetine ekler")
    public void aratilanUrunuSepetineEkler() {
        jse.executeScript("arguments[0].scrollIntoView({block: 'center'});"
                ,testotomasyonuPage.addToCartButonu);
        testotomasyonuPage.addToCartButonu.click();
    }
    @Then("kullanici sepete click yapar")
    public void kullaniciSepeteClickYapar() {
        testotomasyonuPage.yourCartLinki.click();
    }


    @Then("sepetin bos olmadigini test eder")
    public void sepetinBosOlmadiginiTestEder() {
        Assertions.assertTrue(testotomasyonuPage.sepettekiUrunIsimElementi.isDisplayed());
    }

    @And("arama sonucunda urun bulunamadigini test eder")
    public void aramaSonucundaUrunBulunamadiginiTestEder() {
        String expectedAramaSonucu="0 Products Found";
        String actualAramaSonucu=testotomasyonuPage.aramaSonucElementi.getText();

        Assertions.assertEquals(expectedAramaSonucu,actualAramaSonucu);
    }
}

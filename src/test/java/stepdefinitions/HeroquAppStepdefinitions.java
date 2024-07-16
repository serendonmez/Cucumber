package stepdefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import pages.HeroquPage;

import java.util.NoSuchElementException;

public class HeroquAppStepdefinitions {
    HeroquPage heroquPage = new HeroquPage();

    @When("kullanici Add Element butonuna basar")
    public void kullanici_add_element_butonuna_basar() {
        heroquPage.addElement.click();
    }
    @When("Delete butonu’nun gorunur oldugunu test eder")
    public void delete_butonu_nun_gorunur_oldugunu_test_eder() {
        Assertions.assertTrue(heroquPage.deleteButonu.isDisplayed());
    }

    @Then("Delete tusuna basar")
    public void delete_tusuna_basar() {
        heroquPage.deleteButonu.click();
    }

    @Then("Delete butonunun kayboldugunu test eder")
    public void delete_butonunun_kayboldugunu_test_eder() {

        boolean elementYokOlduMu=false;
        try {
            Assertions.assertFalse(heroquPage.deleteButonu.isDisplayed());
        } catch (Exception e) {
            elementYokOlduMu=true;
        }
        // yok olan elementi locate etmeye calisip islem gerceklestirmeyecegi icin
        // zaten istedigimiz noSuchElement exception inini try -Catch ile surround ettik
        // try catch yaptitigmiz exception in ardindan testi yapariz:

        Assertions.assertTrue(elementYokOlduMu);

    }
    @Then("Add Remove Elements yazisinin gorunur oldugunu test eder")
    public void add_remove_elements_yazisinin_gorunur_oldugunu_test_eder() {

        Assertions.assertTrue(heroquPage.addRemoveText.isDisplayed());

    }

}

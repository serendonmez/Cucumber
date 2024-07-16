
Feature: US1001 Testotomasyonu arama testi
  Background: anasayfaya gitme
    Given kullanici "toUrl" anasayfaya gider

    # sadece baslangictaki ortak adimlar Background olarak tanimlanabilir

  Scenario: TC04 Kullanici sitede phone aratabilmeli

    When arama kutusuna phone yazip aratir
    Then arama sonucunda urun bulunabildigini test eder
    And sayfayi kapatir


  Scenario: TC05 Kullanici sitede dress aratabilmeli

    When arama kutusuna dress yazip aratir
    Then arama sonucunda urun bulunabildigini test eder
    And sayfayi kapatir


  Scenario: TC06 Kullanici sitede samsung aratabilmeli

    When arama kutusuna samsung yazip aratir
    Then arama sonucunda urun bulunabildigini test eder
    And sayfayi kapatir
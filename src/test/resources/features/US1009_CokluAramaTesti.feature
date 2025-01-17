Feature: US1009 kullanici testotomasyonu sayfasinda toplu arama yapar

  Scenario Outline: TC15 kullanici coklu urun aramasi yapabilmeli
    Given kullanici "toUrl" anasayfaya gider
    Then arama kutusuna "<aranacakKelime>" yazip aratir
    #< > -> List teki data type gibi examples daki aranacakkelimeleri arama kutusunda arat
    And arama sonucunda urun bulunabildigini test eder
    And sayfayi kapatir

    Examples:
      |aranacakKelime|
      |phone  |
      |java   |
      |nutella|
      |dress  |
      |apple  |
      |samsung|
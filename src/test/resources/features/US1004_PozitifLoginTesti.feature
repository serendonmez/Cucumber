
Feature: US1004 Kuallnici gecerli bilgilerle sisteme giris yapabilir
  @smoke @regression @wip # wip work in Progress
    # calistigimiz dosyaya @wip tagini ekleriz
    # runner o dosyayi calistirir.

  Scenario: TC08 Gecerli bilgilerle sisteme giris yapabilmeli

    Given kullanici "toUrl" anasayfaya gider
    Then account butonuna basar
    And email olarak "toGecerliEmail" girer
    And password olarak "toGecerliPassword" girer
    Then signIn butonuna basar
    And basarili giris yapilabildigini test eder
    And 3 saniye bekler
    #And sayfayi kapatir
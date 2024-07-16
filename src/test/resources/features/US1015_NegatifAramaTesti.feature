#testotomasyonu sf ina gidin
  #verilen kelimelerin sitede bulunmadigini tek tek test edin
  #java Cokokrem nutella pizze masa Sandalye


  Feature:US1015 Negatif arama tetsi
    Scenario Outline: TC21 verilen kelimeler sitede bulunmamali
      Given kullanici "toUrl" anasayfaya gider
      Then arama kutusuna "<aranacakKelime>" yazip aratir
      And arama sonucunda urun bulunamadigini test eder


      Examples:
      |aranacakKelime|
      |java  |
      | Cokokrem|
       |nutella  |
      | pizza  |
      | masa |
      | Sandalye|

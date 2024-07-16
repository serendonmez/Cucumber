Feature:US1012 Ecxelde verilen urunlerin sonuc sayisi test edilir
  Scenario Outline: TC18 sitede istenen ürünlerin minimum miktarda sonucu olmali

    Given kullanici "toUrl" anasayfaya gider
    Then urun excelindeki "<istenenSatir>" daki urunun min. miktarini ve urun ismini kaydeder
    And urun ismini testotomasyonu sayfasinda arar ve sonuc sayisini kaydeder
    And bulunan urun sayisinin "<istenenSatir>" da verilen min. miktara esit veya miktardan fazla oldugunu test eder
    And sayfayi kapatir
    Examples:
      |istenenSatir|
      |2          |
      |3          |
      |4          |
      |5          |
      |6          |
      |7          |
      |8          |
      |9          |
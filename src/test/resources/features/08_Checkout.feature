Feature: Checkout

  Scenario: Verifikasi daftar produk ditampilkan setelah login
    Given Pretest verifikasi, login dengan user valid
    When Verifikasi semua produk ditampilkan
    Then Daftar produk muncul lengkap dengan nama, harga, dan tombol Add to Cart
    Then Lanjut dari ringkasan pembelian
    And  Klik tombol Finish


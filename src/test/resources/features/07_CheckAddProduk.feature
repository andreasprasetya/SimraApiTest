Feature: CheckAddProduk

  Scenario: Verifikasi daftar produk ditampilkan setelah login
    Given Pretest verifikasi, login dengan user valid
    When Verifikasi semua produk ditampilkan
    Then Daftar produk muncul lengkap dengan nama, harga, dan tombol Add to Cart
    And Klik tombol Add to Cart pada salah satu produk
    Then Klik ikon keranjang
    And Tambah produk ke keranjang
    Then Klik Checkout
    And  Masukkan informasi pelanggan
    Then Klik Continue

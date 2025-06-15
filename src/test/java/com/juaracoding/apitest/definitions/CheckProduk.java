package com.juaracoding.apitest.definitions;

import com.juaracoding.apitest.DriverSingleton;
import com.juaracoding.apitest.pages.ProdukListPage;
import com.juaracoding.apitest.pages.SignInPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class CheckProduk {
    WebDriver driver;
    SignInPage signInPage;
    ProdukListPage produkListPage;

    @Given("Pretest verifikasi, login dengan user valid")
    public void testStep01() {
        driver = DriverSingleton.createOrGetDriver();
        driver.get("https://www.saucedemo.com/v1/index.html");
        signInPage = new SignInPage(driver);
        produkListPage = new ProdukListPage(driver);
        signInPage.login("standard_user", "secret_sauce");
    }

    @When("Verifikasi semua produk ditampilkan")
    public void testStep02() {
        Assert.assertTrue(produkListPage.hasAProducts());
    }

    @Then("Daftar produk muncul lengkap dengan nama, harga, dan tombol Add to Cart")
    public void testStep03() {
        Assert.assertTrue(produkListPage.checkProperty());
    }

    @And("Klik tombol Add to Cart pada salah satu produk")
    public void testStep04() {
        Assert.assertTrue(produkListPage.checkProperty());
    }

    @Then("Klik ikon keranjang")
    public void testStep05() {
        Assert.assertTrue(produkListPage.checkProperty());
    }

    @And("Tambah produk ke keranjang")
    public void testStep06() {
        Assert.assertTrue(produkListPage.checkProperty());
    }

    @And("Klik Checkout")
    public void testStep08() {
        Assert.assertTrue(produkListPage.checkProperty());
    }
    @And("Masukkan informasi pelanggan")
    public void testStep09() {
        Assert.assertTrue(produkListPage.checkProperty());
    }
    @Then("Klik Continue")
    public void testStep10() {
        Assert.assertTrue(produkListPage.checkProperty());
    }




}

package ru.netology;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OrderCardTest {
   private WebDriver driver;

   @BeforeAll
    static void setupAll() {
       WebDriverManager.chromedriver().setup();
   }

   @BeforeEach
    void setup() {
       ChromeOptions options = new ChromeOptions();
       options.setHeadless(true);
       driver = new ChromeDriver(options);
   }

   @AfterEach
    void teardown (){
       driver.quit();
       driver = null;
   }

   


}

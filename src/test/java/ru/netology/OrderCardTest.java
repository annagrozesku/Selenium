package ru.netology;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OrderCardTest {
     private WebDriver driver;

   @BeforeAll
    static void setupAll() {
       WebDriverManager.chromedriver().setup();
   }

   @BeforeEach
    void setup() {
       ChromeOptions options = new ChromeOptions();
      options.addArguments("--disable-dev-shm-usage");
      options.addArguments("--no-sandbox");
      options.addArguments("--headless");
       driver = new ChromeDriver(options);
   }

   @AfterEach
    void teardown (){
       driver.quit();
       driver = null;
   }

   @Test
   public void shouldMustBeSubmitted (){
      driver.get("http://localhost:9999/");
      driver.findElement(By.cssSelector("[data-test-id=name] input")).sendKeys("Пупкин Василий");
      driver.findElement(By.cssSelector("[data-test-id=phone] input")).sendKeys("+79995687523");
      driver.findElement(By.className("checkbox__box")).click();
      driver.findElement(By.className("button__text")).click();
      String expected = "Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время.";
      String actual = driver.findElement(By.cssSelector("[data-test-id=order-success]")).getText().trim();
      assertEquals(expected, actual);

   }


}

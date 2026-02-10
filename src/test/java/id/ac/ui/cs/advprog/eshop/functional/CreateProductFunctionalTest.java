package id.ac.ui.cs.advprog.eshop.functional;

import io.github.bonigarcia.seljup.SeleniumJupiter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@SpringBootTest(webEnvironment = RANDOM_PORT)
@ExtendWith(SeleniumJupiter.class)
class CreateProductFunctionalTest {

    @LocalServerPort
    private int serverPort;

    @Value("${app.baseUrl:http://localhost}")
    private String testBaseUrl;

    private String baseUrl;

    @BeforeEach
    void setupTest() {
        baseUrl = String.format("%s:%d", testBaseUrl, serverPort);
    }

    @Test
    void userCanCreateProductAndSeeItInList(ChromeDriver driver) {
        // 1. Open CREATE product page (THIS WAS THE BIG BUG)
        driver.get(baseUrl + "/product/create");

        // 2. Fill product name (matches @ModelAttribute Product)
        WebElement nameInput = driver.findElement(By.name("productName"));
        nameInput.sendKeys("Sampo Cap Bambang");

        // 3. Fill product quantity
        WebElement quantityInput = driver.findElement(By.name("productQuantity"));
        quantityInput.sendKeys("100");

        // 4. Submit form
        driver.findElement(By.cssSelector("button[type='submit']")).click();

        // 5. Verify redirected to product list and product appears
        String pageSource = driver.getPageSource();
        assertTrue(pageSource.contains("Sampo Cap Bambang"));
        assertTrue(pageSource.contains("100"));
    }
}
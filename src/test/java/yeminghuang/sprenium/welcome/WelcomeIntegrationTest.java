package yeminghuang.sprenium.welcome;

import yeminghuang.sprenium.support.SeleniumTest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.assertj.core.api.Assertions.assertThat;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(properties = "server.port=9000", webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@SeleniumTest(driver = ChromeDriver.class, baseUrl = "http://localhost:9000")
public class WelcomeIntegrationTest {

    @Autowired
    private WebDriver driver;

    @Test
    public void correctWelcomeMessage() {
        assertThat(driver.findElement(By.xpath("//div[@id='welcomeMessage']/h2")).getText()).isEqualTo("Message: AFT kicks butts");
    }

    @Test
    public void correctTitle() {
        assertThat(driver.getTitle()).isEqualTo("Sprenium Home");
    }

    @Test
    public void canBrowseToThingPage() {
        driver.findElement(By.linkText("Things")).click();
        assertThat(driver.getCurrentUrl()).isEqualTo("http://localhost:9000/thing");
    }
}

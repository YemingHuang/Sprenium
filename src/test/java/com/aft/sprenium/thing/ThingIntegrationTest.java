package com.aft.sprenium.thing;

import com.aft.sprenium.support.SeleniumTest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(properties = "server.port=9000", webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@SeleniumTest(driver = PhantomJSDriver.class, baseUrl = "http://localhost:9000/thing")
public class ThingIntegrationTest {

    @Autowired
    private WebDriver driver;

    @Test
    public void showingThingsTableRight() {

        assertThat(driver.findElement(By.xpath("//table[@id='thingTable']/tbody/tr[position()=1]/td[position()=1]"))
                .getText()).isEqualTo("abc");
        assertThat(driver.findElement(By.xpath("//table[@id='thingTable']/tbody/tr[position()=1]/td[position()=2]"))
                .getText()).isEqualTo("The first thing");
        assertThat(driver.findElement(By.xpath("//table[@id='thingTable']/tbody/tr[position()=2]/td[position()=1]"))
                .getText()).isEqualTo("xyz");
        assertThat(driver.findElement(By.xpath("//table[@id='thingTable']/tbody/tr[position()=2]/td[position()=2]"))
                .getText()).isEqualTo("The second thing");

    }

    @Test
    public void newThingModalShows() {
        driver.findElement(By.id("addNew")).click();
        assertThat(driver.findElement(By.xpath("//div[@class='modal-header']/h4"))
                .getText()).isEqualTo("Add New");

    }

    @Test
    public void addNewModal() {

        String name = "wow";
        String description = "much descriptive";

        // Click open the modal
        driver.findElement(By.id("addNew")).click();

        // Fill in the form
        driver.findElement(By.xpath("//input[@id='name']")).sendKeys(name);
        driver.findElement(By.xpath("//input[@id='description']")).sendKeys(description);

        // Click
        driver.findElement(By.xpath("//input[@id='newThingSubmit']")).click();

        // Verify
        assertThat(driver.findElement(By.xpath("//table[@id='thingTable']/tbody/tr[position()=3]/td[position()=1]"))
                .getText()).isEqualTo(name);
        assertThat(driver.findElement(By.xpath("//table[@id='thingTable']/tbody/tr[position()=3]/td[position()=2]"))
                .getText()).isEqualTo(description);


    }

}
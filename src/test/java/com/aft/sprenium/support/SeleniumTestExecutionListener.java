package com.aft.sprenium.support;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.test.context.TestContext;
import org.springframework.test.context.support.AbstractTestExecutionListener;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.springframework.core.annotation.AnnotationUtils.findAnnotation;

@Configuration
public class SeleniumTestExecutionListener extends AbstractTestExecutionListener {

    static {
        System.setProperty("webdriver.chrome.driver", "bin/chromedriver");
    }

    private WebDriver webDriver;

    public int getOrder() {
        return Ordered.HIGHEST_PRECEDENCE;
    }

    @Bean
    public WebDriver getWebDriver() {
        return webDriver;
    }

    @Override
    public void prepareTestInstance(TestContext testContext) throws IllegalAccessException, InstantiationException {
        if (webDriver != null) {
            return;
        }
        ApplicationContext context = testContext.getApplicationContext();
        if (context instanceof ConfigurableApplicationContext) {

            SeleniumTest annotation = findAnnotation(
                    testContext.getTestClass(), SeleniumTest.class);
            webDriver = annotation.driver().newInstance();

            ConfigurableApplicationContext configurableApplicationContext = (ConfigurableApplicationContext) context;
            ConfigurableListableBeanFactory bf = configurableApplicationContext.getBeanFactory();
            bf.registerResolvableDependency(WebDriver.class, webDriver);
        }
    }

    @Override
    public void beforeTestMethod(TestContext testContext) {
        if (webDriver != null) {
            SeleniumTest annotation = findAnnotation(
                    testContext.getTestClass(), SeleniumTest.class);
            webDriver.get(annotation.baseUrl());
        }
    }

    @Override
    public void afterTestClass(TestContext testContext) {
        if (webDriver != null) {
            webDriver.quit();
        }
    }

    @Override
    public void afterTestMethod(TestContext testContext) throws Exception {
        if (testContext.getTestException() == null) {
            return;
        }
        File screenshot = ((TakesScreenshot) webDriver).getScreenshotAs(OutputType.FILE);
        String testName = testContext.getTestClass().getSimpleName();
        String methodName = testContext.getTestMethod().getName();
        Files.copy(screenshot.toPath(),
                Paths.get("target", testName + "_" + methodName + "_" + screenshot.getName()));
    }

}

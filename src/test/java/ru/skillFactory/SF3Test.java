package ru.skillFactory;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class SF3Test {
    private WebDriver driver;
    private Map<String, Object> vars;
    JavascriptExecutor js;
    @Before
    public void setUp() {
        driver = new ChromeDriver();
        js = (JavascriptExecutor) driver;
        vars = new HashMap<String, Object>();
    }
    @After
    public void tearDown() {
        driver.quit();
    }
    public String waitForWindow(int timeout) {
        try {
            Thread.sleep(timeout);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Set<String> whNow = driver.getWindowHandles();
        Set<String> whThen = (Set<String>) vars.get("window_handles");
        if (whNow.size() > whThen.size()) {
            whNow.removeAll(whThen);
        }
        return whNow.iterator().next();
    }
    @Test
    public void SF3Test() {
        driver.get("https://skillfactory.ru/");
        driver.manage().window().setSize(new Dimension(1477, 881));
        vars.put("window_handles", driver.getWindowHandles());
        driver.findElement(By.linkText("БЕСПЛАТНО")).click();
        vars.put("win8713", waitForWindow(2000));
        driver.switchTo().window(vars.get("win8713").toString());
        driver.findElement(By.cssSelector(".tn-elem__6423868331679404895615 > .tn-atom")).click();
        driver.findElement(By.cssSelector(".tn-elem__6423868331679404485958 > .tn-atom")).click();
        driver.findElement(By.cssSelector(".tn-elem__6423868331695193481766 > .tn-atom")).click();
        {
            WebElement element = driver.findElement(By.cssSelector(".tn-elem__6423868331679404657898 > .tn-atom"));
            Actions builder = new Actions(driver);
            builder.moveToElement(element).perform();
        }
        driver.findElement(By.cssSelector(".tn-elem__6423868331679404657898 > .tn-atom")).click();
        {
            WebElement element = driver.findElement(By.tagName("body"));
            Actions builder = new Actions(driver);
            builder.moveToElement(element, 0, 0).perform();
        }
        driver.findElement(By.cssSelector(".tn-elem__6443446381689195201355 > .tn-atom")).click();
        js.executeScript("window.scrollTo(0,2100)");
    }
}
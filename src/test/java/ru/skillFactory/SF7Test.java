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

public class SF7Test {
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
    public void SF7Test() {
        driver.get("https://skillfactory.ru/");
        driver.manage().window().setSize(new Dimension(1477, 881));
        {
            WebElement element = driver.findElement(By.cssSelector("li:nth-child(6) > .main__nav-item"));
            Actions builder = new Actions(driver);
            builder.moveToElement(element).perform();
        }
        vars.put("window_handles", driver.getWindowHandles());
        driver.findElement(By.cssSelector("li:nth-child(6) > .main__nav-item")).click();
        vars.put("win5085", waitForWindow(2000));
        {
            WebElement element = driver.findElement(By.tagName("body"));
            Actions builder = new Actions(driver);
            builder.moveToElement(element, 0, 0).perform();
        }
        driver.switchTo().window(vars.get("win5085").toString());
        vars.put("window_handles", driver.getWindowHandles());
        driver.findElement(By.linkText("Узнать больше о программах")).click();
        vars.put("win6675", waitForWindow(2000));
        driver.findElement(By.id("cardbtn4_425943296")).click();
        driver.switchTo().window(vars.get("win6675").toString());
        js.executeScript("window.scrollTo(0,6.857142925262451)");
    }
}

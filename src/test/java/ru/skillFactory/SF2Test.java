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

public class SF2Test {
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
    public void SF2Test() {
        driver.get("https://skillfactory.ru/");
        driver.manage().window().setSize(new Dimension(1477, 881));
        {
            WebElement element = driver.findElement(By.cssSelector(".t978__tm-link:nth-child(1)"));
            Actions builder = new Actions(driver);
            builder.moveToElement(element).perform();
        }
        driver.findElement(By.cssSelector(".t978__tm-link_active")).click();
        {
            WebElement element = driver.findElement(By.tagName("body"));
            Actions builder = new Actions(driver);
            builder.moveToElement(element, 0, 0).perform();
        }
        {
            WebElement element = driver.findElement(By.cssSelector("#nav623893182 .t978__menu-item:nth-child(1) .t978__link-inner"));
            Actions builder = new Actions(driver);
            builder.moveToElement(element).perform();
        }
        vars.put("window_handles", driver.getWindowHandles());
        driver.findElement(By.cssSelector("#nav623893182 .t978__menu-item:nth-child(1) .t978__link-inner")).click();
        vars.put("win1550", waitForWindow(2000));
        vars.put("root", driver.getWindowHandle());
        driver.switchTo().window(vars.get("win1550").toString());
        driver.switchTo().window(vars.get("root").toString());
        {
            WebElement element = driver.findElement(By.tagName("body"));
            Actions builder = new Actions(driver);
            builder.moveToElement(element, 0, 0).perform();
        }
        driver.switchTo().window(vars.get("win1550").toString());
        js.executeScript("window.scrollTo(0,575.4285888671875)");
        vars.put("window_handles", driver.getWindowHandles());
        driver.findElement(By.cssSelector("#Type-2-darkgreen .card__additional-img")).click();
        vars.put("win1702", waitForWindow(2000));
        driver.switchTo().window(vars.get("win1702").toString());
        driver.quit();
    }
}
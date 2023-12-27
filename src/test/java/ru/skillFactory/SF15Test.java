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

public class SF15Test {
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
    public void sF15() {
        driver.get("https://skillfactory.ru/");
        driver.manage().window().setSize(new Dimension(1477, 881));
        {
            WebElement element = driver.findElement(By.cssSelector("li:nth-child(3) > .main__nav-item"));
            Actions builder = new Actions(driver);
            builder.moveToElement(element).perform();
        }
        js.executeScript("window.scrollTo(0,1200)");
        vars.put("window_handles", driver.getWindowHandles());
        driver.findElement(By.cssSelector("#DAPR > .card__link")).click();
        vars.put("win8935", waitForWindow(2000));
        driver.switchTo().window(vars.get("win8935").toString());
        js.executeScript("window.scrollTo(0,10.285714149475098)");
        js.executeScript("window.scrollTo(0,421.1428527832031)");
        js.executeScript("window.scrollTo(0,1200)");
        driver.findElement(By.cssSelector(".tn-elem__4847798421661780967523 > .tn-atom")).click();
    }
}

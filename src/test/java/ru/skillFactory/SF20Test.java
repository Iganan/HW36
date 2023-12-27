package ru.skillFactory;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class SF20Test {
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
    public void sF20() {
        driver.get("https://skillfactory.ru/");
        driver.manage().window().setSize(new Dimension(1477, 881));
        driver.switchTo().frame(9);
        driver.findElement(By.cssSelector(".svelte-1qe9gqs")).click();
        driver.switchTo().defaultContent();
        driver.switchTo().frame(11);
        driver.findElement(By.cssSelector(".margin-top-10:nth-child(4) > div:nth-child(1) .flex:nth-child(2)")).click();
        driver.findElement(By.cssSelector(".margin-top-10:nth-child(4) > div:nth-child(1) > .card .flex:nth-child(2)")).click();
        js.executeScript("window.scrollTo(0,0)");
        driver.findElement(By.cssSelector(".bot-answer-button:nth-child(2)")).click();
        vars.put("window_handles", driver.getWindowHandles());
        driver.findElement(By.linkText("«Какая удаленная профессия ваша?»")).click();
        vars.put("win2639", waitForWindow(2000));
        driver.switchTo().window(vars.get("win2639").toString());
    }
}
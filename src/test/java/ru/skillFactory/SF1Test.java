package ru.skillFactory;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;

public class SF1Test {
    @Test
    public void SF1Test() {
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://skillfactory.ru/");
        String title = driver.getTitle();
        Assert.assertTrue(title.equals("Онлайн-школа Skillfactory — онлайн-обучение востребованным IT-профессиям"));
        driver.quit();
    }

}

package org.ait.qa25;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.sql.SQLOutput;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class FindElementTests {

    WebDriver driver;

    @BeforeMethod

    public void setUp() {
        driver = new ChromeDriver(); //инициализация переменной
        driver.get("https://ilcarro.web.app/"); //открытие сайта
        driver.manage().window().maximize(); //развернуть экран в полный размер именно на своем экране
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); //время ожидания всех элементов
    }

    @Test
    public void findElementTest() {

        WebElement element= driver.findElement(By.tagName("h1"));//поиск элемента на странице по тэгу
        System.out.println(element.getText());

        List<WebElement> elements = driver.findElements(By.tagName("a"));
        System.out.println(elements.size());

        driver.findElement(By.id("city")); // поиск элемента по id

        driver.findElement(By.className("input-label"));

        driver.findElement(By.name("viewport"));
    }

    @Test
    public void findElementByCssTest() {

        driver.findElement(By.cssSelector("h1"));
        driver.findElement(By.cssSelector("#city")); // id - #
        driver.findElement(By.cssSelector(".input-label")); // className - .
        driver.findElement(By.cssSelector("[name='viewport']"));
        driver.findElement(By.cssSelector("[class*='pristine']")); // содержание в тексте
        driver.findElement(By.cssSelector("[class^='ng']")); //поиск по началу слова
    }

    @Test
    public void findElementXpathTest() {

        driver.findElement(By.xpath("//h1"));
        driver.findElement(By.xpath("//input[@id='city']"));// id
        driver.findElement(By.xpath("//label[@class='input-label']")); // className
        driver.findElement(By.xpath("//h2[contains(.,'Type your data and hit Yalla!')]")); // по тексту

    }
}

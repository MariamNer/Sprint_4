package Order;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Objects;

public class OrderScooterChromeTest {
    private WebDriver driver;

    @Before
    public void open() {
        driver = new ChromeDriver();
        driver.get("https://qa-scooter.praktikum-services.ru/");
        driver.findElement(By.xpath("//*[@id=\"rcc-confirm-button\"]")).click(); // кликаю кнопку для принятия куки
    }

    @Test
    public void orderScooter(){
        String buttonOrder = "//*[@id=\"root\"]/div/div/div[1]/div[2]/button[1]";
        WebElement element = driver.findElement(By.xpath (buttonOrder));
        //нажимаем на кнопку "Заказать"
        driver.findElement(By.xpath (buttonOrder)).click();
        // Ожидание, что кнопка станет кликабельной; ожидание не больше 3 секунд
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.elementToBeClickable(By.tagName("button")));
        //вводим тестовые данные в поля в форме "Для кого самаокат"
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[1]/input")).sendKeys("Биба");
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[2]/input")).sendKeys("Боба");
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[3]/input")).sendKeys("Биба1");
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[4]/div/div/input")).click();
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[4]/div/div[2]/ul/li[2]")));
        System.out.println(driver.getPageSource());
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[4]/div/div[2]/ul/li[2]/button")).click();
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[5]/input")).sendKeys("+78888888888");
        //кликаем по кнопке "Далее"
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div[3]/button")).click();
        //заполняем и селектим поля в форме "Про аренду"
        driver.findElement(By.xpath("/html/body/div/div/div[2]/div[2]/div[1]/div[1]/div/input")).sendKeys("28.09.2024");
        driver.findElement(By.xpath("/html/body/div/div/div[2]/div[1]")).click();
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[2]/div[1]/div[1]")).click();
        //дописать выбор срока аренды
        driver.findElement(By.xpath("/html/body/div/div/div[2]/div[2]/div[2]/div[2]/div[2]")).click();

        driver.findElement(By.xpath("/html/body/div/div/div[2]/div[3]/button[2]")).click();
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div[5]/div[2]/button[2]")).click();

        String textFact = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div[5]/div[1]")).getText(); // Найди поле и получить её текст
        String textExpected = "Заказ оформлен";
        //сравниваем текст
        Boolean areTextsEqual = Objects.equals(textFact, textExpected);
        System.out.println("areTextsEqual: " + areTextsEqual);
        System.out.println("textFact: " + textFact);
        System.out.println("textExpected: " + textExpected);
    }

    @After
    public void closeBrowser() {
        driver.quit();
    }

}

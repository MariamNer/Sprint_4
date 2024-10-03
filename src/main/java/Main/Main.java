package Main;
import org.example.TestOperator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;


public class Main {
    public static void main(String[] args) {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox", "--headless", "--disable-dev-shm-usage");
        WebDriver chromeDriver = new ChromeDriver(options);
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        firefoxOptions.addArguments("-headless");
        WebDriver firefoxDriver = new FirefoxDriver(firefoxOptions);

        chromeDriver.get("https://qa-scooter.praktikum-services.ru/"); // метод для открытия страницы в браузере
        String xpath_voprosi_o_vajnom = "//*[@id=\"root\"]/div/div/div[5]/div[2]/div/div[8]/div[1]";
        WebElement element = chromeDriver.findElement(By.xpath (xpath_voprosi_o_vajnom));
        ((JavascriptExecutor)chromeDriver).executeScript("arguments[0].scrollIntoView();", element); // скролл до элемента "Вопросы о важном"

        firefoxDriver.get("https://qa-scooter.praktikum-services.ru/"); // метод для открытия страницы в браузере
        WebElement element2 = firefoxDriver.findElement(By.xpath (xpath_voprosi_o_vajnom));
        ((JavascriptExecutor)firefoxDriver).executeScript("arguments[0].scrollIntoView();", element2);

        TestOperator chromeOpertor = new TestOperator(chromeDriver);
        chromeOpertor.test1();
        chromeOpertor.test2();
        chromeOpertor.test3();
        chromeOpertor.test4();
        chromeOpertor.test5();
        chromeOpertor.test6();
        chromeOpertor.test7();
        chromeOpertor.test8();

        chromeDriver.quit();

        TestOperator firefoxOperator = new TestOperator(firefoxDriver);
        firefoxOperator.test1();
        firefoxOperator.test2();
        firefoxOperator.test3();
        firefoxOperator.test4();
        firefoxOperator.test5();
        firefoxOperator.test6();
        firefoxOperator.test7();
        firefoxOperator.test8();

        firefoxDriver.quit();

    }

}


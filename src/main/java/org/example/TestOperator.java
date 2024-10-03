package org.example;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Objects;
import org.apache.commons.io.FileUtils;

public class TestOperator {
    private WebDriver driver;

    private By signInField = By.xpath("//*[@id=\"root\"]/div/div/div[5]/div[2]/div/div[1]/div[1]"); // локатор для поля "Сколько это стоит?..."
    private By locator_signMultipleInField = By.xpath("//*[@id=\"root\"]/div/div/div[5]/div[2]/div/div[2]/div[1]"); // локатор для поля "Хочу сразу несколько самокатов"
    private By signTimeInField = By.xpath("//*[@id=\"root\"]/div/div/div[5]/div[2]/div/div[3]/div[1]"); // локатор для поля "Как рассчитывать время аренды"
    private By signTodayInField = By.xpath("//*[@id=\"root\"]/div/div/div[5]/div[2]/div/div[4]/div[1]"); // локатор для поля "Можно ли заказать самокат прямо на сегодня"
    private By signReturnInField = By.xpath("//*[@id=\"root\"]/div/div/div[5]/div[2]/div/div[5]/div[1]"); // локатор для поля "Можно ли продлить заказ..."
    private By signTogetherInField = By.xpath("//*[@id=\"root\"]/div/div/div[5]/div[2]/div/div[6]/div[1]"); // локатор для поля "Вы привозите зарядку вместе с самокатом"
    private By signCancelInField = By.xpath("//*[@id=\"root\"]/div/div/div[5]/div[2]/div/div[7]/div[1]"); // локатор для поля "Можно ли отменить заказ"
    private By signLifeInField = By.xpath("//*[@id=\"root\"]/div/div/div[5]/div[2]/div/div[8]/div[1]"); // локатор для поля "Я живу за МКАДом, привезете?"

    // конструктор класса
    public TestOperator(WebDriver driver){
        this.driver = driver;
    }

    public void clickByButton() {
        driver.findElement(By.xpath ("//*[@id=\"rcc-confirm-button\"]")).click();
        // Ожидание, что кнопка станет кликабельной; ожидание не больше 3 секунд
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.elementToBeClickable(By.tagName("button")));
    }

    public void clickByLocator(By locator) {
        driver.findElement(locator).click();
    }

    public void test1() {
        clickByButton();
        clickByLocator(signInField);
        String xpath_skolko_stoit = "//*[@id=\"accordion__panel-0\"]";
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath_skolko_stoit)));
        String textFact = driver.findElement(By.className("accordion__panel")).getText(); // Найди поле и получить её текст
        String textExpected = "Сутки — 400 рублей. Оплата курьеру — наличными или картой.";
        Boolean areTextsEqual = Objects.equals(textFact, textExpected);
        System.out.println("areTextsEqual: " + areTextsEqual);
        System.out.println("textFact: " + textFact);
        System.out.println("textExpected: " + textExpected);
    }


    public void test2() {
        clickByLocator(locator_signMultipleInField);
        String xpath_skolko_stoit = "//*[@id=\"accordion__panel-1\"]";
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath_skolko_stoit)));
//        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
//        try {
//            FileUtils.copyFile(scrFile, new File("C:\\Users\\other_user\\Desktop\\screenshot.png"));
//        } catch (IOException e) {
//            System.out.println("Failed to create screenshot: " + e.getMessage());
//        }
//        WebElement tempElement = driver.findElement(By.className("accordion__panel"));
//        for (WebElement element : driver.findElements(By.className("accordion__panel"))) {
//            System.out.println(element.getText());
//        }
        String textFact = driver.findElement(By.xpath("//*[@id=\"accordion__panel-1\"]")).getText(); // Найди поле и получить её текст
        String textExpected = "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.";
        Boolean areTextsEqual = Objects.equals(textFact, textExpected);
        if (textFact.isEmpty()) {
            System.out.println(driver.getPageSource());
        }
        System.out.println("areTextsEqual: " + areTextsEqual);
        System.out.println("textFact: " + textFact);
        System.out.println("textExpected: " + textExpected);
    }

    public void test3() {
        clickByLocator(signTimeInField);
        String xpath_skolko_stoit = "//*[@id=\"accordion__panel-2\"]";
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath_skolko_stoit)));
        String textFact = driver.findElement(By.xpath("//*[@id=\"accordion__panel-2\"]")).getText(); // Найди поле и получить её текст
        String textExpected = "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.";
        Boolean areTextsEqual = Objects.equals(textFact, textExpected);
        System.out.println("areTextsEqual: " + areTextsEqual);
        System.out.println("textFact: " + textFact);
        System.out.println("textExpected: " + textExpected);
    }

    public void test4() {
        clickByLocator(signTodayInField);
        String xpath_skolko_stoit = "//*[@id=\"accordion__panel-3\"]";
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath_skolko_stoit)));
        String textFact = driver.findElement(By.xpath("//*[@id=\"accordion__panel-3\"]")).getText(); // Найди поле и получить её текст
        String textExpected = "Только начиная с завтрашнего дня. Но скоро станем расторопнее.";
        Boolean areTextsEqual = Objects.equals(textFact, textExpected);
        System.out.println("areTextsEqual: " + areTextsEqual);
        System.out.println("textFact: " + textFact);
        System.out.println("textExpected: " + textExpected);
    }

    public void test5() {
        clickByLocator(signReturnInField);
        String xpath_skolko_stoit = "//*[@id=\"accordion__panel-4\"]";
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath_skolko_stoit)));
        String textFact = driver.findElement(By.xpath("//*[@id=\"accordion__panel-4\"]")).getText(); // Найди поле и получить её текст
        String textExpected = "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.";
        Boolean areTextsEqual = Objects.equals(textFact, textExpected);
        System.out.println("areTextsEqual: " + areTextsEqual);
        System.out.println("textFact: " + textFact);
        System.out.println("textExpected: " + textExpected);
    }

    public void test6() {
        clickByLocator(signTogetherInField);
        String xpath_skolko_stoit = "//*[@id=\"accordion__panel-5\"]";
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath_skolko_stoit)));
        String textFact = driver.findElement(By.xpath("//*[@id=\"accordion__panel-5\"]")).getText(); // Найди поле и получить её текст
        String textExpected = "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.";
        Boolean areTextsEqual = Objects.equals(textFact, textExpected);
        System.out.println("areTextsEqual: " + areTextsEqual);
        System.out.println("textFact: " + textFact);
        System.out.println("textExpected: " + textExpected);
    }
    public void test7() {
        clickByLocator(signCancelInField);
        String xpath_skolko_stoit = "//*[@id=\"accordion__panel-6\"]";
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath_skolko_stoit)));
        String textFact = driver.findElement(By.xpath("//*[@id=\"accordion__panel-6\"]")).getText(); // Найди поле и получить её текст
        String textExpected = "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.";
        Boolean areTextsEqual = Objects.equals(textFact, textExpected);
        System.out.println("areTextsEqual: " + areTextsEqual);
        System.out.println("textFact: " + textFact);
        System.out.println("textExpected: " + textExpected);
    }

    public void test8() {
        clickByLocator(signLifeInField);
        String xpath_skolko_stoit = "//*[@id=\"accordion__panel-7\"]";
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath_skolko_stoit)));
        String textFact = driver.findElement(By.xpath("//*[@id=\"accordion__panel-7\"]")).getText(); // Найди поле и получить её текст
        String textExpected = "Да, обязательно. Всем самокатов! И Москве, и Московской области.";
        Boolean areTextsEqual = Objects.equals(textFact, textExpected);
        if (!areTextsEqual) {
            System.out.println(driver.getPageSource());
        }
        System.out.println("areTextsEqual: " + areTextsEqual);
        System.out.println("textFact: " + textFact);
        System.out.println("textExpected: " + textExpected);
    }


}

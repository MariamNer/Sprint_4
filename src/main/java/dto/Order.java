package dto;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class Order {
    private WebDriver driver;
    private By nameField = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[1]/input");
    private By surnameField = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[2]/input");
    private By addressField = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[3]/input");
    private By metroField = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[4]/div/div/input");
    private By telepfonField = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[5]/input");
    private By signInButton = By.xpath("//*[@id=\"root\"]/div/div[2]/div[3]/button");
    private By metroSingIn = By.className("select-search__select");

    private By whenToBringField = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[1]/div[1]/div");
    private By rentalPeriod = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[2]/div[1]/div[1]");

    private By buttonOrder = By.className("Button_Button__ra12g Button_Middle__1CSJM");

    private By buttonYes = By.xpath("//*[@id=\"root\"]/div/div[2]/div[5]/div[2]/button[2]");

    private By successOrder = By.xpath("//*[@id=\"root\"]/div/div[2]/div[5]/div[1]/text()");

    public Order(WebDriver driver){
        this.driver = driver;
    }

    public void setName(String name) {
        driver.findElement(nameField).sendKeys(name);
    }
    public void setSurname(String surname){
        driver.findElement(surnameField).sendKeys(surname);
    }
    public void setAddress(String address){
        driver.findElement(addressField).sendKeys(address);
    }
    public void clickMetro() {
        driver.findElement(metroField).click();
    }
    public void setTelepfon(String telepfon){
        driver.findElement(telepfonField).sendKeys(telepfon);
    }
    public void clickSignInButton() {
        driver.findElement(signInButton).click();
    }
    public void clickMetroSingIn() {
        driver.findElement(metroSingIn).click();
    }
    public void fill_out_form(String name, String surname, String address, String metro, String telepfon){
        setName(name);
        setSurname(surname);
        setAddress(address);
        clickMetro();
        setTelepfon(telepfon);
        clickSignInButton();
        clickMetroSingIn();
    }

    public void setWhenToBring(String whenToBring){
        driver.findElement(whenToBringField).sendKeys(whenToBring);
    }

    public void clickrentalPeriod(){
        driver.findElement(rentalPeriod).click();
    }

    public void clickButtonOrder(){
        driver.findElement(buttonOrder).click();
    }

    public void clickButtonYes(){
        driver.findElement(buttonYes).click();
    }

    public void setSuccessOrder(By successOrder){
        driver.findElement(successOrder).getText();
    }

    public void fill_out_form_rental(String whenToBring){
        setWhenToBring(whenToBring);
        clickrentalPeriod();
        clickButtonOrder();
        clickButtonYes();
        setSuccessOrder(successOrder);
    }
}

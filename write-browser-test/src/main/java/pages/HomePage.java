package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    private static final By startTest = By.xpath("//button[contains(text(),'Start The Test')]");
    private static WebDriver driver;


    public HomePage(WebDriver driver) {
        HomePage.driver = driver;
    }

    public static ChallengePage clickFormAuthLink() {
        driver.findElement(startTest).click();
        return new ChallengePage(driver);
    }

    public boolean verifyHomePage() {
        Boolean message = driver.getPageSource().contains("We are an engineering consultancy specialising in Cloud Platforms, Quality Engineering and Developer Experience");
        return message;

    }

}



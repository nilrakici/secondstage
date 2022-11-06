package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ChallengePage<puclic> {
    private final WebDriver driver;

    private final By row1 = By.cssSelector("tr:nth-child(1) > td");
    private final By row2 = By.cssSelector("tr:nth-child(2) > td");
    private final By row3 = By.cssSelector("tr:nth-child(3) > td");
    private final By row4 = By.cssSelector("tr:nth-child(4) > td");

    private final By solveTheChallenge = By.xpath("//h1[@class='jsx-3883475262 bannerHeader titleLarge']");

    public ChallengePage(WebDriver driver) {
        this.driver = driver;
    }

    public int findIndex(By element) {
        List<WebElement> rows = driver.findElements(element);
        int size = rows.size();
        int[] arr = new int[size];

        for (int i = 0; i < size; i++) {
            arr[i] = Integer.parseInt((rows.get(i).getText()));
        }
        int right_sum = 0, left_sum = 0;


        for (int i = 1; i < size; i++)
            right_sum += arr[i];

        for (int i = 0, j = 1; j < size; i++, j++) {
            right_sum -= arr[j];
            left_sum += arr[i];

            if (left_sum == right_sum)
                return i + 1;
        }
        return -1;
    }

    public boolean verifyChallengePage() {
        Boolean challenge = driver.findElement(solveTheChallenge).isDisplayed();
        return challenge;

    }

    public boolean verifySolutions() {
        return findIndex(row1) == -1 && findIndex(row2) == 4 && findIndex(row3) == 3 && findIndex(row4) == 5;
    }
}
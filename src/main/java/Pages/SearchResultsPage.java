package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.ITest;
import org.testng.ITestResult;
import org.testng.TestNG;
import org.testng.annotations.Test;

import java.util.List;

import static org.openqa.selenium.support.locators.RelativeLocator.with;

public class SearchResultsPage extends PageBase {
    public SearchResultsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//tbody/tr[1]/td[3]/a[1]")
    WebElement secondResultsPage;
    @FindBy(id = "rso")
    WebElement searchResults;

    public void goToSecondPage() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement pageNavigator = driver.findElement(with(By.tagName("td")).below(driver.findElement(By.id("bres"))));
        js.executeScript("arguments[0].scrollIntoView(true)", pageNavigator);
        Thread.sleep(500);
        secondResultsPage.click();
    }

    public void validateLinkOfSecondResult() {
        List<WebElement> results = searchResults.findElements(By.xpath("//div[@id=\"rso\"]/div"));
        for (WebElement result : results) {
            System.out.println(results.size());
            System.out.println(results.get(1).getText());
            if (results.get(1).getText().contains("https://www.linkedin.com")) {
                System.out.println("Info found");
            } else {
                System.out.println("SECOND RESULT HAS NO LINKEDIN LINK");
            }
                break;
            }

        }
    }

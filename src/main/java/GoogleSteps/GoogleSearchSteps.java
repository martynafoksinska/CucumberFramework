package GoogleSteps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleSearchSteps {

    WebDriver driver;

    @Given("user is on Google page")
    public void openGoogleSearch() throws InterruptedException {

        System.setProperty("webdriver.chrome.driver",
                "src/main/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://www.google.com");
        WebElement acceptPopup = driver.findElement(By.id("L2AGLb"));
        acceptPopup.click();
        Thread.sleep(2000);
    }

    @When("{string} is entered in input field")
    public void enterKeyword(String keyword) {
        WebElement element = driver.findElement(By.name("q"));
        element.clear();
        element.sendKeys(keyword);
        element.submit();
    }

    @Then("the first result should contain selenium")
    public void theFirstResultShouldContainSelenium(String expectedText) {
        System.out.println(expectedText);
    }

    @And("browser is closed")
    public void browserIsClosed() {
        driver.quit();
    }
}
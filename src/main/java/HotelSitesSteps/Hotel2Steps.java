package HotelSitesSteps;

import Pages.LandingPage;
import Pages.LoginPage;
import Pages.RegistrationPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.v85.media.model.Timestamp;

public class Hotel2Steps {

    WebDriver driver;
    Timestamp timestamp = new Timestamp(System.currentTimeMillis());
    String email = "test" + timestamp + "@test.com";

    @Given("User is on home page")
    public void enterPage() {
        System.setProperty("webdriver.chrome.driver",
                "src/main/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://hotel-testlab.coderslab.pl/.");
    }

    @When("Human clicks on Sign In button")
    public void SignIn() {
        LandingPage onLandingPage = new LandingPage(driver);
        onLandingPage.clickOnSingIn();

    }

    @And("User writes e-mail address into input and clicks Create An Account button")
    public void creatingAccount() {
        LoginPage onLoginPage = new LoginPage(driver);
        onLoginPage.authentication(email);
    }

    @And("User fills up the registration form and click Register button")
    public void formAndRegisterButton() throws InterruptedException {
        RegistrationPage onRegistrationPage = new RegistrationPage(driver);
        onRegistrationPage.createAccount();
        onRegistrationPage.registerButton();
    }

    @Then("Account has been created")
    public void browserIsClosed() {
        driver.quit();
    }
}